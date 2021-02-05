package thread.completable;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest3 {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        CompletableFuture<String> resultA = null;
        CompletableFuture<String> resultB = null;
        for (String s : list) {
            switch (s) {
                case "a":
                    resultA = getForecastList1();
                    break;
                case "b":
                    resultB = getForecastList2();
                    break;
                    default:
                        System.out.println("fff");
            }
        }
        List<String> result = new ArrayList<>();
        System.out.println("============开始等待===============");
        result.add(resultA.get());
        System.out.println("111111111111");
        result.add(resultB.get());
        System.out.println("222222222222222222");
        System.out.println(result);
    }

    private static String test1() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() +"==============test1");
        return "aa";
    }

    private static CompletableFuture<String> getForecastList1() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return test1();
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        });
    }

    private static String test2() throws InterruptedException {
        TimeUnit.SECONDS.sleep(15);
        System.out.println(Thread.currentThread().getName() + "==============test2");
        return "bb";
    }

    private static CompletableFuture<String> getForecastList2() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return test2();
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        });
    }
}
