package com.qsn.spring.common.base;

import lombok.ToString;

import java.io.Serializable;

/**
 * 实体继承类
 *
 * @author qiusn
 * @version 1.0 2019/11/11 16:18
 * @JsonInclude 通常针对某一个属性或类， 全局通过jackson配置
 * NON_NULL：属性为NULL不序列化；
 * ALWAYS：默认； 如果返回的是实体， 会将所有为null的字段都序列化，即有什么都序列化出来
 * NON_DEFAULT：属性为默认值不序列化；
 * NON_EMPTY：属性为 空（””）或者为 NULL 都不序列化； 注：" "中间有个空格还是会被序列化
 * @ToString(callSuper = true) 输出更全的信息，包括父类的地址信息等
 */
@ToString(callSuper = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseDO implements Serializable {
    private static final long serialVersionUID = 7368919931060343020L;


}
