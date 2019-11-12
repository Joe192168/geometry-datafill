package com.geometry.rest;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //当前工程路径
        final String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");//生成文件的输出目录【默认 D 盘根目录】
        gc.setAuthor(scanner("作者："));//开发人员
        gc.setOpen(false);//是否打开输出目录
        gc.setFileOverride(false);// 是否覆盖已有同名文件，默认是false
        gc.setActiveRecord(true);// 开启 ActiveRecord 模式，默认是false
        gc.setEnableCache(false);// 是否在xml中添加二级缓存配置，默认是false
        gc.setBaseResultMap(true);// 开启 BaseResultMap，默认是false
        gc.setBaseColumnList(true);// 开启 baseColumnList，默认是false
        /*
         * 各层文件名称方式，例如： %sAction 生成 UserAction
         * %s 为占位符，注意 %s 会自动填充表实体属性！
         */
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=utf-8");
        //dsc.setSchemaName("public");//PostgreSQL schemaName
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 包配置
        final PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));//父包模块名,默认null 单独生成模块时使用！
        //父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setParent(scanner("包名称："));//默认com.baomidou
        pc.setController("controller");//默认controller
        pc.setService("service");//默认service
        pc.setServiceImpl("service.impl");//默认service.impl
        pc.setEntity("entity");//默认entity
        pc.setMapper("mapper");//默认mapper
        //pc.setXml("userMapper.xml");//默认mapper.xml
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
//         String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/src/main/resources/mappers/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        // templateConfig.setEntity();
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //数据库表映射到实体的命名策略，默认：不做任何改变，原样输出
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体的命名策略，未指定按照 naming 执行
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //【实体】是否为lombok模型（默认 false）
        //strategy.setEntityLombokModel(true);
        //生成@RestController 控制器
        strategy.setRestControllerStyle(true);
        //自定义继承的Controller类全称，带包名
        //strategy.setSuperControllerClass("com.mybatisplus.demo.common.BaseController");
        //strategy.setSuperServiceClass();
        //strategy.setSuperServiceImplClass();
        //strategy.setSuperMapperClass("com.mybatisplus.demo.common.BaseMapper");
        //strategy.setSuperEntityClass("com.mybatisplus.demo.common.BaseEntity");//自定义继承的Entity类全称，带包名

        strategy.setInclude(new String[]{scanner("表名称：")});//表明String数组
        //strategy.setSuperEntityColumns("id");
        // 驼峰转连字符:
        // @RequestMapping("/managerUserActionHistory")-->@RequestMapping("/manager-user-action-history")
        strategy.setControllerMappingHyphenStyle(false);
        strategy.setTablePrefix(new String[] {scanner("表前缀：")});//表前缀

        mpg.setStrategy(strategy);//数据库表配置
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());// 选择 freemarker 引擎，默认 Veloctiy

        //生成代码
        mpg.execute();
    }

}
