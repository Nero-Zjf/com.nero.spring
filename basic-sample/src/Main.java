import event.TestEvent;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import pojo.Book;
import pojo.Student;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        ////创建Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        applicationContext.publishEvent(new TestEvent(applicationContext));
        //获取指定名称的bean
        //        Student student = (Student) applicationContext.getBean("nero");
        Student student = applicationContext.getBean("nero", Student.class);
        student.readBook();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new DefaultListableBeanFactory());
        xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("beans.xml"));
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) xmlBeanDefinitionReader.getBeanFactory();
        Student nero = beanFactory.getBean("nero", Student.class);
        //Student nero = beanFactory.getBean("customnero", Student.class);
        //Book book = beanFactory.getBean("book", Book.class);
        nero.readBook();
        Book bookByFactory = beanFactory.getBean("bookByFactory", Book.class);
        FactoryBean fb = (FactoryBean) beanFactory.getBean("&bookByFactory");
        System.out.println(bookByFactory);
        //Enumeration<URL> resources = XmlBeanDefinitionReader.class.getClassLoader().getResources("META-INF/spring.handlers");
        //while (resources.hasMoreElements()) {
        //    System.out.println(resources.nextElement());
        //}


    }
}
