import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringRun {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans*.xml");
        //ResourcePOJO resourcePOJO = applicationContext.getBean(ResourcePOJO.class);
        //System.out.println(resourcePOJO.getRes().exists());
        System.out.println(applicationContext.getResource("http://www.baidu.com").getDescription());
        System.out.println("test");
    }
}
