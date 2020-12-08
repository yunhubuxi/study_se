package threads.future;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Future和Callable需要借助ExecutorService才能使用
 * ExecutorService实际上是借助了RunnableFuture的实现类FutureTask来完成的
 * Future、Callable、Runnable可以直接借助FutureTask，脱离ExecutorService，但是不能脱离Thread而运行
 * FutureTask可以把Runnable转换成Callable来执行
 * FutureTask实际上还是一个Task，只是持有了线程的句柄，自身并不能执行，还需要穿上Thread的衣服
 * CompletableFuture实现了Future和CompletionStage接口，具有了Future持有线程句柄的功能，同时具有编排线程的功能
 * 最重要的是CompletableFuture自身具有线程池的功能，所以不仅仅是Task，也不仅仅是持有线程的句柄，自己就可以执行Task
 * CompletableFuture是整合了Future和ExecutorService，并且添加了编排线程的功能
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        whenComplete();

    }

    // 无返回值
    public static void runAsync() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run end ...");
        });
        future.get();
    }


    //有返回值
    public static void supplyAsync() throws Exception {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            System.out.println("run end ...");
            return System.currentTimeMillis();
        });

        long time = future.get();
        System.out.println("time = " + time);
    }

    /**
     * 计算结果完成时的回调方法
     * @throws Exception
     */
    public static void whenComplete() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            if (new Random().nextInt() % 2 >= 0) {
                int i = 12 / 0;
            }
            System.out.println("run end ...");
        });

        future.whenComplete((t, action) -> System.out.println("执行完成！"));
        future.exceptionally(t -> {
            System.out.println("执行失败！" + t.getMessage());
            return null;
        });

        TimeUnit.SECONDS.sleep(2);
    }
}
