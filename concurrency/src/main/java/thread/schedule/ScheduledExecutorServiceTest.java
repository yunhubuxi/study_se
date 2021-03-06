package thread.schedule;


import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {
    public static void main(String[] args) {
        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1, r -> new Thread(r, "MQClientFactoryScheduledThread"));
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                System.out.println("5秒执行一次" + LocalTime.now().toString() + Thread.currentThread().getName());


            } catch (Exception e) {
            }
        }, 10, 5000, TimeUnit.MILLISECONDS);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                System.out.println("20秒执行一次" + LocalTime.now().toString() + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception e) {
            }
        }, 1000, 20000, TimeUnit.MILLISECONDS);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                System.out.println("10秒执行一次" + LocalTime.now().toString() + Thread.currentThread().getName());
            } catch (Exception e) {
            }
        }, 1000 * 10, 10000, TimeUnit.MILLISECONDS);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                System.out.println("1分钟执行一次" + LocalTime.now().toString() + Thread.currentThread().getName());
            } catch (Exception e) {
            }
        }, 1, 1, TimeUnit.MINUTES);
    }
}

