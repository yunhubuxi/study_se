package map;

import java.util.Map;
import java.util.concurrent.CountDownLatch;

class PutThread extends Thread {
    private Map<String, Integer> map;
    private CountDownLatch countDownLatch;
    private String key = this.getId() + "";

    PutThread(Map<String, Integer> map, CountDownLatch countDownLatch) {
        this.map = map;
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        for (int i = 1; i <= ConcurrentHashMapDemo.NUMBER; i++) {
            map.put(key, i);
        }
        countDownLatch.countDown();
    }
}
