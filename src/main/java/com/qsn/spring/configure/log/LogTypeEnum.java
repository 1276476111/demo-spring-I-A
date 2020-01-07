package com.qsn.spring.configure.log;

/**
 * 日志类型枚举类
 *
 * @author qiusn 2019-11-22
 */
public enum LogTypeEnum {

    WEB("-1"), DUBBO("1"), MQ("2");

    private final String value;

    LogTypeEnum(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

}