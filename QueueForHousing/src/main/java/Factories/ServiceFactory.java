package Factories;

import Services.UserService;
import Services.UserServiceImpl;

public class ServiceFactory {
    private static ServiceFactory ourInstance;

    UserService userService;

    public static ServiceFactory getInstance() {
        return ourInstance;
    }

    private ServiceFactory() {
        userService = new UserServiceImpl();
    }

    static {
        ourInstance = new ServiceFactory();
    }

    public UserService getUserService() {
        return userService;
    }
}
