package thread.completable;


import java.util.concurrent.*;

/**
 * 方法2和方法3有点看不懂
 */
public class CompletableFutureTest6 {
    static Executor executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws Exception {
        test2();
        // test3();
    }

    static void test1() {
        CompletableFuture<String> main = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world main  " + System.currentTimeMillis());
            return "result main";
        }, executor);

        main.whenComplete((a, b) -> System.out.println(Thread.currentThread() + " " + a + " " + System.currentTimeMillis()));

        CompletableFuture<String> f2 = main.thenApplyAsync(r -> {
            try {
                System.out.println(Thread.currentThread() + " hello world f2  " + System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "f2";
        }, executor);
        CompletableFuture<String> f1 = main.thenApply(r -> {
            try {
                System.out.println(Thread.currentThread() + " hello world f1  " + System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "f1";
        });
        CompletableFuture<String> f3 = f2.thenApply(r -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world f3  " + System.currentTimeMillis());
            return "f3";
        });
        CompletableFuture<String> f4 = f2.thenApply(r -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world f4  " + System.currentTimeMillis());
            return "f4";
        });
    }

    static void test2() {
        CompletableFuture<String> main = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "test2 hello world main  " + System.currentTimeMillis());
            return "result main";
        }, executor)
                .thenApply(r -> {
                    try {
                        TimeUnit.SECONDS.sleep(30);
                        System.out.println(Thread.currentThread() + "test2 hello world f2    " + System.currentTimeMillis());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "f2";
                });
        main.thenApply(r -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "test2 hello world f3    " + System.currentTimeMillis());
            return "f3";
        });
        main.thenApply(r -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "test2 hello world f4    " + System.currentTimeMillis());
            return "f4";
        });
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("aaa");
    }

    static void test3() {
        CompletableFuture<String> main = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "test3 hello world main  " + System.currentTimeMillis());
            return "result main";
        }, executor);
        main.thenApply(r -> {
            try {
                System.out.println(Thread.currentThread() + "test3 hello world f2    " + System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "f2";
        });
        main.thenApply(r -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "test3 hello world f3    " + System.currentTimeMillis());
            return "f3";
        });
        main.thenApply(r -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "test3 hello world f4    " + System.currentTimeMillis());
            return "f4";
        });
    }


}
