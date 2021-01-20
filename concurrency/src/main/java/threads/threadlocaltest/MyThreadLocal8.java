package threads.threadlocaltest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * InheritableThreadLocal是在Thread的init方法里面初始化的
 * 使用线程池的话，当复用线程的时候不会调用init方法
 * 会获取到之前线程的inheritableThreadLocals，从而引发问题
 * 主线程的remove不会影响子线程，子线程的remove也不会影响主线程
 * 但是主线程remove后，去init子线程，然后在子线程中get，就会报空指针
 * 因为主线程还没有给子线程传进去
 */
public class MyThreadLocal8 {
    // 线程池为1、2、3会得到不同的执行结果
    static ExecutorService execService = Executors.newFixedThreadPool(3);
    static final InheritableThreadLocal<Map<String, Object>> threadParam = new InheritableThreadLocal<>();

    public static void main(String[] args) throws Exception {
        test2();
    }

    private static void test1() throws Exception {
        Map map = new HashMap();
        map.put("1", "aa");
        threadParam.set(map);
        execService.execute(() -> System.out.println(Thread.currentThread().getName() + ":" + threadParam.get().get("1")));
        TimeUnit.SECONDS.sleep(3);
        map.put("1", "bb");
        execService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + ":" + threadParam.get().get("1"));
        });
        Map map1 = new HashMap();
        map1.put("1", "cc");
        threadParam.set(map1);
        execService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + ":" + threadParam.get().get("1"));
        });
    }

    private static void test2() throws Exception {
        Map map = new HashMap();
        map.put("1", "aa");
        threadParam.set(map);
        execService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + ":" + threadParam.get().get("1"));
            threadParam.remove();
        });
        TimeUnit.SECONDS.sleep(3);
        System.out.println(Thread.currentThread().getName() + ":" + threadParam.get().get("1"));
        map.put("1", "bb");
        execService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + threadParam.get().get("1"));
        });
        TimeUnit.SECONDS.sleep(3);
        threadParam.remove();
        Map map1 = new HashMap();
        map1.put("1", "cc");
        threadParam.set(map1);
        execService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + ":" + threadParam.get().get("1"));
        });
    }
}
