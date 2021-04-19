package test.circle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;

public class CircleTestBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof BeanA) {
            return Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{GetName.class}
                    , new GetNameProxyHandler());
        }
        return bean;
    }
}
