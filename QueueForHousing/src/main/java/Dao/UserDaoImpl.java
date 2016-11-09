package Dao;

import Factories.ConnectionToDb;
import Models.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public User find(String user_name) {

        User user = null;

        try {
            Statement statement = ConnectionToDb.getInstance().getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT user_name FROM \"Users\";");

            while (resultSet.next()){
                if (resultSet.getString("user_name").equals(user_name)) {
                    user = new User.Builder().setUserName(resultSet.getString("user_name")).build();
                    break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     * Should be saving date of registration
     * @param user
     */
    public void save(User user) {
        try {
            PreparedStatement statement = ConnectionToDb.getInstance().getConnection().prepareStatement(
                    "INSERT INTO \"Users\" (user_id, user_name, password, token, date_registration)  VALUES (DEFAULT, ?, ?, ?, ?);"
            );

            statement.setString(1, user.getUser_name());
            statement.setString(2, user.getPassword());
            if (user.getRemember()){
                statement.setString(3, user.getToken());
            }else {
                statement.setString(3, "");
            }
            statement.setDate(4, Date.valueOf(LocalDate.now()));

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkPassword(String user_name, String password){

        boolean isValid = false;

        try {
            PreparedStatement statement = ConnectionToDb.getInstance().getConnection().prepareStatement(
                    "SELECT password FROM \"Users\" WHERE user_name = ? AND password = ?;"
            );

            statement.setString(1, user_name);
            statement.setString(2, password);

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

    @Override
    public void saveToken(String userName, String token) {
        try {
            PreparedStatement statement = ConnectionToDb.getInstance().getConnection().prepareStatement(
                "UPDATE \"Users\" SET token = ? WHERE user_name = ?;"
            );

            statement.setString(1, token);
            statement.setString(2, userName);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String isExistToken(String token) {
        String userNameOnToken = null;

        try {
            PreparedStatement statement = ConnectionToDb.getInstance().getConnection().prepareStatement(
                "SELECT user_name FROM \"Users\" WHERE token = ?;"
            );

            statement.setString(1, token);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                userNameOnToken = resultSet.getString("user_name");
            }
            if (resultSet.next()){
                throw new IllegalArgumentException();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userNameOnToken;
    }

    @Override
    public void addQueueToUser(String userName, int queueId) {
        try {
            PreparedStatement statement = ConnectionToDb.getInstance().getConnection().prepareStatement(
                    "UPDATE \"Users\" SET queue_id = ? WHERE user_name = ?;"
            );

            statement.setInt(1, queueId);
            statement.setString(2, userName);

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
