package pojo;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class StudentBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return Student.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String name = element.getAttribute("name");
        String book = element.getAttribute("book");
        if (StringUtils.hasText(name)) {
            builder.addPropertyValue("name", name);
        }

        if (StringUtils.hasText(book)) {
            builder.addPropertyReference("book", book);
        }
    }
}
