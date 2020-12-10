package threads.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Object> objectCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("11111111111");
                Thread.sleep(50000);
                System.out.println("11111111111");
                return "1111";
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        });
        CompletableFuture<Object> objectCompletableFuture2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("2222222222");
                Thread.sleep(5000);
                System.out.println("2222222222222");
                return "222222222222";
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        });
        CompletableFuture<Object> objectCompletableFuture3 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("3333333");
                Thread.sleep(5000);
                System.out.println("333333333333");
                return "33333";
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        });
        System.out.println("aaa");
        System.out.println(objectCompletableFuture1.get().toString());
        System.out.println("bbb");
        System.out.println(objectCompletableFuture2.get().toString());
        System.out.println("cccc");
        System.out.println(objectCompletableFuture3.get().toString());

    }
}
