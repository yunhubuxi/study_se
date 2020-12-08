package threads.future;

import java.util.concurrent.*;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

public class CompletableFutureSample {
    public static void main(String[] args)  {
        boolean flag = true;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // 直接创建一个已经做完的蛋糕
        CompletableFuture<String> future1 = CompletableFuture.completedFuture("cake");
        // 无返回值异步任务，会采用内部forkjoin线程池
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            System.out.println("fffff");
            throw new RuntimeException("ffff");
        });
        // 无返回值异步任务，采用定制的线程池
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("bbb");
        }, executorService);
        // 返回值异步任务，采用定制的线程池
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> "cake", executorService);
        // 返回值异步任务，采用内部forkjoin线程池
        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> "cake");
        // 只要有一个完成，则完成，有一个抛异常，则携带异常
        // CompletableFuture<Object> future = CompletableFuture.anyOf(future1, future2, future3, future4, future5);
        // 当所有的 future 完成时,新的 future 同时完成
        // 当某个方法出现了异常时,新 future 会在所有 future 完成的时候完成,并且包含一个异常.
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(future1, future2, future3, future4, future5);
        try {
            voidCompletableFuture.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
            flag = false;
            voidCompletableFuture.cancel(true);
            System.out.println("任务执行失败");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            flag = false;
            System.out.println("任务执行失败");
        }
        if (flag) {
            voidCompletableFuture.handle((BiFunction<Void, Throwable, Void>) (aVoid, throwable) -> {
                if (null == throwable) {
                    System.out.println("任务执行完成");
                    return null;
                } else {
                    System.out.println("任务执行失败");
                    return null;
                }
            });
        } else {
            System.out.println("==============");
        }

        executorService.shutdown();
    }

}
