package com.onle.me.json;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class jsonTest {

    @Test
    public void test1(){
        List<Integer>list =new ArrayList<>();
        list.add(1);
        System.out.println(list.size());
    }
    @Test
    public void test2(){
        List<String>list =new ArrayList<>();

    }
}
