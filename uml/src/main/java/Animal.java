import java.util.List;

public class Animal {
    public String name;
    private int age;
    protected String trueName;
    String sex;
    Water water;

    List<Water> waterList;

    public Animal() {
        water = new Water();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public void drink(Water water){
        System.out.println("drink water");
    }
}
