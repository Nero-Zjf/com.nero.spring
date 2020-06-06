import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Student;

import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        //创建Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //获取指定名称的bean
        //        Student student = (Student) applicationContext.getBean("nero");
        Student student = applicationContext.getBean("nero", Student.class);
        student.readBook();
    }
}
