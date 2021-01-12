package threads.completable;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

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

        future.whenComplete((t, action) ->
            {
                if (action == null) {
                    System.out.println("执行完成！");
                } else {
                    System.out.println("1执行失败！" + action.getMessage());
                }
            }
            );
        future.exceptionally(t -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("2执行失败！" + t.getMessage());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });
        future.thenRun(() -> System.out.println("aaa"));
        future.thenRun(() -> System.out.println("ccc"));
        future.thenRun(() -> System.out.println("bbb"));

        TimeUnit.SECONDS.sleep(8);
    }

    /**
     * 当一个线程依赖另一个线程时，可以使用 thenApply 方法来把这两个线程串行化
     * @throws Exception
     */
    private static void thenApply() throws Exception {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            long result = new Random().nextInt(100);
            System.out.println("result1="+result);
            System.out.println(4/0);
            return result;
        }).thenApply(t -> {
            long result = t*5;
            System.out.println("result2="+result);
            return result;
        });

        long result = future.get();
        System.out.println(result);
    }

    /**
     * handle 是执行任务完成时对结果的处理。
     * handle 方法和 thenApply 方法处理方式基本一样
     * 不同的是 handle 是在任务完成后再执行，还可以处理异常的任务
     * thenApply 只可以执行正常的任务，任务出现异常则不执行 thenApply 方法
     * @throws Exception
     */
    public static void handle() throws Exception{
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int i= 10/0;
            return new Random().nextInt(10);
        }).handle((param, throwable) -> {
            int result = -1;
            if(throwable==null){
                result = param * 2;
            }else{
                System.out.println(throwable.getMessage());
            }
            return result;
        });
        System.out.println(future.get());
    }

    /**
     * 接收任务的处理结果，并消费处理，无返回结果
     * @throws Exception
     */
    public static void thenAccept() throws Exception{
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(10);
            }
        }).thenAccept(integer -> {
            System.out.println(integer);
        });
        future.get();
    }

    /**
     * 跟 thenAccept 方法不一样的是，不关心任务的处理结果。只要上面的任务执行完成，就开始执行 thenAccept
     * @throws Exception
     */
    public static void thenRun() throws Exception{
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> new Random().nextInt(10)).thenRun(() -> {
            System.out.println("thenRun ...");
        });
        future.get();
    }

    /**
     * thenCombine 会把 两个 CompletionStage 的任务都执行完成后，把两个任务的结果一块交给 thenCombine 来处理
     */
    private static void thenCombine() throws Exception {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "hello");
        CompletableFuture<String> result = future1.thenCombine(future2, (t, u) -> t+" "+u);
        System.out.println(result.get());
    }


}
