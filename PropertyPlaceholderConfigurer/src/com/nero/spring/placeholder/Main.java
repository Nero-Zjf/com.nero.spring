package com.nero.spring.placeholder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        ////创建Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Student student = applicationContext.getBean(Student.class);
        System.out.println(student);
    }
}
