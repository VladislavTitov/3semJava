package Services;

import Models.User;

import javax.servlet.http.Cookie;

public interface UserService {

    boolean isRegistered(String user_name);

    Cookie saveUser(User user);

    boolean checkPassword(String user_name, String password);

    Cookie generateCookies();

    void saveToken(String userName, String token);

    String isExistToken(String token);

}
