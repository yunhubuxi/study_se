package memory;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.util.concurrent.TimeUnit;

/**
 * jps -l
 * jmap -dump:format=b,file=heapDump 2952
 * heapDump 为文件名，位置在项目代码文件夹下
 * jhat heapDump
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(ObjectSizeCalculator.getObjectSize(new User1()));
        System.out.println(ObjectSizeCalculator.getObjectSize(new User2()));

        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
