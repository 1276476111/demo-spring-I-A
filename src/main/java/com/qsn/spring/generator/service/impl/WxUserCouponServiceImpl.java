package com.qsn.spring.generator.service.impl;

import com.github.pagehelper.PageHelper;
import com.qsn.spring.common.base.PageData;
import com.qsn.spring.common.base.PageForm;
import com.qsn.spring.generator.entity.WxUserCoupon;
import com.qsn.spring.generator.mapper.WxUserCouponMapper;
import com.qsn.spring.generator.service.WxUserCouponService;
import com.qsn.spring.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 用户卡券表 服务实现类
 *
 * @author qiusn
 * @since 2019-11-20
 */
@Slf4j
@Service
public class WxUserCouponServiceImpl implements WxUserCouponService {
    @Resource
    private WxUserCouponMapper wxUserCouponMapper;


    /**
     * 分页
     *
     * @param pageData 分页参数及查询条件
     * @return 集合
     * @author qiusn 2019-11-12
     */
    @Override
    public PageData<WxUserCoupon> page(PageForm<WxUserCoupon> pageData) {
        PageHelper.startPage(pageData.getCurrentPage(), pageData.getPageSize());
        List<WxUserCoupon> wxUserCoupons = wxUserCouponMapper.page(pageData.getData());
        return PageUtil.setPageInfo(wxUserCoupons);
    }


    /**
     * 列表
     *
     * @param search 查询条件
     * @return 集合
     * @author qiusn 2019-11-20
     */
    @Override
    public List<WxUserCoupon> list(WxUserCoupon search) {
        return wxUserCouponMapper.list(search);
    }

    /**
     * 新增
     *
     * @param wxUserCoupon 新增信息
     * @return 成功或异常
     * @author qiusn 2019-11-20
     */
    @Override
    public Boolean insert(WxUserCoupon wxUserCoupon) {
        int insertNum = wxUserCouponMapper.insert(wxUserCoupon);
        if (insertNum == 1) {
            log.debug("新增成功");
        }

        return true;
    }

    /**
     * 修改
     *
     * @param wxUserCoupon 主键、待修改信息
     * @return 成功或异常
     * @author qiusn 2019-11-20
     */
    @Override
    public Boolean update(WxUserCoupon wxUserCoupon) {
        int updateNum = wxUserCouponMapper.update(wxUserCoupon);
        if (updateNum == 1) {
            log.debug("修改成功");
        }
        return true;
    }

    /**
     * 删除
     *
     * @param id 主键
     * @return 成功或异常
     * @author qiusn 2019-11-20
     */
    @Override
    public Boolean delete(Long id) {
        int delNum = wxUserCouponMapper.delete(id);
        if (delNum == 1) {
            log.debug("删除成功");
        }
        return true;
    }

}
