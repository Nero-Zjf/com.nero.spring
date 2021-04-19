package test.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BeanA implements GetName{
    @Qualifier("beanB")
    @Autowired
    private BeanB beanB;

    @Override
    public String getName() {
        return "beanA";
    }
}
