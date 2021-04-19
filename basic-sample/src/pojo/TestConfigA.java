package pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfigA {
    @Bean
    public TestA testA() {
        return new TestA();
    }
}
