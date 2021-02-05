package thread.local;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyThreadLocal7 {
    static final InheritableThreadLocal<Map<String,Object>> threadParam = new InheritableThreadLocal<>();
    public static void main(String[] args) {
        ExecutorService execService1 = Executors.newFixedThreadPool(1);
        ExecutorService execService2 = Executors.newFixedThreadPool(2);
        execService1.execute(() -> {
            List<String> list = new ArrayList<>();
            list.add("a");
            list.add("b");
            list.add("c");
            Map<String, Object> map = new HashMap<>();
            map.put("test", list);
            threadParam.set(map);
            execService2.execute(() -> {
                List<String> list1 = (List<String>) threadParam.get().get("test");
                for (String s : list1) {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(s);
                }
            });
            threadParam.remove();
            execService2.execute(() -> {
                List<String> list1 = (List<String>) threadParam.get().get("test");
                for (String s : list1) {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(s);
                }
            });
        });
        execService1.shutdown();
        System.out.println("execService1===销毁");






    }
}
