package aop.annotation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LogAspect {
    //定义切入点
    @Pointcut("execution(* aop.annotation.service.*.*(..))")
    public void myPointcut() {

    }

    //匹配service包下的所有类
    //所有方法的执行作为切入点
    @Before("execution(* aop.annotation.service.*.*(..))&& args(name,age)")
    public void log(String name, int age) {
        System.out.println("name:" + name + " age:" + age);
        System.out.println("@Before---模拟打印日志");
    }

    //匹配service包下所有类的
    //所有方法的执行作为切入点
    @AfterReturning(returning = "rvt"
            , pointcut = "myPointcut()")
    //声明rvt时指定的类型会限制目标方法必须返回指定类型的值或没有返回值
    //此处将rvt的类型声明为object，意味着对目标方法的返回值不加限制
    public void log1(Object rvt) {
        System.out.println("@AfterReturning---获取目标方法返回值:" + rvt);
        System.out.println("@AfterReturning---模拟记录日志功能...");
    }

    //匹配service包下所有类的
    //所有方法的执行作为切入点
    @AfterThrowing(throwing = "ex"
            , pointcut = "myPointcut()")
    //声明ex时指定的类型会限制目标方法必须抛出指定类型的异常
    //此处将ex的类型声明为Throwable,意味着对目标方法抛出的异常不加限制
    public void doRecoveryActions(Throwable ex) {
        System.out.println("@AfterThrowing---目标方法中抛出的异常:" + ex);
        System.out.println("@AfterThrowing---模拟Advice对异常的修复...");
    }

    //匹配service包下所有类的
    //所有方法的执行作为切入点
    @After("execution(* aop.annotation.service.*.*(..))")
    public void release() {
        System.out.println("@After---模拟方法结束后的释放资源...");
    }

    //匹配service包下所有类的
    //所有方法的执行作为切入点
    @Around("execution(* aop.annotation.service.*.*(..))")
    public Object processTx(ProceedingJoinPoint jp) throws java.lang.Throwable {
        System.out.println("@Around---执行目标方法之前，模拟开始事务...");
        //获取目标方法原始的调用参数
        Object[] args = jp.getArgs();
        if (args != null && args.length > 1)
            //修改目标方法调用参数的第一一个参数
            args[0] = " [增加的前缀]" + args[0];

        //以改变后的参数去执行目标方法，并保存目标方法执行后的返回值
        Object rvt = jp.proceed(args);
        System.out.println("@Around---执行目标方法之后，模拟结束事务...");
        //如果rvt的类型是Integer, 将rvt改为它的平方
        if (rvt != null && rvt instanceof Integer)
            rvt = (Integer) rvt * (Integer) rvt;
        return rvt;
    }
}



