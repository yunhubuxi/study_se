package baidu;

public class People {
    public int age;

    public static void swap(People a1, People a2) {
        People temp;
        temp = a1;
        a1 = a2;
        a2 = temp;
        a1 = null;
        a2 = null;
    }

    public static void change(People a1, People a2) {
        a1.age = 251;
        a2.age = 252;
    }

    public static void func(int a) {
        a = 20;
        System.out.println(a);
    }

    public static void main(String[] args) {
        People a1 = new People();
        People a2 = new People();
        a1.age = 1;
        a2.age = 2;

        People.swap(a1, a2);
        System.out.println(a1.age);
        System.out.println(a2.age);

        People.change(a1, a2);
        System.out.println(a1.age);
        System.out.println(a2.age);

        func(3);

    }
}
