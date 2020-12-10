package threads.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Object> objectCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("11111111111");
                TimeUnit.SECONDS.sleep(1);
                return "1111";
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "bbb";
        });
        TimeUnit.SECONDS.sleep(3);

        System.out.println(objectCompletableFuture1.get());
    }

    public static void test1() throws Exception{
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread()+" start job1,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job1,time->"+System.currentTimeMillis());
            return 1.2;
        });
        CompletableFuture cf2=cf.thenRun(()->{
            System.out.println(Thread.currentThread()+" start job12,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job12,time->"+System.currentTimeMillis());
        });
        CompletableFuture cf3=cf.thenRun(()->{
            System.out.println(Thread.currentThread()+" start job13,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job13,time->"+System.currentTimeMillis());
        });
        CompletableFuture cf4=cf3.thenRun(()->{
            System.out.println(Thread.currentThread()+" start job21,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job21,time->"+System.currentTimeMillis());
        });
        CompletableFuture cf5=cf3.thenRun(()->{
            System.out.println(Thread.currentThread()+" start job22,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job22,time->"+System.currentTimeMillis());
        });
        System.out.println("main thread start cf2.get(),time->"+System.currentTimeMillis());
        //等待子任务执行完成
        System.out.println("cf2 run result->"+cf2.get());
        System.out.println("main thread exit,time->"+System.currentTimeMillis());
    }

    public static void test2() throws Exception {
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread()+" start job1,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job1,time->"+System.currentTimeMillis());
            return 1.2;
        });
        CompletableFuture cf2=cf.thenRunAsync(()->{
            System.out.println(Thread.currentThread()+" start job12,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job12,time->"+System.currentTimeMillis());
        });
        CompletableFuture cf3=cf.thenRunAsync(()->{
            System.out.println(Thread.currentThread()+" start job13,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job13,time->"+System.currentTimeMillis());
        });
        CompletableFuture cf4=cf3.thenRun(()->{
            System.out.println(Thread.currentThread()+" start job21,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job21,time->"+System.currentTimeMillis());
        });
        CompletableFuture cf5=cf3.thenRun(()->{
            System.out.println(Thread.currentThread()+" start job22,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job22,time->"+System.currentTimeMillis());
        });
        System.out.println("main thread start cf4.get(),time->"+System.currentTimeMillis());
        //等待子任务执行完成
        System.out.println("cf4 run result->"+cf4.get());
        System.out.println("main thread exit,time->"+System.currentTimeMillis());
    }
}
