package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import com.qsn.page.helper.common.base.PageForm;
import com.qsn.page.helper.common.base.PageData;
import com.github.pagehelper.PageHelper;

import com.qsn.page.helper.util.PageUtil;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
<#--import com.qsn.pager.helper.config.util.BeanConvertUtils;-->
import javax.annotation.Resource;
<#--import org.springframework.beans.factory.annotation.Autowired;-->

import java.util.List;


/**
 * ${table.comment!} 服务实现类
 *
 * @author ${author}
 * @since ${date}
 */
@Slf4j
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} implements ${table.serviceName} {
    @Resource
    private  ${table.mapperName} ${table.mapperName?uncap_first};


    /**
     * 分页
     *
     * @param pageData 分页参数及查询条件
     * @return 集合
     * @author qiusn 2019-11-12
     */
    @Override
    public PageData<${table.entityName}> page(PageForm<${table.entityName}> pageData) {
        PageHelper.startPage(pageData.getCurrentPage(), pageData.getPageSize());
        List<${table.entityName}> ${table.entityName?uncap_first}s = ${table.mapperName?uncap_first}.page(pageData.getData());
        return PageUtil.setPageInfo(${table.entityName?uncap_first}s);
    }


    /**
     * 列表
     *
     * @param search 查询条件
     * @return 集合
     * @author qiusn ${date}
     */
    @Override
    public List<${table.entityName}> list(${table.entityName} search){
        return ${table.mapperName?uncap_first}.list(search);
    }

    /**
     * 新增
     *
     * @param ${table.entityName?uncap_first} 新增信息
     * @return 成功或异常
     * @author qiusn ${date}
     */
    @Override
    public Boolean insert(${table.entityName} ${table.entityName?uncap_first}){
        int insertNum = ${table.mapperName?uncap_first}.insert(${table.entityName?uncap_first});
        if (insertNum == 1) {
            log.debug("新增成功");
        }

        return true;
    }

    /**
     * 修改
     *
     * @param ${table.entityName?uncap_first} 主键、待修改信息
     * @return 成功或异常
     * @author qiusn ${date}
     */
    @Override
    public Boolean update(${table.entityName} ${table.entityName?uncap_first}){
        int updateNum = ${table.mapperName?uncap_first}.update(${table.entityName?uncap_first});
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
     * @author qiusn ${date}
     */
    @Override
    public Boolean delete(Long id){
        int delNum = ${table.mapperName?uncap_first}.delete(id);
        if (delNum == 1) {
            log.debug("删除成功");
        }
        return true;
    }

}
</#if>
