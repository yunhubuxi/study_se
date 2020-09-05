import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User a = new User();
        a.age = 10;
        User b = new User();
        b.age = 20;
        User c = new User();
        c.age = 10;
        User d = new User();
        d.age = 20;
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.forEach(user -> System.out.println("list" + user.age + ">" + user.name));
        List<User> list1 = list.stream().filter(user -> user.age == 10).collect(Collectors.toList());
        list1.forEach(user -> System.out.println("list1" +user.age + ">" + user.name));
        list.stream().filter(e ->e.age == 10).forEach(user -> user.name = "fsd");
        list.forEach(user -> System.out.println("list" +user.age + ">" + user.name));
        list1.forEach(user -> System.out.println("list1" +user.age + ">" + user.name));

    }

    static class User {
        int age;
        String name;
    }
}
