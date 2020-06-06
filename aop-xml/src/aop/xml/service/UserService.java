package aop.xml.service;

import org.springframework.stereotype.Service;

public class UserService {
    public void getUser() {
        System.out.println("get user");
    }

    public void updUser(String name,int age) {
        System.out.println("upd user");
    }
}