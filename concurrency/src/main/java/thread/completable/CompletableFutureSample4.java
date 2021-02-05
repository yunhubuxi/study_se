package thread.completable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class CompletableFutureSample4 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<CompletableFuture> futures = new ArrayList();
        List<String> result = new ArrayList<>();
        // 直接创建一个已经做完的蛋糕
        CompletableFuture<String> future1 = CompletableFuture.completedFuture("cake");
        future1.thenAccept( string -> {
            try {
                System.out.println("===cake===");
                TimeUnit.SECONDS.sleep(6);
                result.add(string);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        futures.add(future1);
        // 无返回值异步任务，会采用内部forkjoin线程池
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("===future2");
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, executorService);
        future2.thenAccept( string -> {
            try {
                System.out.println(string.toString());
                System.out.println("===future2===");
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        futures.add(future2);
        // 无返回值异步任务，采用定制的线程池
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("===future3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, executorService);
        futures.add(future3);
        // 返回值异步任务，采用定制的线程池
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future4");
            return "future4";
        }, executorService);
        future4.thenAccept(string ->{
            result.add(string);
        });

        futures.add(future4);
        // 返回值异步任务，采用内部forkjoin线程池
        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future5");
            return "future5";
        });

        futures.add(future5);
        // 不确定有几个furure，该怎么办呢？
        // CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        futures = new ArrayList<>();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).join();
        System.out.println("运行结束");
        for (String s : result) {
            System.out.println(s);
        }
    }

}
