package test.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import test.pojo.User;
import test.qualifier.UserQualifier;

//@UserQualifier(name = "nero",age = 15)
public class UserServiceImpl1 implements UserService {
    @Override
    public User getUser() {
        return new User("1",1);
    }
}
