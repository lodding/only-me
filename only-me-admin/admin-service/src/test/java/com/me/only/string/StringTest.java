package com.me.only.string;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;


/**
 * @program: only-me->StringTest
 * @description:
 * @author: szh
 * @create: 2021-12-30 14:45
 **/
@SpringBootTest
public class StringTest {

    @Test
    public void StringFormat() {

        /**
         * Hi,哈士奇
         * Hi,老鹰:是一种.鸟类
         * 字母h的大写是：H
         * 12.34>33.22的结果是：false
         * 100的一半是：50
         * 100的16进制数是：64
         * 100的8进制数是：144
         * 100元的书包打8.5折扣是：85.000000 元
         * 100的16进制浮点数是：0x1.54p6
         * 100的指数表示：8.500000e+01
         * 10的指数和浮点数结果的长度较短的是：85.0000
         * 100的折扣是85%
         * 字母A的散列码是：41
         */

        String str1=String.format("Hi,%s", "哈士奇");
        System.out.println(str1);
        String str2=String.format("Hi,%s:%s.%s", "老鹰","是一种","鸟类");
        System.out.println(str2);
        System.out.printf("字母h的大写是：%c %n", 'H');
        System.out.printf("12.34>33.22的结果是：%b %n", 12.34>33.22);
        System.out.printf("100的一半是：%d %n", 100/2);
        System.out.printf("100的16进制数是：%x %n", 100);
        System.out.printf("100的8进制数是：%o %n", 100);
        System.out.printf("100元的书包打8.5折扣是：%f 元%n", 100*0.85);
        System.out.printf("100的16进制浮点数是：%a %n", 100*0.85);
        System.out.printf("100的指数表示：%e %n", 100*0.85);
        System.out.printf("10的指数和浮点数结果的长度较短的是：%g %n", 100*0.85);
        System.out.printf("100的折扣是%d%% %n", 85);
        System.out.printf("字母A的散列码是：%h %n", 'A');


        /**
         *全部日期和时间信息：星期三 九月 19 13:47:42 CST 2018
         * 年-月-日格式：2018-09-19
         * 月/日/年格式：09/19/18
         * HH:MM:SS PM格式（12时制）：01:47:42 下午
         * HH:MM:SS格式（24时制）：13:47:42
         * HH:MM格式（24时制）：13:47
         */

        Date date=new Date();
        //c的使用
        System.out.printf("全部日期和时间信息：%tc%n",date);
        //f的使用
        System.out.printf("年-月-日格式：%tF%n",date);
        //d的使用
        System.out.printf("月/日/年格式：%tD%n",date);
        //r的使用
        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);
        //t的使用
        System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);
        //R的使用
        System.out.printf("HH:MM格式（24时制）：%tR",date);

        System.out.println("年-月-日格式：%tF%n");

    }
    @Test
    public  void test01(){
        Date date=new Date();
        System.out.printf("客户%s%tF成为你的会员快去看看吧","卧槽无情",date);

    }

    @Test
    public  void test02(){
String s = "[]";
        System.out.println(StringUtils.isNotBlank(s));

    }
}
