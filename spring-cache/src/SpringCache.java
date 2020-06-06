import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

public class SpringCache {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = ctx.getBean(UserService.class);
        if (userService != null) {
            System.out.println("userService.getAnotherUser---"+userService.getAnotherUser("nero", 10));
            System.out.println("userService.getAnotherUser---"+userService.getAnotherUser("nero", 20));
            System.out.println("userService.getAnotherUser---"+userService.getAnotherUser("sunney", 20));
            System.out.println("userService.getAnotherUser---"+userService.getAnotherUser("sunney", 20));
            System.out.println("userService.getUsersByNameAndAge---"+userService.getUsersByNameAndAge("sunney", 20));
        }
    }
}
