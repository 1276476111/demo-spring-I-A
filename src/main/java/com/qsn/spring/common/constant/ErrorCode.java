package com.qsn.spring.common.constant;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Arrays;

/**
 * @author qiusn
 * @version 1.0 2019/11/11 16:42
 */
@ToString
public class ErrorCode implements Serializable {

    private static final long serialVersionUID = -391640244715197083L;

    public static ErrorCode success() {
        return create(GlobalErrorCodes.SUCCESS.value());
    }

    public static ErrorCode create(ErrorCodeEnumItem errorCode) {
        return create(errorCode, new String[]{});
    }

    public static ErrorCode create(ErrorCodeEnumItem errorCode, String message) {
        return create(errorCode, message, null);
    }

    public static ErrorCode create(ErrorCodeEnumItem errorCode, Serializable[] args) {
        return create(errorCode, null, args);
    }

    public static ErrorCode create(ErrorCodeEnumItem errorCode, String message, Serializable[] args) {
        if (StringUtils.isBlank(message)) {
            message = errorCode.getMessage();
        }

        String code = errorCode.getCode();
        return create(code, message, args);
    }

    public static ErrorCode create(String code, String message) {
        return create(code, message, null);
    }

    public static ErrorCode create(String code, String message, Serializable[] args) {
        return new ErrorCode(code, message, args);
    }

    /**
     * 状态码
     */
    @Getter
    @Setter
    private String code;
    /**
     * 错误信息
     */
    @Setter
    private String message;
    /**
     * 参数
     */
    @Getter
    @Setter
    private Serializable[] args;

    public ErrorCode(String code, String message) {
        this(code, message, null);
    }

    public ErrorCode(String code, String message, Serializable[] args) {
        this.code = code;
        this.message = message;
        this.args = args;
    }

    public String getMessage() {
        if (StringUtils.isBlank(this.message)) {
            return null;
        }
        return MessageFormat.format(this.message, this.args == null || this.args.length == 0 ? null : Arrays.asList(this.args).toArray(new Object[this.args.length]));
    }
}