package com.me.only;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class AdminServiceApplicationTests {

    @Test
    void contextLoads() {
    }


    /**
     * contains测试
     */
    @Test
    void test01(){
        List<String> list=new ArrayList<>();
        list.add("123456789");

        list.add("5689");
        list.add("1256891");
        List<String> collect = list.stream().filter(data -> data.contains("5689")).collect(Collectors.toList());

        System.out.println(collect);
    }

}
