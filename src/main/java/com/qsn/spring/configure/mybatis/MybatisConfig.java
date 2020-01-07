package com.qsn.spring.configure.mybatis;

import com.qsn.spring.configure.interceptor.PageInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置mybatis： 1.包扫描  2.分页拦截器
 *
 * @author qiusn 2019-11-22
 */
@MapperScan("com.qsn.spring.generator.mapper")
@Configuration
public class MybatisConfig {
    /**
     * 添加mybatis分页拦截器
     * <p>
     * 这里注意引包： 由于我们自己写了一套拦截配置， 所以：类“PageInterceptor”引包要引我们自己的
     *
     * @return
     */
    @Bean
    public PageInterceptor pageInterceptor() {
        return new PageInterceptor();
    }

}