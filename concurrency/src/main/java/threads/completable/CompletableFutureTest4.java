package threads.completable;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest4 {
    public static void main(String[] args) throws Exception {
        test2();
        TimeUnit.SECONDS.sleep(50);
    }

    static void test4() {
        CompletableFuture<String> main = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world main  " + System.currentTimeMillis());
            return "result main";
        });
        CompletableFuture<String> f1 = main.thenApply(r -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world f1  " + System.currentTimeMillis());
            return "f1";
        });
        CompletableFuture<String> f2 = main.thenApply(r -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world f2  " + System.currentTimeMillis());
            return "f2";
        });
        CompletableFuture<String> f3 = main.thenApply(r -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world f3  " + System.currentTimeMillis());
            return "f3";
        });
        CompletableFuture<String> f11 = f1.thenApply(r -> {
            System.err.println(r);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world f11  " + System.currentTimeMillis());
            return "f11";
        });

        CompletableFuture<String> f12 = f1.thenApply(r -> {
            System.err.println(r);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world f12  " + System.currentTimeMillis());
            return "f12";
        });

        CompletableFuture<String> f13 = f1.thenApply(r -> {
            System.err.println(r);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world f13  " + System.currentTimeMillis());
            return "f13";
        });

        CompletableFuture<String> f21 = f2.thenApply(r -> {
            System.err.println(r);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world f21  " + System.currentTimeMillis());
            return "f21";
        });

        CompletableFuture<String> f22 = f2.thenApply(r -> {
            System.err.println(r);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world f22  " + System.currentTimeMillis());
            return "f22";
        });

        CompletableFuture<String> f31 = f3.thenApply(r -> {
            System.err.println(r);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world f31  " + System.currentTimeMillis());
            return "f31";
        });

        CompletableFuture<String> f32 = f3.thenApply(r -> {
            System.err.println(r);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world f32  " + System.currentTimeMillis());
            return "f32";
        });

        CompletableFuture<String> f33 = f3.thenApply(r -> {
            System.err.println(r);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world f33  " + System.currentTimeMillis());
            return "f33";
        });

        CompletableFuture<String> f331 = f33.thenApply(r -> {
            System.err.println(r);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world f331  " + System.currentTimeMillis());
            return "f331";
        });

        CompletableFuture<String> f332 = f33.thenApply(r -> {
            System.err.println(r);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world f332  " + System.currentTimeMillis());
            return "f332";
        });
    }

    /**
     * job12和job13都是job1的同步回调任务，
     * job13是最后声明的，最先执行，job13执行完后进入postFire，return this，
     * 接着触发job13的两个回调任务，job21和job22， job22会插入到job1的stack链表中，
     * 然后执行job21，job21执行完进入postFire，因为job13的stack已经是null，job21的stack也是null，
     * 则postFire返回null，接着触发job1的stack属性，即job22的执行，job22执行完进入postFire，
     * 同样因为job13和job21的stack都是null而返回null，继续触发job1的stack属性，即job12的执行。
     */
    static void test1() throws ExecutionException, InterruptedException {
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " start job1,time->" + System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread() + " exit job1,time->" + System.currentTimeMillis());
            return 1.2;
        });
        CompletableFuture cf2 = cf.thenRun(() -> {
            System.out.println(Thread.currentThread() + " start job12,time->" + System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread() + " exit job12,time->" + System.currentTimeMillis());
        });
        CompletableFuture cf3 = cf.thenRun(() -> {
            System.out.println(Thread.currentThread() + " start job13,time->" + System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread() + " exit job13,time->" + System.currentTimeMillis());
        });
        CompletableFuture cf4 = cf3.thenRun(() -> {
            System.out.println(Thread.currentThread() + " start job21,time->" + System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread() + " exit job21,time->" + System.currentTimeMillis());
        });
        CompletableFuture cf5 = cf3.thenRun(() -> {
            System.out.println(Thread.currentThread() + " start job22,time->" + System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread() + " exit job22,time->" + System.currentTimeMillis());
        });
        System.out.println("main thread start cf2.get(),time->" + System.currentTimeMillis());
        //等待子任务执行完成
        System.out.println("cf2 run result->" + cf2.get());
        System.out.println("main thread exit,time->" + System.currentTimeMillis());

    }

    /**
     * job13和job12都是job1的异步任务，因为job13是最后声明的，
     * 所以最先被触发，因为job13是异步执行的，所以不需要等待job13执行完成就会立即触发job12的执行。
     * job13执行完成后，会通过postFire触发其两个同步任务job21和job22执行，
     * 此时job1的stack为null，job13的stack不为null，且是异步触发，所以会通过postComplete触发最后声明的job22执行，
     * job22执行完成后，postFire返回null，继续触发job13的下一个stack任务，即job21的执行。
     */
    static void test2() throws ExecutionException, InterruptedException {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " start job1,time->" + System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread() + " exit job1,time->" + System.currentTimeMillis());
            return 1.2;
        });
        CompletableFuture cf2 = cf.thenRunAsync(() -> {
            System.out.println(Thread.currentThread() + " start job12,time->" + System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread() + " exit job12,time->" + System.currentTimeMillis());
        });
        CompletableFuture cf3 = cf.thenRunAsync(() -> {
            System.out.println(Thread.currentThread() + " start job13,time->" + System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread() + " exit job13,time->" + System.currentTimeMillis());
        });
        CompletableFuture cf4 = cf3.thenRun(() -> {
            System.out.println(Thread.currentThread() + " start job21,time->" + System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread() + " exit job21,time->" + System.currentTimeMillis());
        });
        CompletableFuture cf5 = cf3.thenRun(() -> {
            System.out.println(Thread.currentThread() + " start job22,time->" + System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread() + " exit job22,time->" + System.currentTimeMillis());
        });
        System.out.println("main thread start cf4.get(),time->" + System.currentTimeMillis());
        //等待子任务执行完成
        System.out.println("cf4 run result->" + cf4.get());
        System.out.println("main thread exit,time->" + System.currentTimeMillis());
    }

    static void test3() {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello world f1");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world f1  " + System.currentTimeMillis());
            return "result f1";
        });
        CompletableFuture<String> f2 = f1.thenApply(r -> {
            System.out.println(r);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world f2  " + System.currentTimeMillis());
            return "f2";
        });
        CompletableFuture<String> f3 = f2.thenApply(r -> {
            System.out.println(r);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world f3  " + System.currentTimeMillis());
            return "f2";
        });

        CompletableFuture<String> f4 = f1.thenApply(r -> {
            System.out.println(r);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world f4  " + System.currentTimeMillis());
            return "f2";
        });
        CompletableFuture<String> f5 = f4.thenApply(r -> {
            System.out.println(r);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world f5  " + System.currentTimeMillis());
            return "f2";
        });
        CompletableFuture<String> f6 = f5.thenApply(r -> {
            System.out.println(r);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " hello world f6  " + System.currentTimeMillis());
            return "f2";
        });
    }
}
