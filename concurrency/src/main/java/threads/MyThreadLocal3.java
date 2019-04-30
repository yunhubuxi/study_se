package threads;

import java.util.concurrent.TimeUnit;

public class MyThreadLocal3 {
    static final InheritableThreadLocal<String> threadParam = new InheritableThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        //死循环,测多几次看结果
        while (true) {
            //线程1,测试是否能获取父线程参数
            new Thread(() -> {
                //设置参数
                threadParam.set("abc");
                //输出参数
                System.out.println("t1:" + threadParam.get());

                //线程2,测试是否能获取线程1参数
                new Thread(() -> {
                    System.out.println("t2:" + threadParam.get());
                    //为了测试线程三能否获得,这里先不删除
//                    threadParam.remove();
                }).start();
            }).start();

            TimeUnit.SECONDS.sleep(1);

            //线程3,测试是否能获取线程1参数
            new Thread(() -> {
                System.out.println("t3:" + threadParam.get());
            }).start();
        }
    }
}
