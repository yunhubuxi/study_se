package thread.completable;

import java.util.concurrent.*;

/**
 * voidCompletableFuture使用get方法的时候，如果有超时参数
 * 超时之后，外部线程池里的任务不会停止，会继续执行
 * voidCompletableFuture的handle会等待所有线程执行完毕，包括外部线程中的任务
 * 如果handle在get之后执行，那么如果线程都执行完了，handle不会有任务操作
 * handle的时候，如果线程已经执行完了，handle就没有意义了
 * handle只能捕获最后一个任务的线程，如果有任务提前抛出了线程，handle不能捕获，也不会执行，任务之间完成
 * 我觉得如果使用allOf，那么里面的任务只要有一个使用了外部线程池，那么voidCompletableFuture只能捕获外部线程池中的异常
 */
public class CompletableFutureSample2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        boolean flag = true;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // 直接创建一个已经做完的蛋糕
        // CompletableFuture<String> future1 = CompletableFuture.completedFuture("cake");
        // 无返回值异步任务，会采用内部forkjoin线程池
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future2");
            throw new RuntimeException("future2");
        }, executorService);
        // 无返回值异步任务，采用定制的线程池
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future3");
        });
        // 返回值异步任务，采用定制的线程池
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future4");
            return "future4";
        }, executorService);
        // 返回值异步任务，采用内部forkjoin线程池
        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future5");
            return "cake";
        });
        // 只要有一个完成，则完成，有一个抛异常，则携带异常
        CompletableFuture<Object> future = CompletableFuture.anyOf(future2, future3, future4, future5);
        // 当所有的 future 完成时,新的 future 同时完成
        // 当某个方法出现了异常时,新 future 会在所有 future 完成的时候完成,并且包含一个异常.
        Object object = future.get();
        System.out.println(object.toString());
        executorService.shutdown();
    }

}
