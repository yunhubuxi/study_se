package json;

public class JsonDemo {
    public static void main(String[] args) {
        String aa = "\"";
        String bb = "\\";
        String cc = "\\\\";
        String dd = "\"\\\"";
        System.out.println(aa);
        System.out.println(bb);
        System.out.println(cc);
        System.out.println(dd);
        String[] aaa = "aaa|bbb|ccc".split("");
        String mm = "aaa\tsd\\fsd\nsad";
        System.out.println(mm);

    }
}
