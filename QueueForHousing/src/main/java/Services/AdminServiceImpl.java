package Services;

import Dao.AdminDao;
import Factories.DaoFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminServiceImpl implements AdminService{

    AdminDao adminDao;

    public AdminServiceImpl() {
        this.adminDao = DaoFactory.getInstance().getAdminDao();
    }

    @Override
    public String createQueueTable() {
        ResultSet set = adminDao.selectQueue();

        try {
            while (set.next()){

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
