package ${package.Controller};


import org.springframework.web.bind.annotation.*;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#-- 经常更换：开始 -->
import  ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
<#-- 经常更换：结束 -->
import com.qsn.page.helper.common.base.PageForm;
import com.qsn.page.helper.common.base.PageData;
import com.qsn.page.helper.common.result.RestResult;
import com.qsn.page.helper.common.result.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import javax.annotation.Resource;
<#--import org.springframework.beans.factory.annotation.Autowired;-->

/**
 * ${table.comment!} 前端控制器
 *
 * @author ${author}
 * @since ${date}
 */
@Slf4j
@RestController
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
    <#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
    <#else>
public class ${table.controllerName} {
    </#if>

    @Resource
    private ${table.serviceName} ${table.serviceName?uncap_first};

    /**
     * 分页
     *
     * @param pageData 分页参数及查询条件
     * @return 集合
     * @author qiusn 2019-11-12
     */
    @PostMapping("page")
    public RestResult page(@RequestBody PageForm<${table.entityName}> pageData){
        PageData<${table.entityName}> page = ${table.serviceName?uncap_first}.page(pageData);
        return ResultGenerator.getSuccessResult(page);
    }


    /**
     * 列表
     *
     * @param search 查询条件
     * @return 集合
     * @author qiusn
     */
    @PostMapping("list")
    public RestResult list(@RequestBody ${table.entityName} search) {
        List<${table.entityName}> list = ${table.serviceName?uncap_first}.list(search);
        return ResultGenerator.getSuccessResult(list);
    }

    /**
     * 新增
     *
     * @param ${table.entityName?uncap_first} 新增信息
     * @return 成功或异常
     * @author qiusn
     */
    @PostMapping("insert")
    public RestResult insert(@RequestBody  ${table.entityName} ${table.entityName?uncap_first}) {
    ${table.serviceName?uncap_first}.insert(${table.entityName?uncap_first});
        return ResultGenerator.getSuccessResult();
    }

    /**
     * 修改
     *
     * @param ${table.entityName?uncap_first} 主键
     * @return 成功或异常
     * @author qiusn
     */
    @PostMapping("update")
    public RestResult update(@RequestBody  ${table.entityName} ${table.entityName?uncap_first}) {
    ${table.serviceName?uncap_first}.update(${table.entityName?uncap_first});
        return ResultGenerator.getSuccessResult();
    }

    /**
     * 删除
     *
     * @param ${table.entityName?uncap_first} 主键
     * @return 成功或异常
     * @author qiusn
     */
    @PostMapping("delete")
    public RestResult delete(@RequestBody  ${table.entityName} ${table.entityName?uncap_first}) {
    ${table.serviceName?uncap_first}.delete(${table.entityName?uncap_first}.getId());
        return ResultGenerator.getSuccessResult();
    }


}
</#if>