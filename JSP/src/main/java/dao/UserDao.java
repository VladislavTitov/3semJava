package dao;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    int addUser(String user_name, int age, String city);
}
