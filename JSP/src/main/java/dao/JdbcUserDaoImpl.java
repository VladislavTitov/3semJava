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
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(
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
}
