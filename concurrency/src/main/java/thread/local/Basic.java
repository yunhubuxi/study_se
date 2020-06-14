package thread.local;

public class Basic {
    public static ThreadLocal<Long> x = new ThreadLocal<>();
    public static ThreadLocal<Long> y = ThreadLocal.withInitial(() -> {
        System.out.println("initialValue...");
        return Thread.currentThread().getId();
    });


    public static void main(String[] args) {
        // new Thread(() -> System.out.println(x.get()),"a").start();
        // new Thread(() -> System.out.println(x.get()),"b").start();
        // new Thread(() -> System.out.println(x.get()),"c").start();
        // new Thread(() -> System.out.println(x.get()),"d").start();
        // new Thread(() -> System.out.println(x.get()),"e").start();
        // new Thread(new MyThread(),"a").start();
        // new Thread(new MyThread(),"b").start();
        y.set(3000L);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("...");
        System.out.printf("main => %d%n", x.get());
        System.out.printf("main => %d%n", y.get());
    }

    static class MyThread implements Runnable{

        @Override
        public void run() {
            System.out.println(x.get());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
