package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 会出现问题的实例代码，出现了线程t2、t3拿到了CBA的情况
 */
public class MyThreadLocal4 {
    static final InheritableThreadLocal<String> threadParam = new InheritableThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        //固定池内只有存活3个线程
        ExecutorService execService = Executors.newFixedThreadPool(10);
        //死循环几次才能看出效果
        while (true) {
            //线程1,里面有两个子线程
            Thread t = new Thread(()->{
                threadParam.set("abc");
                System.out.println("t1:" + threadParam.get());
                Thread t2 = new Thread(()->{
                    System.out.println("t2:" + threadParam.get());
//                        threadParam.remove();
                });
                execService.execute(t2);

                Thread t3 = new Thread(()->{
                    System.out.println("t3:" + threadParam.get());
//                        threadParam.remove();
                });
                execService.execute(t3);

            });
            execService.execute(t);
            TimeUnit.SECONDS.sleep(1);
            //线程4,线程1同级
            Thread t4 = new Thread(()-> {
                threadParam.set("CBA");
                System.out.println("t4:" + threadParam.get());
            });
            execService.execute(t4);
        }
    }
}
