import java.util.List;

public class Demo {
    public static void main(String[] args) throws Exception {
        String host = "192.168.228.130";
        BaseZookeeper baseZookeeper = new BaseZookeeper();
        baseZookeeper.connectZookeeper(host);
        for (int i = 0; i < 1000; i++) {
            baseZookeeper.createNode("/test/"+i, i+"");
        }
    }
}
