package Services;

import Dao.UserDao;
import Dao.UserDaoImpl;
import Models.User;

public class UserServiceImpl implements UserService{
    @Override
    public boolean isRegistered(String user_name) {
        UserDao userDao = new UserDaoImpl();
        if (userDao.find(user_name) != null){
            return true;
        }
        return false;
    }

    @Override
    public void saveUser(User user) {
        UserDao userDao = new UserDaoImpl();
        userDao.save(user);
    }

}
