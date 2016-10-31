package Factories;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionToDb {

    private static ConnectionToDb instance;

    private Properties properties;

    private Connection connection;
    private String driverClass;
    private String url;
    private String name;
    private String password;

    private ConnectionToDb(){

        try {
            properties = new Properties();
            properties.load(new FileInputStream("C:\\Programming\\Java Projects\\QueueForHousing\\src\\main\\resources\\drivers.properties"));

            this.driverClass = properties.getProperty("driver.class");
            this.url = properties.getProperty("url.string");
            this.name = properties.getProperty("user.string");
            this.password = properties.getProperty("password.string");

            Class.forName(driverClass);




        }catch (Exception ex){
            Logger.getLogger(ConnectionToDb.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectionToDb.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    static {
        instance = new ConnectionToDb();
    }

    public static ConnectionToDb getInstance() {
        return instance;
    }

    public Connection getConnection() throws SQLException {
        this.connection = DriverManager.getConnection(url, name, password);
        return this.connection;
    }
}
