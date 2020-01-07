package com.qsn.spring.common.constant;

/**
 * @author qiusn
 * @version 1.0 2019/11/11 17:30
 */

/**
 * 统一异常接口
 *
 * @author vincent
 * @version 1.0 2019-06-16 12:37
 */
public interface BizError {

    /**
     * 获取错误码信息
     *
     * @return 错误码
     */
    ErrorCode getErrorCode();
}
