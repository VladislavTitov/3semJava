package dao;

public class User {
    private String name;
    private int age;
    private String city;


    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return name + " " + age + " " + city;
    }
}
