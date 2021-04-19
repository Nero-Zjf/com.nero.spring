package pojo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({TestConfigA.class,TestConfigB.class,TestC.class})
public class TestConfig {
}
