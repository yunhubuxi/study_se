package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyThreadLocal2 {
    static final ThreadLocal<String> threadParam = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException{
        //固定池内只有存活3个线程
        ExecutorService execService = Executors.newFixedThreadPool(10);
        //死循环几次才能看出效果
        while (true) {
            Thread t = new Thread(()->{
                threadParam.set("abc");
                System.out.println("t1:" + threadParam.get());
                //如果不调用remove,将引发问题
//                    threadParam.remove();
            });
            execService.execute(t);
            Thread t2 = new Thread(()-> {
                System.out.println("t2:" + threadParam.get());
            });
            execService.execute(t2);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
