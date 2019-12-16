import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.TimeUnit;

public class Master implements Watcher {

    private ZooKeeper zooKeeper;
    private String hostPort;

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }

    Master(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK() throws Exception {
        zooKeeper = new ZooKeeper(hostPort, 15000, this);
    }


    void stop() throws Exception {
        zooKeeper.close();
    }


    public static void main(String[] args) throws Exception {
        String host = "192.168.228.130:2181";
        Master master = new Master(host);
        master.startZK();

        TimeUnit.SECONDS.sleep(5);
        master.stop();
    }
}
