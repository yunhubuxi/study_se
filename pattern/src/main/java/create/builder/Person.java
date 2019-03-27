package create.builder;

public class Person {

    private String name;
    private String sex;
    private int height;
    private int weigth;
    private String country;

    public static class Builder {
        private String name;
        private String sex;
        private int height;
        private int weigth;
        private String country;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder heigth(int height) {
            this.height = height;
            return this;
        }

        public Builder weigth(int weigth) {
            this.weigth = weigth;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }

    public Person(Builder builder) {
        name = builder.name;
        sex = builder.sex;
        height = builder.height;
        weigth = builder.weigth;
        country = builder.country;
    }
}
