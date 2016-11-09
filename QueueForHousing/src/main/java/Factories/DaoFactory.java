package Factories;

import Dao.QueueDao;
import Dao.QueueDaoImpl;
import Dao.UserDao;
import Dao.UserDaoImpl;

public class DaoFactory {
    private static DaoFactory ourInstance;
    private UserDao userDao;
    private QueueDao queueDao;

    public static DaoFactory getInstance() {
        return ourInstance;
    }

    private DaoFactory() {
        userDao = new UserDaoImpl();
        queueDao = new QueueDaoImpl();
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
}
