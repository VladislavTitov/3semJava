package Services;

import Dao.UserDao;
import Factories.DaoFactory;
import Factories.ServiceFactory;
import Models.User;

public class UserServiceImpl implements UserService{
    @Override
    public boolean isRegistered(String user_name) {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        if (userDao.find(user_name) != null){
            return true;
        }
        return false;
    }

    /**
     * MD5 is needed here
     * @param user
     */
    @Override
    public void saveUser(User user) {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        userDao.save(user);
    }

    /**
     * MD5 is needed here
     * @param password
     */
    @Override
    public boolean checkPassword(String user_name, String password) {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        return userDao.checkPassword(user_name, password);
    }
}
