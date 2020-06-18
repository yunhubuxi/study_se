package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ShareLock implements Lock {
    static class Sync extends AbstractQueuedSynchronizer {
        private int count;

        Sync(int count) {
            this.count = count;
        }

        @Override
        protected int tryAcquireShared(int arg) {
            for (; ; ) {
                int current = getState();
                int newCount = current - arg;
                if (newCount < 0 || compareAndSetState(current, newCount)) {
                    return newCount;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            for (; ; ) {
                int current = getState();
                int newCount = current + arg;
                if (compareAndSetState(current, newCount)) {
                    return true;
                }
            }
        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }

    private int count;
    private Sync sync;

    public ShareLock(int count) {
        this.count = count;
        sync = new Sync(count);
    }

    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquireShared(1) >= 0;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireSharedNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
