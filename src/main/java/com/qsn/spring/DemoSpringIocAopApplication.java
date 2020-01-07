package com.qsn.spring;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 启动类
 * <p>
 * 所用技术： 拦截器分页、
 *
 * @author qiusn 2019-11-20
 */
@SpringBootApplication
public class DemoSpringIocAopApplication {

    public static void main(String[] args) {
        // 锁对象
        Lock lock = new ReentrantLock();
        // 得到锁
        lock.lock();

        SpringApplication app = new SpringApplication(DemoSpringIocAopApplication.class);
        try {
            //关闭打印banner
            app.setBannerMode(Banner.Mode.OFF);
            // 启动
            app.run(args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.err.println("------------------------欢迎------------------------");
            // 释放锁
            lock.unlock();
        }


    }

}
