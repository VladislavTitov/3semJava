package dao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcUserDaoImpl implements UserDao{

    Connection connection;
    String url;
    String name;
    String password;

    public JdbcUserDaoImpl() {
        this.url = "jdbc:postgresql://127.0.0.1:5432/learningdb";
        this.name = "postgres";
        this.password = "1997nbnjddkflbckfd";
    }

    @Override
    public List<User> findAll() {
        List<User> list = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);
            Statement statementFind = connection.createStatement();
            ResultSet result = statementFind.executeQuery(
                    "SELECT * FROM users;"
            );
            list = new LinkedList<>();
            while (result.next()) {
                list.add(new User(result.getString("user_name"), result.getInt("age"), result.getString("city")));
            }
        }catch (Exception ex){
            Logger.getLogger(JdbcUserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (connection != null){
                try {
                    connection.close();
                }catch (SQLException ex){
                    Logger.getLogger(JdbcUserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }
        return list;
    }

    @Override
    public int addUser(String user_name, int age, String city) {
        int id = -1;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);
            Statement statementAdd = connection.createStatement();
            statementAdd.executeUpdate(
                    "INSERT INTO users (user_name, age, city) VALUES ('"+user_name+"', "+age+", '"+city+"');"
            );
            ResultSet rs = statementAdd.executeQuery(
                    "SELECT id FROM users WHERE user_name = '"+user_name+"' AND age = "+age+" AND city = '"+city+"';"
            );
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (Exception e) {
            Logger.getLogger(JdbcUserDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    Logger.getLogger(JdbcUserDaoImpl.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return id;
    }
}
