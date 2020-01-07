package ${package.Mapper};

import ${package.Entity}.${entity};
import java.util.List;

/**
 * ${table.comment!} Mapper 接口
 *
 * @author ${author} ${date}
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} {

    /**
     * 分页
     *
     * @param search 查询条件
     * @return 集合
     * @author qiusn ${date}
     */
    List<${table.entityName}> page(${table.entityName} search);

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
     * @return 影响记录行数
     * @author qiusn ${date}
     */
    Integer insert(${table.entityName} ${table.entityName?uncap_first});

    /**
     * 修改
     *
     * @param ${table.entityName?uncap_first} 主键、待修改信息
     * @return 影响记录行数
     * @author qiusn ${date}
     */
    Integer update(${table.entityName} ${table.entityName?uncap_first});

    /**
     * 删除
     *
     * @param id 主键
     * @return 影响记录行数
     * @author qiusn ${date}
     */
    Integer delete(Long id);

}
</#if>
