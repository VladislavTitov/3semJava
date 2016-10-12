package Models;

public class Mother {

    private String surname;
    private String name;
    private String middle_name;

    public Mother(String surname, String name, String middle_name) {
        this.surname = surname;
        this.name = name;
        this.middle_name = middle_name;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

}
