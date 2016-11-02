package Dao;

import Models.User;

import java.sql.ResultSet;
import java.util.List;

public interface UserDao {

    User find(String user_name);

    void save(User user);

    boolean checkPassword(String user_name, String password);

    void saveToken(String userName, String token);

    String isExistToken(String token);
}
