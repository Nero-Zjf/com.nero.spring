package test.factory;

import test.service.UserService;
import test.service.UserServiceImpl1;

public class UserServiceFactory {
    public static UserService getUserService() {
        return new UserServiceImpl1();
    }
}
