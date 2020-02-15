package threads.schedule;


import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {
    public static void main(String[] args) {
//        Executors.newScheduledThreadPool(5);
        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5,new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "MQClientFactoryScheduledThread");

            }
        });
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("5秒执行一次"+ LocalTime.now().toString()+Thread.currentThread().getName());

                } catch (Exception e) {
                }
            }
        }, 10, 5000, TimeUnit.MILLISECONDS);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("20秒执行一次"+ LocalTime.now().toString()+Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(10);
                } catch (Exception e) {
                }
            }
        }, 1000, 20000, TimeUnit.MILLISECONDS);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("10秒执行一次"+ LocalTime.now().toString()+Thread.currentThread().getName());
                } catch (Exception e) {
                }
            }
        }, 1000 * 10, 10000, TimeUnit.MILLISECONDS);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("1分钟执行一次"+ LocalTime.now().toString()+Thread.currentThread().getName());
                } catch (Exception e) {
                }
            }
        }, 1, 1, TimeUnit.MINUTES);
    }
}

