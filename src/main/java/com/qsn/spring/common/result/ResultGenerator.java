package com.qsn.spring.common.result;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

/**
 * 工厂模式
 * 接口信息生成工具
 *
 * @author qiusn
 * @version 1.0 2019/11/12 11:18
 */
@Component
public class ResultGenerator extends RestResult {

    private static final String SUCCESS = "success";
    RestResult restResult = new RestResult();

    /**
     * 成功
     */
    public static RestResult getSuccessResult() {
        return new RestResult()
                .setCode(ResultCode.SUCCESS)
                .setMessage(SUCCESS);
    }

    /**
     * 成功，附带额外数据
     */
    public static RestResult getSuccessResult(Object data) {
        return new RestResult()
                .setCode(ResultCode.SUCCESS)
                .setMessage(SUCCESS)
                .setData(JSONObject.toJSON(data));
    }

    /**
     * 成功，自定义消息及数据
     */
    public static RestResult getSuccessResult(String message, Object data) {
        return new RestResult()
                .setCode(ResultCode.SUCCESS)
                .setMessage(message)
                .setData(data);
    }

    /**
     * 失败，附带消息
     */
    public static RestResult getFailResult(String message) {
        return new RestResult()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }

    /**
     * 失败，自定义消息及数据
     */
    public static RestResult getFailResult(String message, Object data) {
        return new RestResult()
                .setCode(ResultCode.FAIL)
                .setMessage(message)
                .setData(data);
    }

    /**
     * 自定义创建
     */
    public static RestResult getFreeResult(ResultCode code, String message, Object data) {
        return new RestResult()
                .setCode(code)
                .setMessage(message)
                .setData(data);
    }
}