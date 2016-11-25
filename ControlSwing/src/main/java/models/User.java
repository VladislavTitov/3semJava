package models;

public class User {

    private final int id;
    private final String surname;
    private final String name;
    private final int age;
    private final boolean married;


    public static class Builder{

        private int id;
        private String surname;
        private String name;
        private int age;
        private boolean married;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setMarried(boolean married) {
            this.married = married;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    private User(Builder builder) {
        this.id = builder.id;
        this.surname = builder.surname;
        this.name = builder.name;
        this.age = builder.age;
        this.married = builder.married;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMarried() {
        return married;
    }
}
