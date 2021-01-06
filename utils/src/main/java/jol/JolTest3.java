package jol;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.openjdk.jol.info.ClassLayout;

/**
 * 数组是一个特殊的对象，对象头上会多4个字节存储数组长度
 * 数组的对象大小可以通过内存布局直接算出
 * 对象的属性如果有对象，不只基本类型的话
 * 内存布局和对象占的内存是不一致的
 */
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
