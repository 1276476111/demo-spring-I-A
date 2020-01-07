package com.qsn.spring.generator.entity;

import com.qsn.spring.common.base.BaseDO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 用户卡券表
 *
 * @author qiusn 2019-11-20
 */
@Getter
@Setter
@ToString
public class WxUserCoupon extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 批次号, 对应劵批次表id
     */
    private String stockId;

    /**
     * 小程序或公众appid
     */
    private String appid;

    /**
     * 微信用户编号
     */
    private String openId;

    /**
     * 微信用户昵称
     */
    private String wxNickName;

    /**
     * 用户的代金券id
     */
    private String couponId;

    /**
     * 代金券名称
     */
    private String couponName;

    /**
     * 是否是单品（1是，0不是(即为全场券)）
     */
    private Integer isSingleitem;

    /**
     * 券类型（NORMAL-满减券(单品立减)；CUT_TO-减至券((单品换购))）
     */
    private String couponType;

    /**
     * 领取方式(1扫码领券 2小程序）
     */
    private Integer createType;

    /**
     * 核销订单号
     */
    private String transactionId;

    /**
     * 批次创建方商户号
     */
    private String stockCreatorMchid;

    /**
     * 核销代金券的商户号
     */
    private String consumeMchid;

    /**
     * 面额 单位:分
     */
    private Integer couponAmount;

    /**
     * 代金券状态(SENDED-可用，USED-已实扣，EXPIRED-已过期 )
     */
    private String status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 核销时间
     */
    private Date consumeTime;

    /**
     * 活动编号
     */
    private Long activityId;

    /**
     * 威富通商户号
     */
    private String wftMchId;

    /**
     * 订单金额
     */
    private Integer totalFee;

    /**
     * 支付同步标识（0：未同步；1：已同步）
     */
    private Integer paySyn;

    /**
     * 同步时间
     */
    private Date synTime;

}