package Services;

import Dao.UserDao;
import Factories.DaoFactory;
import Factories.ServiceFactory;
import Models.User;
import Utils.MD5;
import Utils.Token;

import javax.servlet.http.Cookie;

public class UserServiceImpl implements UserService{
    @Override
    public boolean isRegistered(String user_name) {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        if (userDao.find(user_name) != null){
            return true;
        }
        return false;
    }


    @Override
    public void saveUser(User user) {
        User hashUser = new User.Builder()
                .setUserName(user.getUser_name())
                .setPassword(MD5.generateHash(user.getPassword()))
                .build();
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        userDao.save(hashUser);
    }


    @Override
    public boolean checkPassword(String user_name, String password) {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        return userDao.checkPassword(user_name, MD5.generateHash(password));
    }

    @Override
    public Cookie generateCookies() {
        Cookie cookie = new Cookie("qfhCookie", Token.generateToken());
        return cookie;
    }
}
