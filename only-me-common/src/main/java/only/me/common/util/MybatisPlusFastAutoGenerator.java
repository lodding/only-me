package only.me.common.util;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * mybatis plus 代码生成器
 * @author jinghong
 */
public class MybatisPlusFastAutoGenerator {

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
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
            //项目完整路径  例 /:D/Users/kuka_consumer/consumer-service/consumer-service-core/src/main/java
            gc.setOutputDir("/Users/jinghong/ideaProjects/kuka_consumer/label-service/label-service-core/src/main/java");
            //是否覆盖以前文件
            gc.setFileOverride(true);
            //是否打开生成目录
            gc.setOpen(true);
            //设置项目作者名称
            gc.setAuthor("szh");
            //设置主键策略
            gc.setIdType(IdType.AUTO);
            //生成基本ResultMap
            gc.setBaseResultMap(true);
            //生成基本ColumnList
            gc.setBaseColumnList(true);
            //去掉服务默认前缀
            gc.setServiceName("%sService");
            //设置时间类型
            gc.setDateType(DateType.ONLY_DATE);
            //开启Swagger2注解
            gc.setSwagger2(true);
            mpg.setGlobalConfig(gc);

            // 数据源配置
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setUrl("jdbc:mysql://192.168.248.247:3306/consumer_label_db?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=PRC&useSSL=false");
            dsc.setDriverName("com.mysql.jdbc.Driver");
            dsc.setUsername("kukatest");
            dsc.setPassword("Kuka_2019");
            mpg.setDataSource(dsc);

            // 包配置
            PackageConfig pc = new PackageConfig();
            pc.setParent("com.mayi.label");
            pc.setMapper("mapper");
            pc.setXml("mapper.xml");
            pc.setEntity("domain");
            pc.setService("service");
            pc.setServiceImpl("service.impl");
            pc.setController("controller");
            mpg.setPackageInfo(pc);

            // 策略配置
            StrategyConfig sc = new StrategyConfig();
            sc.setNaming(NamingStrategy.underline_to_camel);
            sc.setColumnNaming(NamingStrategy.underline_to_camel);
            //自动lombok
            sc.setEntityLombokModel(true);
            sc.setRestControllerStyle(true);
            sc.setControllerMappingHyphenStyle(true);
            //驼峰命名
            sc.setRestControllerStyle(true);
            //  sc.setTablePrefix("tbl_"); 设置表名前缀
            sc.setInclude(scanner("表名，多个英文逗号分割").split(","));
            mpg.setStrategy(sc);
            // 生成代码
            mpg.execute();
        }

}
