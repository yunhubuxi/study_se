package create.builder;

public class Demo {
    public static void main(String[] args) {
        Person person = new Person.Builder().name("测试").sex("nan").weigth(12).build();
        System.out.println(person);
    }
}
