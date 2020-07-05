package threadpooltest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolTest {
    private static ExecutorService execService = Executors.newFixedThreadPool(3);
    public static void main(String[] args) {
        execService.execute(() -> System.out.println("fff"));
    }

    Lock lock = new ReentrantLock();
}
