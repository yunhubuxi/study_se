package lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockDemotionUpgradeTest {
    public static void main(String[] args) {
        locDemotionTest();
        lockUpgradeTest();
    }

    /**
     * 锁升级测试
     * 在同一个线程中，在没有释放锁的情况下，就去申请写锁，这属于锁升级，ReentrantReadWriteLock不支持
     */
    public static void lockUpgradeTest() {
        ReentrantReadWriteLock rtLock = new ReentrantReadWriteLock();
        rtLock.readLock().lock();
        System.out.println("writeLock");
        rtLock.writeLock().lock();
        System.out.println("get read lock");
    }
    /**
     * 锁降级测试
     * ReentrantReadWriteLock支持锁降级
     * 下面代码不会产生死锁
     * 这段代码虽然不会导致死锁，但没有正确的释放锁
     * 从写锁降级成读锁，并不会自动释放当前线程获取的写锁，仍然需要显示的释放，否则别的线程永远也获取不到写锁。
     *
     */
    public static void locDemotionTest() {
        ReentrantReadWriteLock rtLock = new ReentrantReadWriteLock();
        rtLock.writeLock().lock();
        System.out.println("writeLock");
        rtLock.readLock().lock();
        System.out.println("get read lock");
    }
}
