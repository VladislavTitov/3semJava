package Factories;

import Dao.*;

public class DaoFactory {
    private static DaoFactory ourInstance;
    private UserDao userDao;
    private QueueDao queueDao;
    private AdminDao adminDao;

    public static DaoFactory getInstance() {
        return ourInstance;
    }

    private DaoFactory() {
        userDao = new UserDaoImpl();
        queueDao = new QueueDaoImpl();
        adminDao = new AdminDaoImpl();
    }

    static {
        ourInstance = new DaoFactory();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public QueueDao getQueueDao() {
        return queueDao;
    }

    public AdminDao getAdminDao() {
        return adminDao;
    }
}
