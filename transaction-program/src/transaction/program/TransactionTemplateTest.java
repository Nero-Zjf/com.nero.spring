package transaction.program;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 使用TransactionTemplate进行编程式管理事务
 */
public class TransactionTemplateTest {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        JdbcTemplate template = ctx.getBean(JdbcTemplate.class);

        //使用TransactionTemplate 编程式事务管理
        TransactionTemplate transactionTemplate = ctx.getBean(TransactionTemplate.class);
        Object i = transactionTemplate.execute(new TransactionCallback() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                try {
                    template.update("insert into user (name,age) values (?,?)", "test", 266);
                    int i = 1 / 0;//模拟断电
                    return 1;
                } catch (Exception ex) {
                    status.setRollbackOnly();
                    return 0;
                }
            }
        });

        System.out.println(i);
    }
}
