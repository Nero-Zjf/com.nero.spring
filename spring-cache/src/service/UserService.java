package service;

import pojo.User;

public interface UserService {
    User getUsersByNameAndAge (String name, int age);
    User getAnotherUser (String name, int age);
}
