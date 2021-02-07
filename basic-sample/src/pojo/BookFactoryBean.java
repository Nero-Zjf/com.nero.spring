package pojo;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.AbstractFactoryBean;

public class BookFactoryBean extends AbstractFactoryBean<Book> {
    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    @Override
    protected Book createInstance() throws Exception {
        return new Book("factoryBean");
    }
}
