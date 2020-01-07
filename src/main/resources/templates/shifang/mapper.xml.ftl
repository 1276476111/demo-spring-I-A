<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}">

<#if enableCache>
    <!-- 开启二级缓存 -->
    <cache type="org.mybatis.caches.ehcache.LoggingEhcache"/>
</#if>
<#if baseResultMap>
    <!-- 通用查询映射结果 -->
    <resultMap id="BaseResultMap" type="${package.Entity}.${entity}">
        <#list table.fields as field>
            <#if field.keyFlag><#--生成主键排在第一位-->
        <id column="${field.name}" property="${field.propertyName}" jdbcType="${field.type}"/>
            </#if>
        </#list>
<#list table.commonFields as field><#--生成公共字段 -->
    <result column="${field.name}" property="${field.propertyName}"/>
</#list>
<#list table.fields as field>
    <#if !field.keyFlag><#--生成普通字段 -->
        <result column="${field.name}" property="${field.propertyName}"/>
    </#if>
</#list>
    </resultMap>
</#if>

<#if baseColumnList>
    <sql id="BaseColumnList">
        ${table.fieldNames}
    </sql>

    <!-- 分页 -->
    <select id="page" resultMap="BaseResultMap">
        <![CDATA[
        SELECT ${table.fieldNames}
        FROM ${table.name}
        ]]>
    </select>

    <!-- 集合 -->
    <select id="list" resultMap="BaseResultMap">
        <![CDATA[
        SELECT ${table.fieldNames}
        FROM ${table.name}
        ]]>
    </select>

    <!-- 新增 -->
    <insert id="insert" useGeneratedKeys="true" keyProperty="id" keyColumn="id">
        INSERT INTO ${table.name}
        <trim prefix="(" suffix=")" suffixOverrides=",">
        <#list table.fields as field>
            <#if !field.keyFlag><#--生成普通字段 -->
                ${field.name},
            </#if>
        </#list>
        </trim>
        <trim prefix=" VALUES (" suffix=")" suffixOverrides=",">
        <#list table.fields as field>
            <#if !field.keyFlag><#--生成普通字段 -->
                ${"#"}${"{"}${field.propertyName}${"}"},
            </#if>
        </#list>
        </trim>
    </insert>

    <!-- 修改 -->
    <update id="update" useGeneratedKeys="true" keyProperty="id" keyColumn="id">
        UPDATE ${table.name} SET
        <trim suffixOverrides=",">
        <#list table.fields as field>
            <#if !field.keyFlag><#--生成普通字段 -->
                ${field.name}=${"#"}${"{"}${field.propertyName}${"}"},
            </#if>
        </#list>
        </trim>
        <![CDATA[
        WHERE id=${"#"}${"{"}id${"}"}
        ]]>
    </update>

    <!-- 删除 -->
    <delete id="delete">
        <![CDATA[
        DELETE FROM ${table.name}
        WHERE id=${"#"}${"{"}id${"}"}
        ]]>
    </delete>

</#if>

</mapper>