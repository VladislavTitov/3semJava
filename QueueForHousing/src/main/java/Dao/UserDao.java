package Dao;

import Models.User;

import java.sql.ResultSet;
import java.util.List;

public interface UserDao {

    User find(String user_name);

    void save(User user);

    List<User> findAll();

    boolean checkPassword(String password);
}
