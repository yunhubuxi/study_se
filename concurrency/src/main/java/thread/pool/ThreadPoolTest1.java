package thread.pool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 队列满了之后，再来了任务，会启动新的线程来从队列中取任务来执行
 * 达到最大线程之后，如果队列也满了，还继续提交任务的话，就会触发拒绝策略
 */
public class ThreadPoolTest1 {
    public static void main(String[] args) throws Exception {
        AtomicInteger print = new AtomicInteger(0);
        ExecutorService execService = new ThreadPoolExecutor(10,
                30, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10),
                new ThreadFactory() {
                    private AtomicInteger threadIndex = new AtomicInteger(0);

                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "test-" + this.threadIndex.incrementAndGet() + "-");
                    }
                },
                new ThreadPoolExecutor.AbortPolicy());
        ExecutorService execServiceNew = new ThreadPoolExecutor(10,
                30, 60, TimeUnit.SECONDS, new MyQueue<>(10),
                new ThreadFactory() {
                    private AtomicInteger threadIndex = new AtomicInteger(0);

                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "test-" + this.threadIndex.incrementAndGet() + "-");
                    }
                },
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 40; i++) {
            TimeUnit.SECONDS.sleep(1);
            execServiceNew.execute(() -> {
                try {
                    System.err.println(print.incrementAndGet() + "：活动线程数：" + ((ThreadPoolExecutor) execServiceNew).getActiveCount() + "；队列中任务数：" + ((ThreadPoolExecutor) execServiceNew).getQueue().size());
                    TimeUnit.SECONDS.sleep(35);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    static class MyQueue<E> extends LinkedBlockingQueue {
        public MyQueue(int capacity) {
            if (capacity <= 0) throw new IllegalArgumentException();
        }
        public boolean offer(E e, ThreadPoolExecutor executor) {
            if (executor.getQueue().size() < 30) {
                return false;
            }
            super.offer(e);
            return true;
        }
    }

}
