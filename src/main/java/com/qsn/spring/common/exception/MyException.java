package com.qsn.spring.common.exception;

import com.qsn.spring.common.constant.ErrorCode;
import com.qsn.spring.common.constant.GlobalErrorCodes;

/**
 * 自定义异常
 *
 * @author qiusn
 * @version 1.0 2019/11/13 14:21
 */
public class MyException extends RuntimeException {

    private static final long serialVersionUID = 1156317337093837664L;

    /**
     * 错误信息
     */
    private ErrorCode errorCode;

    public MyException() {
        this.errorCode = GlobalErrorCodes.SYSTEM_ERROR.value().toErrorCode();
    }

    public MyException(ErrorCode error) {
        super(error.getMessage());
        this.errorCode = error;
        this.errorCode.setCode(this.errorCode.getCode());
    }


}
