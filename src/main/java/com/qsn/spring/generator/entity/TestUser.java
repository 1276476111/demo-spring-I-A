package com.qsn.spring.generator.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.math.BigDecimal;

import com.qsn.spring.common.base.BaseDO;

/**
 * @author qiusn 2019-11-20
 */
@Getter
@Setter
@ToString
public class TestUser extends BaseDO {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 名称
     */
    private String userName;

    /**
     * 名称
     */
    private String password;

    /**
     * 性别（1男，2女，3不男不女）
     */
    private Boolean sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 还有多少钱
     */
    private BigDecimal money;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    private Date updateTime;

}