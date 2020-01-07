package com.qsn.spring.mongo;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.qsn.spring.mongo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * mongoDB 测试接口
 *
 * @author qiusn 2019-11-25
 */
@RestController
@RequestMapping("/testMongoC2")
public class MongoController {

    @Autowired
    MongoTemplate mongotemplate;

    /**
     * 获取某个类所有数据
     *
     * @return 所有数据
     * @author qiusn 2019-11-25
     */
    @PostMapping("list")
    private List<User> list() {
        return mongotemplate.findAll(User.class);
    }

    /**
     * 新增mongodb数据
     *
     * @param user 新增数据
     * @return 新增的数据
     * @author qiusn 2019-11-25
     */
    @PostMapping("insert")
    private User insert(@RequestBody User user) {
        return mongotemplate.insert(user);
    }

    /**
     * 修改mongodb数据
     * <p>
     * 修改一定要注意： 如果没有修改条件， 数据库中所有的数据都会被修改，什么都不传那么程序里面设置的字段值就都默认设置成默认值
     *
     * @param user 修改数据
     * @return matchedCount匹配数、modifiedCount修改数、
     * @author qiusn 2019-11-25
     */
    @PostMapping("update")
    private UpdateResult update(@RequestBody User user) {
        // 设置修改条件
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.and("userId").is(user.getUserId());
        query.addCriteria(criteria);

        // 组装修改数据
        Update update = new Update();
        update.set("name", user.getName());

        // 执行修改
        return mongotemplate.updateMulti(query, update, User.class);
    }

    /**
     * 删除 mongo 数据
     * <p>
     * 删除这里也要注意， 如果什么都没传（包括查询条件）， 那就都以默认值进行删除（此例子中即 userId=null 的全被删除）
     *
     * @param user 删除条件
     * @return 删除的条数
     * @author qiusn 2019-11-25
     */
    @PostMapping("delete")
    private DeleteResult delete(@RequestBody User user) {
        // 设置删除条件
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.and("userId").is(user.getUserId());
        query.addCriteria(criteria);
        // 执行删除
        return mongotemplate.remove(query, User.class);
    }

    /**
     * 大于：gt
     * criteria.and("查询字段名（驼峰形式）").gt(查询字段值)
     * 小于：lt
     * criteria.and("查询字段名（驼峰形式）").lt(查询字段值)
     * 大于等于：gte
     * criteria.and("查询字段名（驼峰形式）").gte(查询字段值)
     * 小于等于：lte
     * criteria.and("查询字段名（驼峰形式）").lte(查询字段值)
     * 非空查询 ne(不等于)
     * criteria.where("查询字段名（驼峰形式）").ne(查询字段值)
     *
     * @param user 查询条件
     * @return
     */
    @PostMapping("info")
    private List<User> info(@RequestBody User user) {
        // 查询条件
        // 这里组装的查询条件必须同时满足， 如果只传了其中一个， 那么另一个就会按未null处理并查询；
        // 所以这里的查询条件是并且的关系；而不是为null该字段值就不查的关系

        Criteria criteria = new Criteria();
        criteria.and("userId").ne(user.getUserId());

        // 组装查询入参
        Query query = new Query();
        query.addCriteria(criteria);

        // 查询所有
        return mongotemplate.findAll(User.class);

//        // 查询单条
//        return mongotemplate.findOne(query, User.class);

//        // 查询符合条件的部分查询 自测通过
//        return  mongotemplate.find(query, User.class);

    }


}
