package hashmaptest;

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
public class HashMapTest2 {
    public static void main(String[] args) {
        Map<User, String> map = new HashMap();
        for (int i = 0; i < 18; i++) {
            map.put(new User(i), i + "");
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
            return 1;
        }
    }
}
