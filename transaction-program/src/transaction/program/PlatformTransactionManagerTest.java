package transaction.program;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 使用PlatformTransactionManager进行编程式管理事务
 */
public class PlatformTransactionManagerTest {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        PlatformTransactionManager txManager =  ctx.getBean(PlatformTransactionManager.class);
        JdbcTemplate template = ctx.getBean(JdbcTemplate.class);

        //使用PlatformTransactionManager 编程式事务管理
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setReadOnly(false);
        //隔离级别,-1表示使用数据库默认级别
        def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus ts = txManager.getTransaction(def);
        template.update("insert into user (name,age) values (?,?)", "nero", 18);
        txManager.rollback(ts);
        //txManager.commit(ts);
    }
}
