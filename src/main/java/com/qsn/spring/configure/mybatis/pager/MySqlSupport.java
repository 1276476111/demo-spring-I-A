package com.qsn.spring.configure.mybatis.pager;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 拼接sql，用于替换原有sql
 *
 * @author qiusn 2019-11-22
 */
@Component
public class MySqlSupport implements JdbcSupport {

    /**
     * 拼接分页sql
     *
     * @param pager
     * @param sql
     * @return
     */
    @Override
    public String generatePageSql(Pager pager, String sql) {
        long startIndex = (pager.getPageNo() - 1) * pager.getPageSize() + 1;
        long endIndex = startIndex + pager.getPageSize() - 1;
        StringBuilder sqlBuilder = new StringBuilder(sql);

        if (!StringUtils.isEmpty(pager.getSortBy())) {
            sqlBuilder.append(" ORDER BY ");
            sqlBuilder.append(pager.getSortBy());
            sqlBuilder.append(pager.getRank());
        }
        sqlBuilder.append(" limit ");
        sqlBuilder.append(startIndex);
        sqlBuilder.append(",");
        sqlBuilder.append(endIndex);
        return sqlBuilder.toString().toUpperCase();
    }

    /**
     * 拼接计数sql
     *
     * @param sql
     * @return
     */
    @Override
    public String generateCountSql(String sql) {
        return ("SELECT COUNT(*) FROM (" + sql + ") A").toUpperCase();
    }

}