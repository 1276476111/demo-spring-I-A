package com.qsn.spring.common.enums;

import java.io.Serializable;

/**
 * 枚举管理类
 *
 * @author qiusn 2019-11-22
 */
public interface IEnum<T extends Serializable> {

    /**
     * 枚举属性
     *
     * @return 获取枚举属性
     */
    EnumItem<T> item();

//    /**
//     * 根据枚举属性Key获取value
//     *
//     * @param key 枚举属性key
//     * @return 枚举属性value
//     */
//    String getValueByKey(int key);
//
//    /**
//     * 根据枚举属性value获取Key
//     *
//     * @param value 枚举属性value
//     * @return 枚举属性key
//     */
//    int getKeyByValue(String value);

}
