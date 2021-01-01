package order;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OrderPrint2 {
    private static Lock lock = new ReentrantLock();
    private static int count = 0;
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();

    static class ThreadA extends Thread {

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.print("A");
                    count++;
                    B.signal(); // 唤醒相应线程
                    A.await();
                }
                B.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadB extends Thread {

        @Override
        public void run() {
            lock.lock();
            try {
                if (count == 0) {
                    B.await();
                    C.signal();
                }
                for (int i = 0; i < 10; i++) {
                    System.out.print("B");
                    C.signal();
                    B.await();
                }
                C.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    static class ThreadC extends Thread {

        @Override
        public void run() {
            lock.lock();
            try {
                if (count == 0) {
                    C.await();
                    A.signal();
                }
                for (int i = 0; i < 10; i++) {
                    System.out.println("C");
                    A.signal();
                    C.await();
                }
                A.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
        TimeUnit.SECONDS.sleep(5);
        System.out.println(count);
    }
}
