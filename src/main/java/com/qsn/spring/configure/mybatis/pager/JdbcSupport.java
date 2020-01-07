package com.qsn.spring.configure.mybatis.pager;

import org.springframework.stereotype.Component;

/**
 * 拦截的是StatementHandler.prepare方法，
 * 这个方法用于生成statement，参数包含一个Connection对象，
 * 我们可以借助它在查询发起前先先执行计数操作并替换原有的sql语句
 *
 * @author qiusn 2019-11-21
 */
@Component
public interface JdbcSupport {

    String generatePageSql(Pager pager, String sql);

    String generateCountSql(String sql);
}