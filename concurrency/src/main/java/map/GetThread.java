package map;

import java.util.Map;
import java.util.concurrent.CountDownLatch;

class GetThread extends Thread {
    private Map<String, Integer> map;
    private CountDownLatch countDownLatch;
    private String key = this.getId() + "";

    GetThread(Map<String, Integer> map, CountDownLatch countDownLatch) {
        this.map = map;
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        for (int i = 1; i <= ConcurrentHashMapDemo.NUMBER; i++) {
            map.get(key);
        }
        countDownLatch.countDown();
    }
}
