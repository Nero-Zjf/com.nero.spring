package pojo;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class NeroNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("student", new StudentBeanDefinitionParser());
    }
}
