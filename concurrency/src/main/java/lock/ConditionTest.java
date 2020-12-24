package lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  主线程如果不等待的话，就会发生死锁
 * 因为主线程获取锁后，唤醒其等待队列中所有任务的时候，有几个任务还没有加到等待队列
 * 只有获取到了锁，才有可能加入到等待队列，所以加入等待队列也是串行的
 * 这样主线程释放了锁，执行完毕，之后加入到等待队列中的任务获取锁，释放锁后，没有人唤醒了
 * 就会一直等待被人唤醒
 * lock锁可以有同步队列和多个等待队列
 * condition必须由lock创建，condition的实现类在AQS中
 */

public class ConditionTest {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(ConditionTest::run);
        executorService.execute(ConditionTest::run);
        executorService.execute(ConditionTest::run);
        // try {
        //     TimeUnit.SECONDS.sleep(2);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        lock.lock();
        condition.signalAll();
        lock.unlock();
        executorService.shutdown();

    }

    private static void run() {
        lock.lock();
        System.out.println("AAA");
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("BBB");
        lock.unlock();
    }
}
