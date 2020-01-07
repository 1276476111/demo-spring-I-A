package ${package.Controller};


import org.springframework.web.bind.annotation.*;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import java.util.*;
import  ${package.Service}.${table.serviceName};
import  ${package.Entity}.${table.entityName};
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

import com.swan.common.web.data.Result;

/**
 * <p>
    * ${table.comment!} 前端控制器
    * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@Slf4j
@Api(value = "${table.comment!}CRUD接口")
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
    <#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
    <#else>
public class ${table.controllerName} {
    </#if>

    @Autowired
    private ${table.serviceName} ${table.name}Service;

    /**
     * 分页
     *
     * @param pageSearchDTO 查询条件
     * @return 集合
     * @author qiusn
     */
    @ApiOperation(value = "分页",notes="")
    @ApiImplicitParam(name = "pageSearchDTO", value = "分页参数（包含查询条件）", required = true, dataType = "PageForm
<${table.entityName}DTO>")
    @PostMapping("/page")
    public Result page(@RequestBody PageForm
    <${table.entityName}DTO> pageSearchDTO) {
        PageData
        <${table.entityName}DTO> pageData = ${table.name}Service.page(pageSearchDTO);
            return Result.success(pageData);
            }

            /**
            * 列表
            *
            * @param searchDTO 查询条件
            * @return 集合
            * @author qiusn
            */
            @ApiOperation(value = "列表", notes="")
            @ApiImplicitParam(name = "searchDTO", value = "查询条件", required = true, dataType = "List
            <${table.entityName}DTO>")
                @PostMapping("list")
                public Result list(@RequestBody PageForm
                <${table.name}DTO> searchDTO) {
                    List
                    <${table.entityName}DTO> list = ${table.name}Service.list(searchDTO);
                        return Result.success(list);
                        }

                        /**
                        * 新增
                        *
                        * @param ${table.name}DTO 新增信息
                        * @return 成功或异常
                        * @author qiusn
                        */
                        @ApiOperation(value = "添加${table.name}",notes="新增一条${table.name}信息")
                        @ApiImplicitParam(name = "${table.name}", value = "${table.name}信息", required = true, dataType =
                        "${table.entityName}DTO")
                        @PostMapping("insert")
                        public Result insert(@RequestBody  ${table.entityName}DTO ${table.name}DTO) {
                        ${table.name}Service.insert(${table.name}DTO);
                        return Result.success();
                        }

                        /**
                        * 修改
                        *
                        * @param ${table.name}DTO 主键
                        * @return 成功或异常
                        * @author qiusn
                        */
                        @ApiOperation(value = "修改${table.name}",notes="根据id修改${table.name}")
                        @ApiImplicitParam(name = "${table.name}", value = "${table.name}实体", required = true, dataType =
                        "${table.entityName}DTO")
                        @PostMapping("update")
                        public Result updateById(@RequestBody  ${table.entityName}DTO ${table.name}DTO) {
                        ${table.name}Service.updateById(${table.name}DTO);
                        return Result.success();
                        }

                        /**
                        * 删除
                        *
                        * @param ${table.name}DTO 主键
                        * @return 成功或异常
                        * @author qiusn
                        */
                        @ApiOperation(value = "删除${table.name}",notes="根据id删除${table.name}")
                        @ApiImplicitParam(name = "id", value = "${table.name}id", required = true, dataType =
                        "<#list table.fields as field><#if field.keyFlag == true>${field.columnType?lower_case?cap_first}</#if></#list>
                        ")
                        @PostMapping("delete")
                        public Result delete(@RequestBody  ${table.entityName}DTO ${table.name}DTO) {
                        ${table.name}Service.deleteById(${table.name}DTO.getById());
                        return Result.success();
                        }


                        }
</#if>