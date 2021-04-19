package test.circle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GetNameProxyHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy start");
        Object invoke = method.invoke(proxy, args);
        System.out.println("proxy end");
        return invoke;
    }
}
