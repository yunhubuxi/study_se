package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {

    Stream stream1 = Stream.of("a", "b", "c");
    // 2. Arrays
    String[] strArray = new String[]{"a", "b", "c"};
    Stream stream2 = Stream.of(strArray);
    Stream stream3 = Arrays.stream(strArray);
    // 3. Collections
    List<String> list = Arrays.asList(strArray);
    Stream stream4 = list.stream();

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).
                collect(Collectors.toList());
        squareNums.forEach((i) -> System.out.println(i));


        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        Integer[] evens =
                Stream.of(sixNums).filter(n -> n % 2 == 0).toArray(Integer[]::new);
        List<Integer> integers = new ArrayList<>();
        Stream.iterate(0, n -> n + 100).limit(100).forEach(x -> integers.add(x));

        integers.forEach(x-> System.out.println(x));

    }


}
