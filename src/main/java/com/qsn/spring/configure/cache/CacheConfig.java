package com.qsn.spring.configure.cache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.context.annotation.Configuration;

/**
 * 多级缓存jetCache配置
 *
 * @author qiusn
 * @version 1.0 2019/11/15 16:11
 * @EnableMethodCache 激活 @cached； basePackages：指定缓存包名
 * @EnableCreateCacheAnnotation 激活 @CreateCache；
 */
//@Configuration
@EnableMethodCache(basePackages = "com.qsn")
@EnableCreateCacheAnnotation
public class CacheConfig {
    /**
     * @Cached 使用缓存
     * @CacheRefresh 刷新缓存
     * @CachePenetrationProtect 在多线程环境中同步加载数据
     * @CacheRefresh 一个key的刷新任务，自该key首次被访问后初始化，如果该key长时间不被访问，
     *                  在stopRefreshAfterLastAccess指定的时间后，相关的刷新任务就会被自动移除，这样就避免了浪费资源去进行没有意义的刷新。
     *
     * （1）name：缓存的名称name，不是必须的，如果没有指定，会使用类名+方法名。
     *          name会被用于远程缓存的key前缀。另外在统计中，一个简短有意义的名字会提高可读性。
     * （2）key： 取缓存的key
     * （3）expire：缓存失效时间单位是秒，3600秒=1小时， 超时时间定义，注解上没有定义的时候会使用全局配置，
     *              如果此时全局配置也没有定义，则取无穷大。
     * （4）cacheType： LOCAL：内存缓存，只会存在内存中，并不会存储到redis中。
     *                 REMOTE：远程缓存。
     *                 BOTH：内存缓存+远程缓存。
     * （5）localLimit： 是需要控制缓存的个数的，缓存个数过多的话，很有可能就会内存溢出了
     *
     *
     */

//    @Cached(name="testUser-InfoCache-", key = "#id", expire = 3600 ,cacheType = CacheType.BOTH, cacheNullValue = true)
//    @CacheRefresh(refresh = 60, stopRefreshAfterLastAccess = 120, timeUnit = TimeUnit.SECONDS)
//    @CachePenetrationProtect
//    TestUser getById(Long id);


}
