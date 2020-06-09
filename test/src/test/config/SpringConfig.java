package test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.pojo.User;

@Configuration
public class SpringConfig {
    @Bean
    public User getUser() {
        return new User("config",20);
    }
}
