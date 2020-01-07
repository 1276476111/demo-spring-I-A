package com.qsn.spring.common.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 分页返回参数
 *
 * @author qiusn
 * @version 1.0 2019/11/12 15:48
 */
@Getter
@Setter
@ToString
public class PageData<T> implements Serializable {
    private static final long serialVersionUID = 8867152615705020351L;

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
    private List<T> data;

}
