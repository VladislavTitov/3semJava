package Dao;

import Factories.ConnectionToDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao{

    Connection connection;

    public AdminDaoImpl() {
        try {
            this.connection = ConnectionToDb.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    TODO i should, no, i must use db view here!
    @Override
    public ResultSet selectQueue(boolean deleted) {
        ResultSet rs = null;

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM \"Queue\" WHERE deleted = ?;"
            );

            statement.setBoolean(1, deleted);

            rs = statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
