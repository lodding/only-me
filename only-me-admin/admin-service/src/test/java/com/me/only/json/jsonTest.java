package com.me.only.json;

import cn.hutool.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class jsonTest {

    @Test
    public void test1(){
     JSONObject jsonObject = new JSONObject();

        System.out.println(jsonObject.get("123"));
    }
}
