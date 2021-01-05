package jol;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.openjdk.jol.info.ClassLayout;

import java.util.HashMap;
import java.util.Map;

public class JolTest2 {
    public static void main(String[] args) {
        boolean[] booleans = new boolean[5];
        System.out.println(ObjectSizeCalculator.getObjectSize(booleans));
        System.out.println(ClassLayout.parseInstance(booleans).toPrintable());
        System.out.println("========================");
        int[] ints = new int[5];
        System.out.println(ObjectSizeCalculator.getObjectSize(ints));
        System.out.println(ClassLayout.parseInstance(ints).toPrintable());
        System.out.println("========================");
        long[] longs = new long[5];
        System.out.println(ObjectSizeCalculator.getObjectSize(longs));
        System.out.println(ClassLayout.parseInstance(longs).toPrintable());
        System.out.println("========================");

        HashMap[] maps = new HashMap[5];
        System.out.println(ObjectSizeCalculator.getObjectSize(maps));
        System.out.println(ClassLayout.parseInstance(maps).toPrintable());
        System.out.println("========================");

        Map<String, String> map = new HashMap<>();
        System.out.println(ObjectSizeCalculator.getObjectSize(map));
        System.out.println(ClassLayout.parseInstance(map).toPrintable());
        System.out.println("========================");

    }

}
