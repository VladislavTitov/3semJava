package Dao;

import Factories.ConnectionToDb;
import Models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public User find(String user_name) {

        User user = null;

        try {
            Statement statement = ConnectionToDb.getInstance().getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT user_name FROM users;");

            while (resultSet.next()){
                if (resultSet.getString("user_name").equals(user_name)) {
                    user = new User(resultSet.getString("user_name"));
                    break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public void save(User user) {
        try {
            PreparedStatement statement = ConnectionToDb.getInstance().getConnection().prepareStatement(
                    "INSERT INTO users VALUES (DEFAULT, ?, ?)"
            );

            statement.setString(1, user.getUser_name());
            statement.setString(2, user.getPassword());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> findAll() {
        return null;
    }

    public boolean checkPassword(String password){

        boolean isValid = false;

        try {
            PreparedStatement statement = ConnectionToDb.getInstance().getConnection().prepareStatement(
                    "SELECT password FROM users WHERE password = ?"
            );

            statement.setString(1, password);

            ResultSet rs = statement.executeQuery();

            if (rs.next()){
                isValid = true;
            }
            if (rs.next()){
                throw new IllegalArgumentException();
            }



        }catch (SQLException e){
            e.printStackTrace();
        }
        return isValid;
    }
}
