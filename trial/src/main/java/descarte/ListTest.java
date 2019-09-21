package descarte;

import java.util.*;

public class ListTest {
    public static void main(String[] args) {
        List<Long> longs = new ArrayList<>();
        longs.add(12L);
        longs.add(14L);
        longs.add(12L);
        System.out.println(longs.toString());
        Collections.sort(longs);
        System.out.println(longs.toString());

        Map<String, List> map = new HashMap<>();

        List<String> skuIds = new ArrayList<>();
        skuIds.add("11");
        map.put("skuIds", skuIds);

        System.out.println(map);

        skuIds.add("23");
        System.out.println(map);

        List<String> temp = new ArrayList<>();
        temp.add("25");

        List<String> aa = map.put("skuIds", temp);
        System.out.println(aa);
        System.out.println(map);
        temp.addAll(aa);
        System.out.println(map);
    }
}
