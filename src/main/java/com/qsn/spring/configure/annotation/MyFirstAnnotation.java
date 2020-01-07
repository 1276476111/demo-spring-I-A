package com.qsn.spring.configure.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 * <p>
 * 使用@interface来声明一个注解
 * 其中的每一个方法实际上是声明了一个配置参数。
 * 方法的名称就是参数的名称，返回值类型就是参数的类型（返回值类型只能是基本类型、Class、String、enum）。
 * 可以通过default来声明参数的默认值。
 *
 * @author qiusn 2019-11-22
 * @Target 定义注解修饰的目标，比如@RequestMapping 就是用来修饰方法和类
 * @Retention 定义注解的生命周期(源码级别 、 编译期级别 、 运行期级别)
 * @Documented 定义注解会被javadoc或者其他类似工具文档化
 * @Mapping 定义注解是一个web mapping annotation
 * <p>
 * 自定义注解语法：
 * 　　public @interface 注解名 {
 * 定义体
 * }
 * </p>
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyFirstAnnotation {
    String value() default "";
}