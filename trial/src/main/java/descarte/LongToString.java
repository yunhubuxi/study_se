package descarte;

import java.util.*;

public class LongToString {
    public static void main(String[] args) {
        Set<Set<String>> sets1 = new HashSet<>();
        Set<String> set1 = new HashSet<>();
        set1.add("2");
        set1.add("3");
        set1.add("4");
        Set<String> set2 = new HashSet<>();
        set2.add("4");
        set2.add("3");
        set2.add("8");
        sets1.add(set1);
        sets1.add(set2);



//        System.out.println(sets1.containsAll(set5)+ "--=====");
//
//
//
//        System.out.println(set1 == set2);
//        System.out.println(set1.equals(set2));
//
//        System.out.println(set1.size());
//        set1.removeAll(set2);
//        System.out.println(set1.size());
//
//        System.out.println(set1.size());
//        set1.retainAll(set2);
//        System.out.println(set1.size());


        Set<Set<String>> sets2 = new HashSet<>();
        Set<String> set3 = new HashSet<>();
        set3.add("2");
        set3.add("3");
        set3.add("4");
        Set<String> set4 = new HashSet<>();
        set4.add("4");
        set4.add("3");
        set4.add("2");
        sets2.add(set3);
        sets2.add(set4);

        System.out.println(sets1.size());
        sets1.retainAll(sets2);
        System.out.println(sets1.size());

    }
}
