package threads.threadlocaltest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyThreadLocal6 {
    static final InheritableThreadLocal<User> threadParam = new InheritableThreadLocal<>();
    static final ThreadLocal<User> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws Exception {
        User user = new User();
        user.name = "aa";
        user.age = 12;
        threadParam.set(user);
        threadLocal.set(user);
        ExecutorService execService = Executors.newFixedThreadPool(1);
        execService.execute(() -> System.out.println(threadParam.get().name));
        execService.execute(() -> System.out.println(threadParam.get().age));

        TimeUnit.SECONDS.sleep(1);
        user.name = "fsf";
        user.age = 232;


        execService.execute(() -> System.out.println(threadParam.get().name));
        execService.execute(() -> System.out.println(threadParam.get().age));
        TimeUnit.SECONDS.sleep(1);
        user = new User();
        user.name = "sfdkfjsldjf";
        user.age = 234234;
        execService.execute(() -> System.out.println(threadParam.get().name));
        execService.execute(() -> System.out.println(threadParam.get().age));

        TimeUnit.SECONDS.sleep(1);
        User finalUser = user;
        execService.execute(() -> threadParam.set(finalUser));
        execService.execute(() -> System.out.println(threadParam.get().name));
        execService.execute(() -> System.out.println(threadParam.get().age));

    }

    static class User {
        String name;
        int age;
    }
}
