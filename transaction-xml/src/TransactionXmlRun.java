import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import transaction.xml.Service.UserService;
import transaction.xml.pojo.User;

import java.sql.SQLException;

public class TransactionXmlRun {
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
