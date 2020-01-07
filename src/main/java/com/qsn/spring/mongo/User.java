package com.qsn.spring.mongo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * mongoDB 实体
 * <p>
 * (1)@Document(collection="user") 没有表的概念， 注解中文名为文档， 存的时候直接按照该集合的名字存进去
 *
 * @author qiusn 2019-11-25
 */
@Document(collection = "user")
@Getter
@Setter
@ToString
public class User implements Serializable {

    private String userId;

    private String name;

    private String email;

    private Date birthday;

    private Integer age;

    private Integer dataStatus;

}