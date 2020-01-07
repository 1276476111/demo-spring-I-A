package ${package.Service};

import ${package.Entity}.${entity};
import com.qsn.page.helper.common.base.PageForm;
import com.qsn.page.helper.common.base.PageData;


import java.util.List;

/**
 * ${table.comment!} 服务类
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} {

    /**
     * 分页
     *
     * @param pageData 分页参数及查询条件
     * @return 集合
     * @author qiusn 2019-11-12
     */
    PageData<${table.entityName}> page(PageForm<${table.entityName}> pageData);

    /**
     * 列表
     *
     * @param search 查询条件
     * @return 集合
     * @author qiusn ${date}
     */
    List<${table.entityName}> list(${table.entityName} search);

    /**
     * 新增
     *
     * @param ${table.entityName?uncap_first} 新增信息
     * @return 成功或异常
     * @author qiusn ${date}
     */
    Boolean insert(${table.entityName} ${table.entityName?uncap_first});

    /**
     * 修改
     *
     * @param ${table.entityName?uncap_first} 主键、待修改信息
     * @return 成功或异常
     * @author qiusn ${date}
     */
    Boolean update(${table.entityName} ${table.entityName?uncap_first});

    /**
     * 删除
     *
     * @param id 主键
     * @return 成功或异常
     * @author qiusn ${date}
     */
    Boolean delete(Long id);

}
</#if>
