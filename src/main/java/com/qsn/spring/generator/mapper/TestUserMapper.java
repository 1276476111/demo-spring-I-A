package com.qsn.spring.generator.mapper;

import com.qsn.spring.generator.entity.TestUser;
import com.qsn.spring.configure.mybatis.pager.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author qiusn 2019-11-20
 */
public interface TestUserMapper {
    /**
     * 详情
     *
     * @param id 主键
     * @return
     * @author qiusn
     */
    TestUser getById(@Param(value = "id") Long id);

    /**
     * 拦截器分页sql
     *
     * @param pager    分页参数
     * @param testUser 条件
     * @return
     */
    List<TestUser> page(Pager pager, TestUser testUser);


}
