package pojo;

import org.springframework.context.annotation.Bean;

public class TestConfigB {
    @Bean
    public TestB testB() {
        return new TestB();
    }
}
