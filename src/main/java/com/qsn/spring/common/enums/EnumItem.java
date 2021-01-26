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
    private final String value;

    public EnumItem(T key, String value) {
        this.key = key;
        this.value = value;
    }
}