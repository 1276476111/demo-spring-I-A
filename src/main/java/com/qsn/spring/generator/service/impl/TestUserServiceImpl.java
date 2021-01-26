package com.qsn.spring.generator.service.impl;

import com.qsn.spring.configure.mybatis.pager.Pager;
import com.qsn.spring.generator.common.enums.TestEnums;
import com.qsn.spring.generator.entity.TestUser;
import com.qsn.spring.generator.mapper.TestUserMapper;
import com.qsn.spring.generator.service.TestUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 服务实现类
 *
 * @author qiusn
 * @since 2019-11-20
 */
@Slf4j
@Service
public class TestUserServiceImpl implements TestUserService {
    @Resource
    private TestUserMapper testUserMapper;


    /**
     * 详情
     *
     * @param id 主键
     * @return
     */
    @Override
    public TestUser getById(Long id) {
        System.err.println("枚举1：" + TestEnums.USER_SEX.values());
        System.err.println("枚举2：" + TestEnums.USER_SEX.SEX_MAN);
        System.err.println("枚举3：" + TestEnums.USER_SEX.SEX_MAN.item().getKey());
        System.err.println("枚举4：" + TestEnums.USER_SEX.SEX_MAN.item().getValue());
        System.err.println("枚举5：" + TestEnums.USER_SEX.SEX_MAN.item().toString());


        System.err.println("枚举6：" + TestEnums.USER_SEX.SEX_MAN.item().toString());


        return testUserMapper.getById(id);
    }

    /**
     * 拦截器分页
     *
     * @param pager 分页参数
     * @return
     */
    @Override
    public List<TestUser> page(Pager<TestUser> pager) {
        List<TestUser> testUsers = testUserMapper.page(pager, pager.getSearch());
        return testUsers;
    }


}
