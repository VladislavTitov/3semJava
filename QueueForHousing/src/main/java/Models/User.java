package Models;

public class User {

    private String user_name;

    private String password;

    public User(String user_name) {
        this.user_name = user_name;
    }

    public User(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_name='" + user_name + '\'' +
                '}';
    }
}
