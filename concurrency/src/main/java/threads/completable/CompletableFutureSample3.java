package threads.completable;

import java.util.concurrent.*;

/**
 * RocketMQ中使用了Java8提供的CompletableFuture
 * 但是并没有使用CompletableFuture的异步功能
 * 仅仅使用了completedFuture和thenApply方法
 */
public class CompletableFutureSample3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> happly = CompletableFuture.completedFuture(test("happly"));
        System.out.println("==============");
        System.out.println(happly.get());
        System.out.println("==============");
    }

    private static String test(String request) {
        System.out.println(request);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "+++ " + request + " +++";
    }
}
