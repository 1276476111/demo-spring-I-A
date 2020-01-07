package com.qsn.spring.generator.controller;


import com.qsn.spring.configure.annotation.MyFirstAnnotation;
import com.qsn.spring.configure.mybatis.pager.Pager;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;
import com.qsn.spring.generator.service.TestUserService;
import com.qsn.spring.generator.entity.TestUser;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import javax.annotation.Resource;

/**
 * 前端控制器
 *
 * @author qiusn
 * @since 2019-11-20
 */
@Slf4j
@RestController
@RequestMapping("/test-user")
public class TestUserController {

    @Resource
    private TestUserService testUserService;


    /**
     * 详情
     */
    @PostMapping("info")
    @MyFirstAnnotation("吃饭了啊")
    public TestUser getById(@RequestBody TestUser search) {
        TestUser testUser = testUserService.getById(search.getId());
        return testUser;
    }

    /**
     * 分页
     */
    @PostMapping("page")
    public List<TestUser> page(@RequestBody Pager<TestUser> pager) {
        List<TestUser> testUsers = testUserService.page(pager);
        return testUsers;
    }


}
