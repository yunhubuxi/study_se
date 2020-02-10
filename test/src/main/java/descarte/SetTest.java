package descarte;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("2");
        set1.add("3");
        set1.add("4");
        System.out.println(set1.add("1"));



        Set<String> set2 = new HashSet<>();
        set2.add("4");
        set2.add("3");
        set2.add("8");


        Set<String> set3 = new HashSet<>();
        set3.add("2");
        set3.add("3");
        set3.add("4");
        Set<String> set4 = new HashSet<>();
        set4.add("4");
        set4.add("3");
        set4.add("2");
        Set<String> set5 = new HashSet<>();
        set5.add("4");
        set5.add("3");
        set5.add("2");

        Set<String> set6 = new HashSet<>();

        System.out.println(set1.equals(set2));
        System.out.println(set1.containsAll(set6));

    }
}
