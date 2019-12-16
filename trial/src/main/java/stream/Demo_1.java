package stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo_1 {
    public static void main(String[] args) {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("id", "a");
        list.add(map1);

        Map<String, String> map2 = new HashMap<>();
        map2.put("id", "b");

        list.add(map2);

        Map<String, String> map3 = new HashMap<>();
        map3.put("id", "c");

        list.add(map3);

        System.out.println(list);


        List<String> result = list.stream().map(p -> p.get("id")).collect(Collectors.toList());
        System.out.println(result);
    }
}
