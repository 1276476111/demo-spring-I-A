package ${package.Service};

import ${package.Entity}.dto.${entity}DTO;
import com.swan.common.util.data.PageForm;
import com.swan.common.util.data.PageData;

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
     * @param searchDTO 查询条件
     * @return 集合
     * @author qiusn ${date}
     */
    PageData
<${table.entityName}DTO> page(PageForm
<${table.entityName}DTO> searchDTO);

    /**
     * 列表
     *
     * @param searchDTO 查询条件
     * @return 集合
     * @author qiusn ${date}
     */
    List
<${table.entityName}DTO> list(${table.entityName}DTO searchDTO);

    /**
     * 新增
     *
     * @param ${table.entityName?uncap_first}DTO 新增信息
     * @return 成功或异常
     * @author qiusn ${date}
     */
    Boolean insert(${table.entityName}DTO ${table.entityName?uncap_first}DTO);

    /**
     * 修改
     *
     * @param ${table.entityName?uncap_first}DTO 主键、待修改信息
     * @return 成功或异常
     * @author qiusn ${date}
     */
    Boolean update(${table.entityName}DTO ${table.entityName?uncap_first}DTO);

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
