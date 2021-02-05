package thread.completable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * thenAcceptAsync可指定线程池，在allOf-》join的时候，不会等待执行完成，一般不要使用
 * thenAccept不可指定线程池，会等待执行完成
 */
public class CompletableFutureSample5 {
    static ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        List<CompletableFuture> futures = new ArrayList();
        List<String> result = new ArrayList<>();
        CompletableFuture<String> future1 = CompletableFuture.completedFuture("test");
        CompletableFuture<Void> future = future1.thenAccept(string -> {
            try {
                System.out.println("===test===");
                TimeUnit.SECONDS.sleep(6);
                result.add(string);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        future1.thenRunAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("===aaa===");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },executorService);
        future.thenRunAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("===bbb===");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },executorService);
        futures.add(future1);
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).join();
        System.out.println("运行结束");
        for (String s : result) {
            System.out.println(s);
        }
    }

}
