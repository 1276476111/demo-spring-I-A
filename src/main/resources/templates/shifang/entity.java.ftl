package ${package.Entity};

import com.swan.common.util.data.BaseDO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;
<#assign myDateType = ["LocalDateTime"]/>

/**
 * ${table.comment}
 *
 * @author ${author} ${date}
 */
<#if entityLombokModel>
@Getter
@Setter
@ToString
</#if>
<#if superEntityClass??>
public class ${entity} implements ${superEntityClass}<#if activeRecord><${entity}></#if> {
<#elseif activeRecord>
public class ${entity} extends Model<${entity}> {
<#else>
public class ${entity} extends BaseDO {
</#if>

    private static final long serialVersionUID = 1L;
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#if field.keyFlag>
        <#assign keyPropertyName="${field.propertyName}"/>
    </#if>

    <#if field.comment!?length gt 0>
    /**
     * ${field.comment}
     */
    </#if>
    <#if myDateType?seq_contains(field.propertyType)>
    private Date ${field.propertyName};
    <#else>
    private ${field.propertyType} ${field.propertyName};
    </#if>
</#list>
<#------------  END 字段循环遍历  ---------->

}