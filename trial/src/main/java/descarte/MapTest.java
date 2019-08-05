package descarte;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapTest {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        System.out.println(map.put("aa",Integer.valueOf(1)));
        System.out.println(map.put("aa",Integer.valueOf(2)));
        System.out.println(map.put("aa",Integer.valueOf(3)));
        System.out.println(map.putIfAbsent("bb",Integer.valueOf(1)));
        System.out.println(map.putIfAbsent("bb",Integer.valueOf(2)));
        System.out.println(map.putIfAbsent("bb",Integer.valueOf(3)));

        System.out.println(map);
        //Map -> Stream -> Filter -> Map
        Map<String, Integer> result1 = map.entrySet().stream()
                .filter(temp -> temp.getKey() == "aa")
                .collect(Collectors.toMap(h -> h.getKey(), h -> h.getValue()));

        System.out.println(result1);

        Map<String, Integer> result2 = map.entrySet().stream()
                .filter(temp -> temp.getValue() < 2)
                .collect(Collectors.toMap(h -> h.getKey(), h -> h.getValue()));
        System.out.println(result2);

    }
}
