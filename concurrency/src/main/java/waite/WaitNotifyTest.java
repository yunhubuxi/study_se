package waite;

import java.util.concurrent.TimeUnit;

/**
 * 获取监视器的线程执行notify或者notifyAll方法并不会释放锁、
 * 只是唤醒其他线程开始抢占锁
 * 退出代码块后才会真的释放锁
 */
public class WaitNotifyTest {
    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(() -> {
            System.out.println("thread A is waiting to get lock");
            synchronized (lock) {
                try {
                    System.out.println("thread A get lock");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("thread A do wait method");
                    lock.wait();
                    System.out.println("A wait end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            System.err.println("thread B is waiting to get lock");
            synchronized (lock) {
                System.err.println("thread B get lock");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.notify();
                System.err.println("thread B do notify method");
                try {
                    TimeUnit.SECONDS.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }
}
