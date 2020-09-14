package threads.threadlocaltest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadLocal5 {
    static final InheritableThreadLocal<String> threadParam = new InheritableThreadLocal<>();
    static final ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        //固定池内只有存活3个线程
        threadParam.set("fff");
        threadLocal.set("bbb");
        ExecutorService execService = Executors.newFixedThreadPool(10);
        execService.execute(()-> System.out.println(threadParam.get()));
        execService.execute(()-> System.out.println(threadLocal.get()));
    }
}
