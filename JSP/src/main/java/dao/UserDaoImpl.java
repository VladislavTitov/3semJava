package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    public List<User> findAll() {
        List<User> users = new LinkedList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Programming\\Java Projects\\JSP\\src\\main\\resources\\Users.txt"))) {

            String user_string;
            while ((user_string = reader.readLine())!=null) {
                User newUser = new User(user_string);
                users.add(newUser);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public int addUser(String user_name, int age, String city) {
        return 0;
    }
}
