import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import aop.annotation.service.DogService;
import aop.annotation.service.UserService;

public class AopAnnotationRun {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        DogService dogService = ctx.getBean(DogService.class);
        UserService userService = ctx.getBean(UserService.class);

        dogService.getDog();
        userService.getUser();
        userService.updUser("nero", 20);
    }
}
