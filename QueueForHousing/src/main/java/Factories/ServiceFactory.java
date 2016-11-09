package Factories;

import Services.QueueService;
import Services.QueueServiceImpl;
import Services.UserService;
import Services.UserServiceImpl;

public class ServiceFactory {
    private static ServiceFactory ourInstance;

    private UserService userService;
    private QueueService queueService;

    public static ServiceFactory getInstance() {
        return ourInstance;
    }

    private ServiceFactory() {
        userService = new UserServiceImpl();
        queueService = new QueueServiceImpl();
    }

    static {
        ourInstance = new ServiceFactory();
    }

    public UserService getUserService() {
        return userService;
    }

    public QueueService getQueueService() {
        return queueService;
    }
}
