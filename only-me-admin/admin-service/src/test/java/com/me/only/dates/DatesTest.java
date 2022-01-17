package com.me.only.dates;

import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

/**
 * @program: only-me->DatesTest
 * @description:
 * @author: szh
 * @create: 2022-01-11 14:09
 **/
@SpringBootTest
public class DatesTest {


    /**
     * 前半小时
     */
    @Test
    public void test1(){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(12, -30);
        System.out.println(calendar.getTime());

        String s = DateUtil.formatChineseDate(new Date(), false, false);
        System.out.println(s);



    }
}
