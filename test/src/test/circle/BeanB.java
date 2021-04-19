package test.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BeanB implements GetName{
    @Qualifier("beanA")
    @Autowired
    private BeanA beanA;

    @Override
    public String getName() {
        return "beanB";
    }
}
