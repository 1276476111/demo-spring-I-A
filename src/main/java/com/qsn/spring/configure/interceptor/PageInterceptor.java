package com.qsn.spring.configure.interceptor;

import com.qsn.spring.configure.mybatis.pager.Pager;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

/**
 * 分页拦截器
 * <p>
 * 拦截的是StatementHandler.prepare方法，
 * 这个方法用于生成statement，参数包含一个Connection对象，
 * 我们可以借助它在查询发起前先先执行计数操作并替换原有的sql语句
 * <p>
 * 注： MyBatis 3.4.0 之后，StatementHandler的prepare方法做了修改， 应为: args = {Connection.class, Integer.class })
 *
 * @author qiusn 2019-11-21
 */
@Slf4j
@Component
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class PageInterceptor implements Interceptor {

    /**
     * 用正则表达式判断mapper方法名的后缀， 这里是page
     * 若后缀不正确， 则sql不替换， 即分页不生效
     */
    private static final String REGEX_MAPPER_METHOD = ".+page$";

    /**
     * 分页参数所处位置
     */
    private static final String PARAM_PAGE = "param1";

    /**
     * 分页异常信息
     */
    private static final String ERROR_TYPE_CONVERSION = "类型转换异常，分页的入参类与拦截器转换SQL的入参类不匹配。" +
            "请更换C端分页参数类型，或拦截器分页的转换类;  异常信息为[{}]";

    /**
     * (non-Javadoc)
     * 拦截器要执行的方法
     *
     * @author qiusn 2019-11-21
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(
                statementHandler,
                SystemMetaObject.DEFAULT_OBJECT_FACTORY,
                SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,
                new DefaultReflectorFactory()
        );
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        String id = mappedStatement.getId();
        if (id.matches(REGEX_MAPPER_METHOD)) {

            BoundSql boundSql = statementHandler.getBoundSql();
            Map<String, Object> params = (Map<String, Object>) boundSql.getParameterObject();
            Pager page = null;
            try {
                page = (Pager) params.get(PARAM_PAGE);
            } catch (RuntimeException re) {
                log.error(ERROR_TYPE_CONVERSION, re.getMessage());
                re.printStackTrace();
            }
            String sql = boundSql.getSql();
            String countSql = "SELECT COUNT(*) FROM (" + sql + ")a";
            Connection connection = (Connection) invocation.getArgs()[0];
            PreparedStatement countStatement = connection.prepareStatement(countSql);
            ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
            parameterHandler.setParameters(countStatement);
            ResultSet rs = countStatement.executeQuery();
            if (rs.next()) {
                page.setTotal(rs.getInt(1));
            }
            String pageSql = sql + " LIMIT " + page.getPageNo() + "," + page.getPageSize();
            metaObject.setValue("delegate.boundSql.sql", pageSql);
        }
        return invocation.proceed();
    }

    /**
     * (non-Javadoc)
     * 拦截器需要拦截的对象
     */
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    /**
     * (non-Javadoc)
     * 设置初始化的属性值
     */
    @Override
    public void setProperties(Properties properties) {

    }
}