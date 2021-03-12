package memory;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap里面的数据，Key和Value都为String类型的情况下
 * 7个对象就会超过1024个字节，也就是一兆
 */
public class Test3 {
    public static void main(String[] args) {
        Map<String, Long> map = new HashMap<>();
        for (int i = 0; i <70 ; i++) {
            map.put(i + "sss",new Long(i));
        }
        System.out.println(ObjectSizeCalculator.getObjectSize(map));
        System.out.println(ObjectSizeCalculator.getObjectSize(new HashMap<>(128)));
    }
}
