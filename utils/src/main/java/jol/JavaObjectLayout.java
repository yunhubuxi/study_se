package jol;

import org.openjdk.jol.info.ClassLayout;

public class JavaObjectLayout {
    public static void main(String[] args) {
        System.out.println("------------Object---------------");
        Object o = new Object();
        System.out.println(o.hashCode());
        String s = ClassLayout.parseInstance(o).toPrintable();
        System.out.println(s);
    }
}
