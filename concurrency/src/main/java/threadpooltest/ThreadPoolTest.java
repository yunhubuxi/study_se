package threadpooltest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 第一个任务：创建线程
 * 第二个任务：加入队列，第一次创建的线程会不断的从队列中获取任务去执行，只要入列成功，就自动执行了
 * Worker是一个拥有线程的任务
 * 执行任务的时候会去调用ThreadPoolExecutor的runWorker方法，所以runWorker方法会有很多个线程调用
 * runWorker并不是上了全局锁，而是每个woker上了一把自己的锁，这把锁的作用实际上是为了响应中断。
 */
public class ThreadPoolTest {
    private static ExecutorService execService = Executors.newFixedThreadPool(2);
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        execService.execute(() -> {
            lock1.lock();
            try {
                TimeUnit.SECONDS.sleep(20);
                System.out.println("aaa");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock1.unlock();
            }
        });

        execService.execute(() -> {
            lock2.lock();
            System.out.println("bbb");
        });


        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (lock1.tryLock()) {
            System.out.println("获取lock1成功");
        }
        if (lock2.tryLock()) {
            System.out.println("获取lock2失败");
        }
        execService.shutdown();
    }


}
