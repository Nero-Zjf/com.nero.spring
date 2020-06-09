package transaction.xml.Service;

import org.springframework.jdbc.core.JdbcTemplate;
import transaction.xml.pojo.User;

public class UserServiceIml implements UserService {
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public int addUser() {
        template.update("insert into user values(?,?,?)", 0, "nero", 28);
        template.update("insert into user values(?,?,?)", 0, "city", 26);
        //int i = 1 / 0;//模拟断电
        return 2;
    }
}
