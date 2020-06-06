import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import transaction.annotation.Service.UserService;
import transaction.annotation.pojo.User;

import java.sql.SQLException;

public class TransactionAnnotationRun {
    public static void main(String[] args) throws SQLException {
        try {
            ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
            UserService userService = ctx.getBean(UserService.class);

            System.out.println(userService.addUser(new User("nero", 18)));

            System.out.println("正常退出");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
