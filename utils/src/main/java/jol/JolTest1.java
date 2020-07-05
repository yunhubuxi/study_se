package jol;

import org.openjdk.jol.info.ClassLayout;

public class JolTest1 {
    static class Demo1 {
        String test = "fff";
        Demo2 demo2 = new Demo2();
    }
    static class Demo2 {
        String test1 = "fff";
        String test2 = "fff";
    }
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        Demo1 demo1 = new Demo1();
        System.out.println(ClassLayout.parseInstance(demo1).toPrintable());
        Demo2 demo2 = new Demo2();
        System.out.println(ClassLayout.parseInstance(demo2).toPrintable());
    }
}
