package com.qsn.spring.configure.aop;

import com.qsn.spring.configure.annotation.MyFirstAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 将 注解@MyFirstAnnotation 切面处理
 *
 * @author qiusn 2019-11-22
 */
@Aspect
@Component
public class MyFirstAnnotationAop {

    /**
     * 注解切点
     *
     * @param myFirstAnnotation
     */
    @Pointcut("@annotation(myFirstAnnotation)")
    public void annotationPointcut(MyFirstAnnotation myFirstAnnotation) {
    }

    /**
     * 切点前执行
     *
     * @param joinPoint
     * @param myFirstAnnotation
     */
    @Before("annotationPointcut(myFirstAnnotation)")
    public void beforePointcut(JoinPoint joinPoint, MyFirstAnnotation myFirstAnnotation) {
        System.err.println("准备" + myFirstAnnotation.value());
    }

    /**
     * 切点后执行
     *
     * @param joinPoint
     * @param myFirstAnnotation
     */
    @After("annotationPointcut(myFirstAnnotation)")
    public void afterPointcut(JoinPoint joinPoint, MyFirstAnnotation myFirstAnnotation) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        MyFirstAnnotation annotation = method.getAnnotation(MyFirstAnnotation.class);
        String value = annotation.value();

        System.err.println("结束" + myFirstAnnotation.value());
    }


    /**
     * 切点环绕执行
     *
     * @param joinPoint
     * @param myFirstAnnotation
     * @return
     * @throws Throwable
     */
    @Around(value = "execution(public * com.qsn..*.*(..)) && @annotation(myFirstAnnotation) ")
    public Object dealAnnotation(ProceedingJoinPoint joinPoint, MyFirstAnnotation myFirstAnnotation) throws Throwable {
        System.err.println("环绕执行方法前" + myFirstAnnotation.value());
        Object response = joinPoint.proceed();
        System.err.println("环绕执行方法后：" + response);
        return response;
    }


}