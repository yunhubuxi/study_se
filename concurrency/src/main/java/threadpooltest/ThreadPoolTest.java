package threadpooltest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 第一个任务：创建线程
 * 第二个任务：加入队列，第一次创建的线程会不断的从队列中获取任务去执行，只要入列成功，就自动执行了
 */
public class ThreadPoolTest {
    private static ExecutorService execService = Executors.newFixedThreadPool(1);
    public static void main(String[] args) {
        execService.execute(() -> System.out.println("aaa"));
        execService.execute(() -> System.out.println("bbb"));
    }

    Lock lock = new ReentrantLock();
}
