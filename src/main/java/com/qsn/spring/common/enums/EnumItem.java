package com.qsn.spring.common.enums;

import lombok.Getter;

import java.io.Serializable;

/**
 * 枚举管理
 *
 * @author qiusn 2019-11-22
 */
@Getter
public class EnumItem<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;

    private final T key;
    private final String name;

    public EnumItem(T key, String name) {
        this.key = key;
        this.name = name;
    }
}