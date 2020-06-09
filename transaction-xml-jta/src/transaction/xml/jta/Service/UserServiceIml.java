package transaction.xml.jta.Service;

import org.springframework.jdbc.core.JdbcTemplate;
import transaction.xml.jta.pojo.User;

public class UserServiceIml implements UserService {
    private JdbcTemplate template;
    private JdbcTemplate template1;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void setTemplate1(JdbcTemplate template1) {
        this.template1 = template1;
    }

    @Override
    public int addUser() {
        template.update("insert into user values(?,?,?)", 0, "nero", 28);
        template1.update("insert into user values(?,?,?)", 0, "city", 26);
        //int i = 1 / 0;//模拟断电
        return 2;
    }
}
