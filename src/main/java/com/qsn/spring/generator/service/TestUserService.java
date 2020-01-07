package com.qsn.spring.generator.service;

import com.qsn.spring.generator.entity.TestUser;
import com.qsn.spring.configure.mybatis.pager.Pager;

import java.util.List;

/**
 * 服务类
 *
 * @author qiusn
 * @since 2019-11-20
 */
public interface TestUserService {

    /**
     * 详情
     *
     * @param id 主键
     * @return
     */
    TestUser getById(Long id);

    /**
     * 拦截器分页sql
     *
     * @param pager 分页参数
     * @return
     */
    List<TestUser> page(Pager<TestUser> pager);
}
