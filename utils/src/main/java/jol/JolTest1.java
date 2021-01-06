package jol;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.openjdk.jol.info.ClassLayout;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class JolTest1 {
    static class Demo1 {
        String test = "fff";
        Demo2 demo2 = new Demo2();
    }
    static class Demo2 {
        String test1 = "fff";
        String test2 = "fff";
    }

    static class Demo3 extends HashMap {
        String test1 = "fff";
        String test2 = "fff";
    }

    static class Demo4 extends LinkedHashMap {
        String test1 = "fff";
        String test2 = "fff";
    }
    public static void main(String[] args) {
        Object o = new Object();
        System.err.println(ObjectSizeCalculator.getObjectSize(0));
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        Demo1 demo1 = new Demo1();
        System.err.println(ObjectSizeCalculator.getObjectSize(demo1));
        System.out.println(ClassLayout.parseInstance(demo1).toPrintable());
        Demo2 demo2 = new Demo2();
        System.err.println(ObjectSizeCalculator.getObjectSize(demo2));
        System.out.println(ClassLayout.parseInstance(demo2).toPrintable());
        Demo3 demo3 = new Demo3();
        System.err.println(ObjectSizeCalculator.getObjectSize(demo3));
        System.out.println(ClassLayout.parseInstance(demo3).toPrintable());
        Demo4 demo4 = new Demo4();
        System.err.println(ObjectSizeCalculator.getObjectSize(demo4));
        System.out.println(ClassLayout.parseInstance(demo4).toPrintable());
        demo4.put("aaa", "bbb");
        System.err.println(ObjectSizeCalculator.getObjectSize(demo4));
        System.out.println(ClassLayout.parseInstance(demo4).toPrintable());


    }
}
