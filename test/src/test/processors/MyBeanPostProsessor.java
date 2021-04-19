package test.processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import test.UserController;

@Component
public class MyBeanPostProsessor implements BeanPostProcessor, PriorityOrdered {
    public MyBeanPostProsessor() {
        System.out.println("instantiate MyBeanPostProsessor");
    }

    @Autowired
    private UserController userController;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public int getOrder() {
        return 10;
    }
}
