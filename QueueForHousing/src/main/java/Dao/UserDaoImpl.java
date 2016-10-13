package Dao;

import Models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoImpl implements UserDao {
    public User find(String user_name) {

        User user = null;

        try {
            Statement statement = ConnectionToDb.getInstance().getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");

            while (resultSet.next()){
                user = new User(resultSet.getString("user_name"));
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("user_name"));
                break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public void save(User user) {

    }

    public List<User> findAll() {
        return null;
    }
}
