package Factories;

import Services.*;

public class ServiceFactory {
    private static ServiceFactory ourInstance;

    private UserService userService;
    private QueueService queueService;
    private AdminService adminService;

    public static ServiceFactory getInstance() {
        return ourInstance;
    }

    private ServiceFactory() {
        userService = new UserServiceImpl();
        queueService = new QueueServiceImpl();
        adminService = new AdminServiceImpl();
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

    public AdminService getAdminService() {
        return adminService;
    }
}
