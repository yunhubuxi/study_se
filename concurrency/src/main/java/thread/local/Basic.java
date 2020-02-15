package thread.local;

public class Basic {
    public static ThreadLocal<Long> x = ThreadLocal.withInitial(() -> {
        System.out.println("initialValue...");
        return 100L;
    });


    public static void main(String[] args) {
        System.out.println(x.get());
        System.out.println(x.get());
    }
}
