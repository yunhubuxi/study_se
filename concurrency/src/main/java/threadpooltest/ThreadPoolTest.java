package threadpooltest;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 第一个任务：创建线程
 * 第二个任务：加入队列，第一次创建的线程会不断的从队列中获取任务去执行，只要入列成功，就自动执行了
 */
public class ThreadPoolTest {
    private static ExecutorService execService = Executors.newFixedThreadPool(1);
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        execService.execute(() -> {
            lock1.lock();
            try {
                TimeUnit.SECONDS.sleep(2);
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
    }


}
