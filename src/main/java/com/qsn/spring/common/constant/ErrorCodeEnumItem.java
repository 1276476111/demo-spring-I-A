package com.qsn.spring.common.constant;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author qiusn
 * @version 1.0 2019/11/11 16:41
 */
@Getter
public class ErrorCodeEnumItem implements Serializable {

    private static final long serialVersionUID = -2044758648999238563L;

    private final String code;
    private final String message;

    public ErrorCodeEnumItem(final String code, final String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorCode toErrorCode(Serializable... args) {
        return ErrorCode.create(this, args);
    }

    public boolean eq(String code) {
        return this.getCode().equals(code);
    }
}
