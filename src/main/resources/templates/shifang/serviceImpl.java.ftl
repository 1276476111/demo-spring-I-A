package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Entity}.dto.${entity}DTO;
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import org.springframework.stereotype.Service;
import com.swan.common.db.page.PageHelperUtils;
import com.swan.common.util.exception.BusinessException;
import com.swan.common.util.exception.code.GlobalErrorCodes;
import com.swan.common.util.convert.BeanConvert;


import com.swan.common.util.data.PageForm;
import com.swan.common.util.data.PageData;
import javax.annotation.Resource;
<#--import org.springframework.beans.factory.annotation.Autowired;-->

import java.util.List;


/**
 * ${table.comment!} 服务实现类
 *
 * @author ${author}
 * @since ${date}
 */
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
     * @param searchDTO 查询条件
     * @return 集合
     * @author qiusn ${date}
     */
    @Override
    public PageData
<${table.entityName}DTO> page(PageForm
<${table.entityName}DTO> searchDTO){
    ${entity} search = PageHelperUtils.pageQueryCondition(searchDTO, ${entity}.class);
        List<${entity}> pages = ${table.mapperName?uncap_first}.page(search);
        return PageHelperUtils.toPageData(pages, ${entity}DTO.class);
    }

    /**
     * 列表
     *
     * @param searchDTO 查询条件
     * @return 集合
     * @author qiusn ${date}
     */
    @Override
    public List
<${table.entityName}DTO> list(${table.entityName}DTO searchDTO){
    ${table.entityName} search = BeanConvert.copyProperties(searchDTO, ${table.entityName}.class);
        List<${table.entityName}> list = ${table.mapperName?uncap_first}.list(search);
        return BeanConvert.copyListProperties(list, ${table.entityName}DTO.class);
    }

    /**
     * 新增
     *
     * @param ${table.entityName?uncap_first}DTO 新增信息
     * @return 成功或异常
     * @author qiusn ${date}
     */
    @Override
    public Boolean insert(${table.entityName}DTO ${table.entityName?uncap_first}DTO){
    ${table.entityName} ${table.entityName?uncap_first} = BeanConvert.copyProperties(${table.entityName?uncap_first}
    DTO, ${table.entityName}.class);
        Integer insertNum = ${table.mapperName?uncap_first}.insert(${table.entityName?uncap_first});
        if (!insertNum.equals(1)) {
            throw new BusinessException(GlobalErrorCodes.SYSTEM_ERROR.value().toErrorCode());
        }
        return true;
    }

    /**
     * 修改
     *
     * @param ${table.entityName?uncap_first}DTO 主键、待修改信息
     * @return 成功或异常
     * @author qiusn ${date}
     */
    @Override
    public Boolean update(${table.entityName}DTO ${table.entityName?uncap_first}DTO){
    ${table.entityName} ${table.entityName?uncap_first} = BeanConvert.copyProperties(${table.entityName?uncap_first}
    DTO, ${table.entityName}.class);
        Integer updateNum = ${table.mapperName?uncap_first}.update(${table.entityName?uncap_first});
        if (!updateNum.equals(1)) {
            throw new BusinessException(GlobalErrorCodes.SYSTEM_ERROR.value().toErrorCode());
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
        Integer delNum = ${table.mapperName?uncap_first}.delete(id);
        if (!delNum.equals(1)) {
            throw new BusinessException(GlobalErrorCodes.SYSTEM_ERROR.value().toErrorCode());
        }
        return true;
    }

}
</#if>
