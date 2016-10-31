package Services;

import Models.User;

public interface UserService {

    boolean isRegistered(String user_name);

    void saveUser(User user);

    void checkPassword(String password);

}
