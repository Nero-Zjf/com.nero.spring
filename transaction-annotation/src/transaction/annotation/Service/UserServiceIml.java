package transaction.annotation.Service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import transaction.annotation.pojo.User;

public class UserServiceIml implements UserService {
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    @Transactional
    public int addUser(User user) {
            template.update("insert into user values(?,?,?)", 0, "nero", 28);
            template.update("insert into user values(?,?,?)", 0, "city", 26);
            //int i = 1 / 0;
            return 2;
    }
}
