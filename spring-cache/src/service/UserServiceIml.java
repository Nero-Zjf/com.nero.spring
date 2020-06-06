package service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pojo.User;

@Service("userService")
@Cacheable(value = "users", condition = "#age>10")
public class UserServiceIml implements UserService {
    public User getUsersByNameAndAge(String name, int age) {
        System.out.println("--正在执行findUsersByNameAndAge ()查询方法--");
        return new User(name, age);
    }

    public User getAnotherUser(String name, int age) {
        System.out.println("--正在执行findAnotherUser ()查询方法--");
        return new User(name, age);
    }
}
