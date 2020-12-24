package threads.completable;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest1 {
    public static void main(String[] args) throws Exception{
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("aaa");
                System.out.println(Thread.currentThread().getName());
                return "aaa";
            } catch (Exception e) {
                return null;
            }
        });
        System.out.println("completableFuture1 = " + LocalDateTime.now().toString());
        CompletableFuture<List<String>> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("bbb");
                System.out.println(Thread.currentThread().getName());
                return Arrays.asList("bbb");
            } catch (Exception e) {
                return null;
            }
        });
        System.out.println("completableFuture2 = " + LocalDateTime.now().toString());
        CompletableFuture<List<String>> completableFuture3= CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("ccc");
                System.out.println(Thread.currentThread().getName());
                return Arrays.asList("ccc");
            } catch (Exception e) {
                return null;
            }
        });
        System.out.println("completableFuture3 = " + LocalDateTime.now().toString());
        CompletableFuture<List<String>> completableFuture4 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("ddd");
                System.out.println(Thread.currentThread().getName());
                return Arrays.asList("ddd");
            } catch (Exception e) {
                return null;
            }
        });
        System.out.println("completableFuture4 = " + LocalDateTime.now().toString());
        TimeUnit.SECONDS.sleep(5);
        System.out.println(completableFuture1.get());
        System.out.println(completableFuture2.get());
        System.out.println(completableFuture3.get());
        System.out.println(completableFuture4.get());
    }



}
