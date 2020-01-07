package com.qsn.spring.generator.mapper;

import com.qsn.spring.generator.entity.WxUserCoupon;

import java.util.List;

/**
 * 用户卡券表 Mapper 接口
 *
 * @author qiusn 2019-11-20
 */
public interface WxUserCouponMapper {

    /**
     * 分页
     *
     * @param search 查询条件
     * @return 集合
     * @author qiusn 2019-11-20
     */
    List<WxUserCoupon> page(WxUserCoupon search);

    /**
     * 列表
     *
     * @param search 查询条件
     * @return 集合
     * @author qiusn 2019-11-20
     */
    List<WxUserCoupon> list(WxUserCoupon search);

    /**
     * 新增
     *
     * @param wxUserCoupon 新增信息
     * @return 影响记录行数
     * @author qiusn 2019-11-20
     */
    int insert(WxUserCoupon wxUserCoupon);

    /**
     * 修改
     *
     * @param wxUserCoupon 主键、待修改信息
     * @return 影响记录行数
     * @author qiusn 2019-11-20
     */
    int update(WxUserCoupon wxUserCoupon);

    /**
     * 删除
     *
     * @param id 主键
     * @return 影响记录行数
     * @author qiusn 2019-11-20
     */
    int delete(Long id);

}
