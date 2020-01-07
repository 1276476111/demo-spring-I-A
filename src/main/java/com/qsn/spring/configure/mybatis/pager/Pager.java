package com.qsn.spring.configure.mybatis.pager;

import com.esotericsoftware.kryo.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 分页参数
 *
 * @author qiusn 2019-11-21
 */
@Getter
@Setter
@ToString
public class Pager<T> {

    /**
     * 查询条件的实体
     */
    private T search;

    /**
     * 页码
     */
    @NotNull
    private int pageNo;

    /**
     * 每页记录数
     */
    private int pageSize;

    /**
     * 符合的总记录数
     */
    private int total;

    private String sortBy;

    private String rank = "DESC";

    public int getPageNo() {
        return pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotal() {
        return total;
    }

    public String getSortBy() {
        return sortBy;
    }

    public String getRank() {
        return rank;
    }

    public Pager setPageNo(int pageNo) throws IllegalAccessException {
        if (pageNo <= 0) {
            throw new IllegalAccessException("分页页码必须大于0");
        }
        this.pageNo = pageNo;
        return this;
    }

    public Pager setPageSize(int pageSize) throws IllegalAccessException {
        if (pageSize <= 0) {
            throw new IllegalAccessException("单页数据量必须大于0");
        }
        this.pageSize = pageSize;
        return this;
    }

    public Pager setTotal(int total) {
        this.total = total;
        return this;
    }

    public Pager setSortBy(String sortBy) {
        this.sortBy = sortBy;
        return this;
    }

    public Pager setRank(String rank) {
        this.rank = rank;
        return this;
    }
}