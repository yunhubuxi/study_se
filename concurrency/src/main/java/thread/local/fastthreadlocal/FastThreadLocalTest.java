package thread.local.fastthreadlocal;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FastThreadLocalTest {
    private static FastThreadLocal<Integer> fastThreadLocal = new FastThreadLocal<>();
    private static ExecutorService execService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        execService.execute(new FastThreadLocalThread(() -> System.out.println("fff")));

        //if (thread instanceof FastThreadLocalThread) 使用FastThreadLocalThread更优，普通线程也可以
        new FastThreadLocalThread(() -> {
            for (int i = 0; i < 100; i++) {
                fastThreadLocal.set(i);
                System.out.println(Thread.currentThread().getName() + "====" + fastThreadLocal.get());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "fastThreadLocal1").start();


        new FastThreadLocalThread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "====" + fastThreadLocal.get());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "fastThreadLocal2").start();
    }
}
