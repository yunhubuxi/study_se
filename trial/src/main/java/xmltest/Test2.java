package xmltest;

public class Test2 {
    public static void main(String[] args) {
        int i = -3;
        int a = i >> 15;
        System.out.println(a);
        int b = i << 14;
        System.out.println(b);
        System.out.println(Integer.toBinaryString(i));
    }
}
