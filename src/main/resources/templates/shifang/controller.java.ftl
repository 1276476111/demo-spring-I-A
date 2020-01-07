package ${package.Controller};


import org.springframework.web.bind.annotation.*;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
import  ${package.Service}.${table.serviceName};
import  ${package.Entity}.dto.${table.entityName}DTO;
import com.qsn.page.helper.other.result;

import lombok.extern.slf4j.Slf4j;
import com.swan.common.util.data.*;
import com.swan.common.web.data.Result;
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
     * @param pageSearchDTO 查询条件
     * @return 集合
     * @author qiusn
     */
    @PostMapping("/page")
    public Result page(@RequestBody PageForm
<${table.entityName}DTO> pageSearchDTO) {
    PageData
    <${table.entityName}DTO> pageData = ${table.serviceName?uncap_first}.page(pageSearchDTO);
        return Result.success(pageData);
        }

        /**
        * 列表
        *
        * @param searchDTO 查询条件
        * @return 集合
        * @author qiusn
        */
        @PostMapping("list")
        public Result list(@RequestBody ${table.entityName}DTO searchDTO) {
        List
        <${table.entityName}DTO> list = ${table.serviceName?uncap_first}.list(searchDTO);
            return Result.success(list);
            }

            /**
            * 新增
            *
            * @param ${table.entityName?uncap_first}DTO 新增信息
            * @return 成功或异常
            * @author qiusn
            */
            @PostMapping("insert")
            public Result insert(@RequestBody  ${table.entityName}DTO ${table.entityName?uncap_first}DTO) {
            ${table.serviceName?uncap_first}.insert(${table.entityName?uncap_first}DTO);
            return Result.success();
            }

            /**
            * 修改
            *
            * @param ${table.entityName?uncap_first}DTO 主键
            * @return 成功或异常
            * @author qiusn
            */
            @PostMapping("update")
            public Result update(@RequestBody  ${table.entityName}DTO ${table.entityName?uncap_first}DTO) {
            ${table.serviceName?uncap_first}.update(${table.entityName?uncap_first}DTO);
            return Result.success();
            }

            /**
            * 删除
            *
            * @param ${table.entityName?uncap_first}DTO 主键
            * @return 成功或异常
            * @author qiusn
            */
            @PostMapping("delete")
            public Result delete(@RequestBody  ${table.entityName}DTO ${table.entityName?uncap_first}DTO) {
            ${table.serviceName?uncap_first}.delete(${table.entityName?uncap_first}DTO.getId());
            return Result.success();
            }


            }
</#if>