import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.UserController;
import test.pojo.User;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        //创建Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //获取指定名称的bean
        //        Student student = (Student) applicationContext.getBean("nero");
        UserController uc = applicationContext.getBean(UserController.class);
        System.out.println(uc.getUser());
        System.out.println(applicationContext.getBean(User.class));
    }
}
