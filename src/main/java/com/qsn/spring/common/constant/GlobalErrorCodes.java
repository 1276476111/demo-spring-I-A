package com.qsn.spring.common.constant;

/**
 * @author qiusn
 * @version 1.0 2019/11/11 16:41
 */
public enum GlobalErrorCodes implements ErrorCodeEnum {

    // 成功码
    SUCCESS("0", "success"),
    SYSTEM_ERROR("0001", "system error"),
    UNKOWN("0002", "unkown error"),

    INVALID_REDIRECT_URL("0010", "invalid redirect url"),
    REQUEST_DATA_ERROR("0011", "request data error"),
    DATA_SIGN_FAIL("0012", "sign check fail"),
    DATA_DECRYPT_FAIL("0013", "decrypt data fail"),
    DATA_ENCRYPT_FAIL("0014", "encrypt data fail"),
    UNSUPPORT_ENCRYPT_METHOD("0015", "unsupport encrypt method"),

    NOT_LOGIN("0020", "not login"),
    FILE_UPLOAD_LIMIT_SIZE("0021", "file size too large"),
    PARAMS_ERROR("0022", "params error"),
    PERMISSION_DENY("0023", "permission deny"),

    REQUIRE_POST("0030", "Require POST method"),
    SERVICE_NOT_FOUND("0031", "service not found"),
    SERVICE_UNAUTHORIZED("0032", "service unauthorized"),
    REQUEST_IP_UNAUTHORIZED("0033", "request ip unauthorized"),
    REQUEST_OUT_TIME("0034", "request timestamp is out of time"),
    REQUEST_ERROR("0035", "request error"),
    RESPONSE_DATA_NULL("0036", "response data null"),;

    private final ErrorCodeEnumItem value;

    GlobalErrorCodes(final String code, final String message) {
        this.value = new ErrorCodeEnumItem(code, message);
    }

    @Override
    public ErrorCodeEnumItem value() {
        return this.value;
    }
}
