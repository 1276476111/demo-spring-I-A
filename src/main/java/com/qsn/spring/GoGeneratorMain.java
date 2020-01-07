package com.qsn.spring;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 代码生成器
 *
 * @author qiusn
 * @version 1.0 2019/10/16 15:01
 */
public class GoGeneratorMain {

    /**
     * 表名字，可用“,”隔开; 这里注意逗号后面不能有空格
     */
    public static final String tableName = "wx_user_coupon,test_user";

    /**
     * 数据源
     */
    public static final String dbUrl = "jdbc:mysql://127.0.0.1:3306/my_test?useUnicode=true&autoReconnect=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=GMT%2B8";
    public static final String dbUserName = "root";
    public static final String dbPassword = "root";

    /**
     * 包配置路径
     */
    public static final String packagePath = "com.qsn.spring.generator";

    /**
     * 项目路径  当前项目(固定的：可获取当前项目绝对路径， 后可利用拼接 javaPath)
     */
    public static final String projectPath = System.getProperty("user.dir");

    /**
     * 输出路径
     */
    public static final String javaPath = "/src/main/java";

    /**
     * 自定义模板模式（自己用的模板、公司用的模板、Swagger用的模板）
     */
    public static final String deployMyTemPath = "myself";
    public static final String deployOrdinaryTemPath = "shifang";
    public static final String deploySwaggerTemPath = "swagger";

    /**
     * 被选择的自定义模板模式（统一管理模板模式）
     */
    public static final String deployTemPathThisIt = deployMyTemPath;

    /**
     * 自定义模板路径（没有特殊需求，不需要改）
     */
    public static final String entityTemplatePath = String.format("/templates/%s/entity.java", deployTemPathThisIt);
    public static final String mapperTemplatePath = String.format("/templates/%s/mapper.java", deployTemPathThisIt);
    public static final String mapperXmlTemplatePath = String.format("/templates/%s/mapper.xml.ftl", deployTemPathThisIt);
    public static final String serviceTemplatePath = String.format("/templates/%s/service.java", deployTemPathThisIt);
    public static final String serviceImplTemplatePath = String.format("/templates/%s/serviceImpl.java", deployTemPathThisIt);
    public static final String controllerTemplatePath = String.format("/templates/%s/controller.java", deployTemPathThisIt);


    public static void main(String[] args) {
        System.err.println("------------------- 您确定要生成表名“ " + tableName + " ”代码吗？ -------------------?");
        System.out.println("请输入 yes/no ?");

        Scanner scanner = new Scanner(System.in);
        String scannerStatus = scanner.next();
        // 确认通过密匙
        String scannerGoMain = "yes";
        if (!scannerGoMain.equals(scannerStatus)) {
            System.err.println("代码生成失败： 您并没有确认此操作");
            return;
        }

        AutoGenerator generator = new AutoGenerator();

        // 全局变量配置
        generator.setGlobalConfig(allConstant());

        // 数据源配置
        generator.setDataSource(setDataSource());

        // 包配置
        generator.setPackageInfo(setPackage());

        // 自定义配置
        generator.setCfg(setFileOutConfigList());

        // 配置模板
        generator.setTemplate(setTemplateConfig());

        // 表相关配置
        generator.setStrategy(setTable());

        // 模板引擎
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        generator.execute();
    }

    /**
     * 全局变量配置
     */
    private static GlobalConfig allConstant() {
        GlobalConfig gc = new GlobalConfig();
        // 输出路径
        gc.setOutputDir(projectPath + javaPath);
        // 是否覆盖已生成文件
        gc.setFileOverride(true);
        // 默认true ,是否打开输出目录
        gc.setOpen(false);

        // 默认false,是否开启二级缓存
        gc.setEnableCache(false);
        // 作者
        gc.setAuthor("qiusn");
        // 默认false
        gc.setSwagger2(false);
        // xml 的resultMap
        gc.setBaseResultMap(true);
        // 时间策略 默认TIME_PACK
        gc.setDateType(DateType.TIME_PACK);
        //默认false  和basemodel相似
        gc.setBaseColumnList(true);
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setEntityName("%s");
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        // 指定生成的主键类型
//        gc.setIdType(IdType.ID_WORKER_STR);
        return gc;
    }

    /**
     * 数据源配置
     */
    private static DataSourceConfig setDataSource() {
        // 数据源配置
        DataSourceConfig dc = new DataSourceConfig();
        // 数据库信息查询 //默认mysql
        dc.setDbQuery(new MySqlQuery());
        // 数据库类型
        dc.setDbType(DbType.MYSQL);
        //类型转换 默认mysql
        dc.setTypeConvert(new MySqlTypeConvert());
        dc.setUrl(dbUrl);
        dc.setDriverName("com.mysql.cj.jdbc.Driver");
        dc.setUsername(dbUserName);
        dc.setPassword(dbPassword);
        return dc;
    }

    /**
     * 包名及路径配置
     */
    private static PackageConfig setPackage() {
        PackageConfig pc = new PackageConfig();
        pc.setParent(packagePath);
//        pc.setModuleName(""); //此处是所属模块名称
//        pc.setEntity("entity"); //默认entity,controller,service,service.impl,mapper,mapper.xml
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        return pc;
    }

    /**
     * 自定义配置
     */
    private static InjectionConfig setFileOutConfigList() {
        PackageConfig pc = new PackageConfig();
        pc.setParent(packagePath);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing

            }
        };
        /**
         * 将xml生成到resource下面、
         */
        // framemark
        String templatePath = mapperXmlTemplatePath;
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/"
//                        + pc.getModuleName() + "/"  这里按模块名称区分xml中的模块，暂不需要
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                // getEntityName() xml的文件名是下滑线
                // getName() xml的文件名是大小写的命名
            }
        });
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    /**
     * 自定义模板配置
     */
    private static TemplateConfig setTemplateConfig() {
        TemplateConfig tc = new TemplateConfig();
        tc.setController(controllerTemplatePath);
        tc.setEntity(entityTemplatePath);
        tc.setEntityKt(entityTemplatePath);
        tc.setMapper(mapperTemplatePath);
        tc.setService(serviceTemplatePath);
        tc.setServiceImpl(serviceImplTemplatePath);
        // 清除mapper的xml文件夹， xml文件夹在上面的方法自定义放到resources下的mapper文件夹中
        tc.setXml("");
        return tc;
    }

    /**
     * model 的 注解与驼峰配置, base的类名
     */
    private static StrategyConfig setTable() {
        StrategyConfig sc = new StrategyConfig();
        //是否跳过试图 默认false
        sc.setSkipView(true);
        //是否大写命名 默认false
        sc.setCapitalMode(false);
        // 表映射 驼峰命名
        sc.setNaming(NamingStrategy.underline_to_camel);
        // 字段映射 驼峰
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        sc.setEntityLombokModel(true);
        sc.setRestControllerStyle(true);
        sc.setEntitySerialVersionUID(false);
        sc.setEntityColumnConstant(false);
        // @TableField 注释开关
        sc.setEntityTableFieldAnnotationEnable(false);
        // 驼峰转连字符 默认false
        sc.setControllerMappingHyphenStyle(true);


        // 设置 base 名字， 默认
//        sc.setSuperMapperClass("");
//        sc.setSuperServiceClass("");
//        sc.setSuperServiceImplClass("");
//        sc.setSuperControllerClass("ASS");

        // 表名，用，隔开  需要生产
        sc.setInclude(tableName.split(","));
        // 不需要生成  二选一
//     sc.setExclude("");
        // 逻辑删除字段名称 (@TableLogic注解是否加在类上)
//        sc.setLogicDeleteFieldName("status");

        return sc;
    }

}
