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
 */
public class MyThreadLocal8 {
    static ExecutorService execService = Executors.newFixedThreadPool(3);
    static final InheritableThreadLocal<Map<String, Object>> threadParam = new InheritableThreadLocal<>();

    public static void main(String[] args) throws Exception {
        Map map = new HashMap();
        map.put("1", "aa");
        threadParam.set(map);
        Runnable runnable = () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadParam.get().get("1"));
        };
        execService.execute(runnable);
        map.put("1", "bb");
        execService.execute(() -> {
            System.out.println(threadParam.get().get("1"));
        });
        Map map1 = new HashMap();
        map1.put("1", "cc");
        threadParam.set(map1);
        execService.execute(() -> {
            System.out.println(threadParam.get().get("1"));
        });

    }
}
