package hash;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * 改进版一致性哈希算法，添加虚拟节点
 */
public class ConsistentHashLoadBalance {

    private TreeMap<Long, String> virtualNodes = new TreeMap<>();
    private LinkedList<String> nodes;
    //每个真实节点对应的虚拟节点数
    private final int replicCnt;

    public ConsistentHashLoadBalance(LinkedList<String> nodes, int replicCnt) {
        this.nodes = nodes;
        this.replicCnt = replicCnt;
        initalization();
    }

    /**
     * 初始化哈希环
     * 循环计算每个node名称的哈希值，将其放入treeMap
     */
    private void initalization() {
        for (String nodeName : nodes) {
            for (int i = 0; i < replicCnt / 4; i++) {
                String virtualNodeName = getNodeNameByIndex(nodeName, i);
                for (int j = 0; j < 4; j++) {
                    virtualNodes.put(hash(virtualNodeName, j), nodeName);
                }
            }
        }
    }

    private String getNodeNameByIndex(String nodeName, int index) {
        return new StringBuffer(nodeName)
            .append("&&")
            .append(index)
            .toString();
    }

    /**
     * 根据资源key选择返回相应的节点名称
     *
     * @param key
     * @return 节点名称
     */
    public String selectNode(String key) {
        Long hashOfKey = hash(key, 0);
        if (!virtualNodes.containsKey(hashOfKey)) {
            Map.Entry<Long, String> entry = virtualNodes.ceilingEntry(hashOfKey);
            if (entry != null)
                return entry.getValue();
            else
                return nodes.getFirst();
        } else
            return virtualNodes.get(hashOfKey);
    }

    private Long hash(String nodeName, int number) {
        byte[] digest = md5(nodeName);
        return (((long) (digest[3 + number * 4] & 0xFF) << 24)
            | ((long) (digest[2 + number * 4] & 0xFF) << 16)
            | ((long) (digest[1 + number * 4] & 0xFF) << 8)
            | (digest[number * 4] & 0xFF))
            & 0xFFFFFFFFL;
    }

    /**
     * md5加密
     *
     * @param str
     * @return
     */
    public byte[] md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(str.getBytes("UTF-8"));
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addNode(String node) {
        nodes.add(node);
        String virtualNodeName = getNodeNameByIndex(node, 0);
        for (int i = 0; i < replicCnt / 4; i++) {
            for (int j = 0; j < 4; j++) {
                virtualNodes.put(hash(virtualNodeName, j), node);
            }
        }
    }

    public void removeNode(String node) {
        nodes.remove(node);
        String virtualNodeName = getNodeNameByIndex(node, 0);
        for (int i = 0; i < replicCnt / 4; i++) {
            for (int j = 0; j < 4; j++) {
                virtualNodes.remove(hash(virtualNodeName, j), node);
            }
        }
    }

    private void printTreeNode() {
        if (virtualNodes != null && !virtualNodes.isEmpty()) {
            virtualNodes.forEach((hashKey, node) ->
                System.out.println(
                    new StringBuffer(node)
                        .append(" ==> ")
                        .append(hashKey)
                )
            );
        } else
            System.out.println("Cycle is Empty");
    }

    public static void main(String[] args) {
        LinkedList<String> nodes = new LinkedList<>();
        nodes.add("192.168.2.1:8080");
        nodes.add("192.168.2.2:8080");
        nodes.add("192.168.2.3:8080");
        nodes.add("192.168.2.4:8080");
        ConsistentHashLoadBalance consistentHash = new ConsistentHashLoadBalance(nodes, 160);
        consistentHash.printTreeNode();
        System.out.println("===============================");
        System.out.println(consistentHash.selectNode("qweqw3"));
    }
}
