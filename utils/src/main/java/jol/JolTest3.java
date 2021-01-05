package jol;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.openjdk.jol.info.ClassLayout;

import java.util.HashMap;
import java.util.Map;

public class JolTest3 {
    public static void main(String[] args) {
        boolean[] booleans = new boolean[5];
        System.out.println(ObjectSizeCalculator.getObjectSize(booleans));
        System.out.println(ClassLayout.parseInstance(booleans).toPrintable());
        System.out.println("========================");
        int[] ints = new int[5];
        System.out.println(ObjectSizeCalculator.getObjectSize(ints));
        System.out.println(ClassLayout.parseInstance(ints).toPrintable());
        System.out.println("========================");
       Object o = new Object();
        System.out.println(ObjectSizeCalculator.getObjectSize(o));
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println("========================");


    }

}
