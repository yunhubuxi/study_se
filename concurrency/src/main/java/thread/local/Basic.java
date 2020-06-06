package thread.local;

public class Basic {
    public static ThreadLocal<Long> x = ThreadLocal.withInitial(() -> {
        System.out.println("initialValue...");
        return Thread.currentThread().getId();
    });


    public static void main(String[] args) {
        new Thread(() -> System.out.println(x.get())).start();
        new Thread(() -> System.out.println(x.get())).start();
        new Thread(() -> System.out.println(x.get())).start();
        x.set(10000L);
        x.set(2000L);
        System.out.printf("main => %d%n", x.get());
    }
}
