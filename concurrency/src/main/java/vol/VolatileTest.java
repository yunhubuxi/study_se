package vol;

import java.util.concurrent.TimeUnit;

public class VolatileTest {
    private static volatile int m = 0;
    private static  int n = 0;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " :"+m);
                System.out.println(Thread.currentThread().getName() + " :"+n);
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                m =5;
                n = 5;
                System.out.println(Thread.currentThread().getName() + " :"+m);
                System.out.println(Thread.currentThread().getName() + " :"+n);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " :"+m);
                System.out.println(Thread.currentThread().getName() + " :"+n);
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " :"+m);
                System.out.println(Thread.currentThread().getName() + " :"+n);
            }
        }).start();
    }
}
