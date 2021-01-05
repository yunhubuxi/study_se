import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * jps -l
 * jmap -dump:format=b,file=heapDump 2952
 * heapDump 为文件名，位置在项目代码文件夹下
 * jhat heapDump
 */
public class Test {
    public static void main(String[] args) {
        List<Map<String, User>> mapList = new LinkedList<>();
        for (int i = 0; i < 5000; i++) {
            Map<String, User> map = new HashMap<>();
            for (int j = 0; j < 5; j++) {
                map.put("aaa" + j, new User("name" + j, Integer.valueOf(j)));
            }
            mapList.add(map);
        }
        Map<String, User> map = new HashMap<>();
        for (int j = 0; j < 499; j++) {
            map.put("aaa" + j, new User("fsldf", Integer.valueOf(100)));
        }
        mapList.add(map);
        System.out.println(ObjectSizeCalculator.getObjectSize(map) / (8 * 1024));
        System.out.println(ObjectSizeCalculator.getObjectSize(mapList) / (8 * 1024));

        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class User extends HashMap {
        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        String name;
        Integer age;
    }
}
