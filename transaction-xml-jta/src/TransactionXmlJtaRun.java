import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import transaction.xml.jta.Service.UserService;
import transaction.xml.jta.pojo.User;

import java.sql.SQLException;

public class TransactionXmlJtaRun {
    public static void main(String[] args) throws SQLException {
        try {
            ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
            UserService userService = ctx.getBean(UserService.class);

            System.out.println(userService.addUser());

            System.out.println("正常退出");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
