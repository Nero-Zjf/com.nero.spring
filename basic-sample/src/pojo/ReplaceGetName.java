package pojo;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class ReplaceGetName implements MethodReplacer {
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        return obj.getClass() + "replace";
    }
}
