package Factories;

import Dao.UserDao;
import Dao.UserDaoImpl;

public class DaoFactory {
    private static DaoFactory ourInstance;
    private UserDao userDao;

    public static DaoFactory getInstance() {
        return ourInstance;
    }

    private DaoFactory() {
        userDao = new UserDaoImpl();
    }

    static {
        ourInstance = new DaoFactory();
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
