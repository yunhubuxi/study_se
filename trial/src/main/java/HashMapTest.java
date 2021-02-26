import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * e.hash & oldCap
 * 1 & 16 = 0
 * 17 & 16 != 0
 * 33 & 16 = 0
 * 49 & 16 != 0
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<User, String> map = new HashMap();
        User user1 = new User(1);
        User user2 = new User(17);
        User user3 = new User(33);
        User user4 = new User(49);
        map.put(user1,"1");
        map.put(user2,"17");
        map.put(user3,"33");
        map.put(user4,"49");
        for (int i = 0; i < 10; i++) {
            map.put(new User(i + 100), null);
        }





    }
    static class User {
        String name;
        int age;

        public User(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return age == user.age &&
                Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return age;
        }
    }
}
