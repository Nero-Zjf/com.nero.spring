package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import test.pojo.User;
import test.qualifier.UserQualifier;
import test.service.UserService;

@Component
public class UserController {
    @UserQualifier(name = "nero",age = 15)
    @Autowired
    private UserService userService;

    public UserController() {
        System.out.println("test");
    }

    public User getUser() {
        return userService.getUser();
    }
}
