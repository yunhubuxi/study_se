package juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample3 {

    private final static int threadCount = 10;

    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newCachedThreadPool();

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        exec.execute(() -> {
            try {
                countDownLatch.await();
                System.out.println("aaa");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        exec.execute(() -> {
            try {
                countDownLatch.await();
                System.out.println("bbb");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    test(threadNum);
                } catch (Exception e) {
                    System.err.println(e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.out.println("finish");
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName() + " = "+threadNum);
    }
}
