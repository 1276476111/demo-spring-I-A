package com.qsn.spring.configure.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * AOP切面
 * 测试五种通知顺序切面
 * <p>
 * 顺序：
 * （1）@Around 目标方法开始
 * （2）@Before 前置通知
 * （3）@Around 目标方法执行
 * （4）@Around 目标方法结束
 * （5）@After  后置通知
 * （6）@AfterReturning 返回通知
 * 注解：
 * （1）@Aspect：将一个java类定义为切面类
 * （2）@Pointcut：定义一个切入点
 * （3）@Before、@Around、@After、@AfterReturning、@AfterThrowing：五种不同场景的通知
 * 切点：
 * 在定义切点中，方法体里面不需要有任何代码，它仅仅是一个切点的定义，即使定义了代码也不会执行
 * 在定义切点中，需要指定织入点；通过这种方法，可以在不修改业务代码的情况下，对原有业务逻辑进行拦截处理
 * execution（）：                          表达式的主体
 * 第一个 * 符号 ：                          表示返回值的类型，* 代表所有返回类型
 * com.qsn.spring.generator.controller ：  AOP 所切的服务的包名，即需要进行横切的业务类
 * 包名后面的 .. ：                          表示当前包及子包
 * 第二个 * ：                              表示类名，* 表示所有类
 * 最后的 .*(..) ：                         第一个 . 表示任何方法名，括号内为参数类型，.. 代表任何类型参数
 * 返回通知：
 * 如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息
 * 如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
 * returning 限定了只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行，对于returning对应的通知方法参数为Object类型将匹配任何目标返回值
 * 环绕通知：
 * 环绕通知需要携带ProceedingJoinPoint类型的参数
 * 环绕通知类似于动态代理的全过程ProceedingJoinPoint类型的参数可以决定是否执行目标方法
 * 环绕通知必须有返回值，返回值即目标方法的返回值
 *
 * @author qiusn
 * @version 1.0 2019/11/22 16:43
 */
@Aspect
@Configuration
public class FiveNoticesAop {

    private static int step = 0;

    /**
     * 切点
     */
    @Pointcut("execution(* com.qsn.spring.generator.controller..*(..))")
    public void operation() {

    }

    /**
     * 环绕通知
     */
    @Around("operation()")
    public Object objectDoAroundTask(ProceedingJoinPoint pjp) {
        String methodName = pjp.getSignature().getName();
        Object result = null;
        try {
            // 前置通知
            System.out.println(++step + "@Around目标方法" + methodName + "开始，参数为" + Arrays.asList(pjp.getArgs()));
            // 执行目标方法
            result = pjp.proceed();
            // 返回通知
            System.out.println(++step + "@Around目标方法" + methodName + "执行成功，返回" + result);
        } catch (Throwable e) {
            // 异常通知
            System.out.println(++step + "@Around目标方法" + methodName + "抛出异常: " + e.getMessage());
        }
        // 后置通知
        System.out.println(++step + "@Around目标方法" + methodName + "结束");
        return result;
    }

    /**
     * 前置通知
     */
    @Before("operation()")
    public void doBeforeTask() {
        System.out.println(++step + " 前置通知");
    }

    /**
     * 后置通知
     */
    @After("operation()")
    public void
    doAfterTask() {
        System.out.println(++step + " 后置通知");
    }

    /**
     * 返回通知
     */
    @AfterReturning(pointcut = "operation()", returning = "retVal")
    public void doAfterReturningTask(Object retVal) {
        System.out.println(++step + " 返回通知，返回值为：" + retVal.toString());
    }

    /**
     * 异常通知
     */
    @AfterThrowing(pointcut = "operation()", throwing = "ex")
    public void doAfterThrowingTask(Exception ex) {
        System.out.println(++step + " 异常通知，异常信息为：" + ex.getMessage());
    }
}
