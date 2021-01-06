package memory;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * jps -l
 * jmap -dump:format=b,file=heapDump 2952
 * heapDump 为文件名，位置在项目代码文件夹下
 * jhat heapDump
 */
public class Test2 {
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
        System.out.println(ObjectSizeCalculator.getObjectSize(map) / 1024);
        System.out.println(ObjectSizeCalculator.getObjectSize(mapList) / 1024);

        System.out.println("===================");
        List<User> list1 = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            User user= new User("ff",2);
            list1.add(user);
        }
        System.out.println(ObjectSizeCalculator.getObjectSize(list1) / 1024);
        List<User2> list2 = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            User2 user= new User2("ff",2);
            user.put("ff", "ff");
            user.put("ffew", "ff");
            list2.add(user);
        }
        System.out.println(ObjectSizeCalculator.getObjectSize(list2) / 1024);

        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class User {
        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        String name;
        Integer age;
    }

    static class User2 extends HashMap {
        public User2(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        String name;
        Integer age;
    }
}
