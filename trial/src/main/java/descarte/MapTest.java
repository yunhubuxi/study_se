package descarte;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapTest {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("aa",Integer.valueOf(1));
        map.put("bb",Integer.valueOf(1));
        map.put("cc",Integer.valueOf(1));
        map.put("dd",Integer.valueOf(3));
        System.out.println(map);
        //Map -> Stream -> Filter -> Map
        Map<String, Integer> result1 = map.entrySet().stream()
                .filter(temp -> temp.getKey() == "aa")
                .collect(Collectors.toMap(h -> h.getKey(), h -> h.getValue()));

        System.out.println(result1);

        System.out.println(map);
        Map<String, Integer> result2 = map.entrySet().stream()
                .filter(temp -> temp.getValue() < 2)
                .collect(Collectors.toMap(h -> h.getKey(), h -> h.getValue()));
        System.out.println(result2);

    }
}
