package aop.xml.aspect;


import org.aspectj.lang.ProceedingJoinPoint;

public class LogAspect {
    public void log(String name, int age) {
        System.out.println("@Before---name:" + name + " age:" + age);
        System.out.println("@Before---模拟打印日志");
    }

    public void log1(Object rvt) {
        System.out.println("@AfterReturning---获取目标方法返回值:" + rvt);
        System.out.println("@AfterReturning---模拟记录日志功能...");
    }

    public void doRecoveryActions(Throwable ex) {
        System.out.println("@AfterThrowing---目标方法中抛出的异常:" + ex);
        System.out.println("@AfterThrowing---模拟Advice对异常的修复...");
    }

    public void release() {
        System.out.println("@After---模拟方法结束后的释放资源...");
    }

    public Object processTx(ProceedingJoinPoint jp) throws Throwable {
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



