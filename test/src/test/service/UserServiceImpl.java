package test.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import test.pojo.User;
import test.qualifier.UserQualifier;


public class UserServiceImpl implements UserService {
    @Override
    public User getUser() {
        return new User("0", 0);
    }
}
