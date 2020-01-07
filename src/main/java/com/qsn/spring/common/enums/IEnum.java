package com.qsn.spring.common.enums;

import java.io.Serializable;

/**
 * 枚举封装类
 *
 * @author qiusn 2019-11-22
 */
public interface IEnum<T extends Serializable> {

    /**
     * 枚举属性封装类
     *
     * @return 封装
     */
    EnumItem<T> item();

}
