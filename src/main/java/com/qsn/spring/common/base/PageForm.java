package com.qsn.spring.common.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 分页请求参数
 *
 * @author qiusn
 * @version 1.0 2019/11/13 15:33
 */
@Getter
@Setter
@ToString
public class PageForm<T> implements Serializable {

    private static final long serialVersionUID = 7628181380027893357L;
    /**
     * 每页多少条数据
     */
    private int pageSize;

    /**
     * 当前页是第几页
     */
    private int currentPage;

    /**
     * 总页数
     */
    private int totalPages;

    /**
     * 总记录数
     */
    private long totalRows;

    /**
     * 实体查询条件
     */
    private T data;
}
