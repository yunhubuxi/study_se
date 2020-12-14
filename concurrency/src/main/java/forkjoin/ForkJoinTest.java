package forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

/**
 * 分治法
 * 分治法的基本思想是将一个规模为N的问题分解为K个规模较小的子问题
 * 这些子问题的相互独立且与原问题的性质相同，求出子问题的解之后
 * 将这些解合并，就可以得到原有问题的解。是一种分目标完成的程序算法。简单的问题
 * 可以用二分法来完成。
 * <p>
 * work-stealing
 * ForkJoin的核心思想是work-stealing，工作窃取的意思
 * 工作窃取是指当某个线程的任务队列中没有可执行任务的时候
 * 从其他线程的任务队列中窃取任务来执行，以充分利用工作线程的计算能力
 * 减少线程由于获取不到任务而造成的空闲浪费。在ForkJoinpool中
 * 工作任务的队列都采用双端队列Deque容器。我们知道，在通常使用队列的过程中
 * 我们都在队尾插入，而在队头消费以实现FIFO。而为了实现工作窃取
 * 一般我们会改成工作线程在工作队列上LIFO,而窃取其他线程的任务的时候，从队列头部取获取
 */
public class ForkJoinTest {
    public static void main(String[] args) throws Exception{
        testHasResultTask();
    }

    private static void testNoResultTask() throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(new PrintTask(1, 50000));
        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();
    }

    public static void testHasResultTask() throws Exception {
        int result1 = 0;
        for (int i = 1; i <= 1000000; i++) {
            result1 += i;
        }
        System.out.println("循环计算 1-1000000 累加值：" + result1);

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> task = pool.submit(new CalculateTask(1, 1000000));
        int result2 = task.get();
        System.out.println("并行计算 1-1000000 累加值：" + result2);
        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();
    }
}
