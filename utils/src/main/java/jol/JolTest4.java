package jol;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

public class JolTest4 {
    public static void main(String[] args) {
        User1 user1 = new User1();
        System.out.println(ObjectSizeCalculator.getObjectSize(user1));
        System.out.println(ClassLayout.parseInstance(user1).toPrintable());
        User2 user2 = new User2();
        System.out.println(ObjectSizeCalculator.getObjectSize(user2));
        System.out.println(ClassLayout.parseInstance(user2).toPrintable());

    }

    static class User1 {
        public User1() {
            this.age = 1;
            this.a = 2;
            this.b = 566;
            this.c = 23423;
        }

        Integer age;
        Integer a;
        Integer b;
        Integer c;
    }

    static class User2 {
        public User2() {
            this.age = 1;
            this.a = 2;
            this.b = 566;
            this.c = 23423;
        }

        int age;
        int a;
        int b;
        int c;
    }

}
