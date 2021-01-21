package lock;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
    public static void main(String[] args) throws Exception {
        test4();
    }

    /**
     * 最终只会输出 "begin park！"
     */
    private static void test1() {
        System.out.println("begin park!");
        LockSupport.park();
        System.out.println("end park!");
    }

    private static void test2() {
        System.out.println("begin park!");
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("end park!");
    }

    private static void test3() throws Exception {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park!");
                // 挂起自己
                LockSupport.park();
                System.out.println("child thread unpark!");
            }
        });

        thread.start();
        // 确保调用unpark前子线程已经将自己挂起
        Thread.sleep(1000);

        System.out.println("main thread begin unpark!");

        LockSupport.unpark(thread);
    }

    private static void test4() {
        System.out.println("begin park!");
        // 十秒钟
        LockSupport.parkNanos(10000000000L);
        System.out.println("end park!");
    }

}
