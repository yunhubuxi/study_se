package thread.pool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 队列满了之后，再来了任务，会启动新的线程来从队列中取任务来执行
 * 达到最大线程之后，如果队列也满了，还继续提交任务的话，就会触发拒绝策略
 */
public class ThreadPoolTest1 {
    public static void main(String[] args) {
        AtomicInteger result = new AtomicInteger(0);
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
        for (int i = 0; i < 100; i++) {
            execService.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + result.incrementAndGet());
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

}
