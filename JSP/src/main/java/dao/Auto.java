package dao;

public class Auto {
    private String name;

    public Auto() {
    }

    public Auto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
