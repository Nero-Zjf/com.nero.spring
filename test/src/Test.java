import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.UserController;
import test.autowire.AnotherBean;
import test.autowire.ValueAnnotationTest;
import test.circle.BeanA;
import test.pojo.User;
import test.service.UserService;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        //创建Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //获取指定名称的bean
        //        Student student = (Student) applicationContext.getBean("nero");
        UserController uc = applicationContext.getBean(UserController.class);
        ValueAnnotationTest valueAnnotationTest = (ValueAnnotationTest) applicationContext.getBean("annotationTest");
        ValueAnnotationTest parentAnnotationTest = (ValueAnnotationTest) applicationContext.getBean("parentAnnotationTest");
        AnotherBean anotherBean = (AnotherBean) applicationContext.getBean("anotherBean");
        UserService userService = (UserService) applicationContext.getBean("userService");
        BeanA beanA = applicationContext.getBean(BeanA.class);
        System.out.println(beanA);
        System.out.println(valueAnnotationTest);
        System.out.println(uc.getUser());
        System.out.println(applicationContext.getBean(User.class));
//        applicationContext.close();
    }
}
