import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().plusDays(1));
        System.out.println(LocalDateTime.now().plusDays(-1));

    }

    static class User {
        int age;
        String name;
    }
}
