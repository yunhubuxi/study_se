package completable;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest2 {
    public static void main(String[] args) throws Exception{
        CompletableFuture<List<String>> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                return test1();
            } catch (Exception e) {
                return null;
            }
        });
        System.out.println("completableFuture1" + LocalDateTime.now().toString());
        CompletableFuture<List<String>> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                return test2();
            } catch (Exception e) {
                return null;
            }
        });
        System.out.println("completableFuture2" + LocalDateTime.now().toString());
        System.out.println(completableFuture1.get());
        System.out.println(completableFuture2.get());
    }


    public static List<String> test1() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("aaa");
                System.out.println(Thread.currentThread().getName());
                return "aaa";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        });
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(8);
                System.out.println("bbb");
                System.out.println(Thread.currentThread().getName());
                return "bbb";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        });
        return Arrays.asList(completableFuture1.get(), completableFuture2.get());
    }

    public static List<String> test2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("ccc");
                System.out.println(Thread.currentThread().getName());
                return "ccc";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        });
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("ddd");
                System.out.println(Thread.currentThread().getName());
                return "ddd";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        });
        return Arrays.asList(completableFuture1.get(), completableFuture2.get());
    }
}
