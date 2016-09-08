package Dao;

import java.util.List;

public interface UsersDao {
    List<User> findAll();
    int save(User user);
    User find(int id);
}
