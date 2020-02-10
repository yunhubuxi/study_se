package descarte;

import java.io.File;

public class StringLong {
    public static void main(String[] args) throws Exception{
        File file = new File("../");
        String aa = file.getCanonicalPath();
        System.out.println(aa);
        System.out.println(System.getProperty("user.dir"));
        String a = "java.specification.name";
        String b = "user.dir";
        System.out.println("java.specification.name");
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println("user.dir");
    }
}
