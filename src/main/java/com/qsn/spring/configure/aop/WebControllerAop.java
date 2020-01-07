package com.qsn.spring.configure.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author qiusn
 * @version 1.0 2019/11/20 18:16
 */
@Aspect
//@Configuration
public class WebControllerAop {

    /**
     * 定义切点
     */
    @Pointcut("execution(* com.qsn.spring.generator.controller..*(..))")
    public void executeService() {
        System.err.println(" ===================这段不会被打印=================== ");
    }

    /**
     * 前置通知，方法调用前被调用
     */
    @Before("executeService()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        for (int i = 0; i < obj.length; i++) {
            System.err.println("参数[" + i + "]：" + obj[i].toString());
        }
        System.err.println("AOP代理类的信息：" + joinPoint.getThis());
        System.err.println("代理的目标对象信息：" + joinPoint.getTarget());
        //用的最多 通知的签名
        Signature signature = joinPoint.getSignature();
        System.err.println("代理的是哪一个方法（方法名）:" + signature.getName());
        System.err.println("AOP代理类的名字:" + signature.getDeclaringTypeName());
        //AOP代理类的类（class）信息
        signature.getDeclaringType();
        // 获取 RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        // session
        HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        System.err.println("获取的session信息：" + session);

    }

    /**
     * 后置通知
     */
    @After(value = "execution(* com.qsn.spring.generator.controller..*.*(..))")
    public void doAfter1(JoinPoint joinPoint) {
        System.err.println("============后置通知============：" + joinPoint);
    }

    /**
     * 后置返回通知， 返回值是keys
     * 因为第一个参数为JoinPoint，则第二个参数为返回值的信息
     */
    @AfterReturning(value = "execution(* com.qsn.spring.generator.controller..*.*(..))", returning = "keys")
    public void doAfterReturningAdvice1(JoinPoint joinPoint, Object keys) {
        System.err.println("============第一个后置运行返回通知的返回值============：" + keys);
    }

    /**
     * 后置返回通知， 返回值是keys
     * 因为参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
     */
    @AfterReturning(value = "execution(* com.qsn.spring.generator.controller..*.*(..))", returning = "keys", argNames = "keys")
    public void doAfterReturningAdvice2(Object keys) {
        System.err.println("============第二个后置运行返回通知的返回值============：" + keys);
    }


    /**
     * 环绕通知：
     * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     * <p>
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     */
    @Around("execution(* com.qsn.spring.generator.controller..*.*(..))")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.err.println("============================= 环绕通知 =============================");
        System.err.println("环绕通知的目标方法名：" + proceedingJoinPoint.getSignature().getName());
        try {
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }


}