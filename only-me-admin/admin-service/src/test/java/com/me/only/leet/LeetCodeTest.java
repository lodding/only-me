package com.me.only.leet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: only-me->LeetCodeTest
 * @description:
 * @author: szh
 * @create: 2021-12-23 11:22
 **/
@SpringBootTest
public class LeetCodeTest {

    @Test
    public void test01(){
        int[] num = {1,2,3,4,5,6};
        int tag = 5;
        Map<Integer,Integer>map= new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            if (map.containsKey(tag- num[i])){
                System.out.println(new int[] {map.get(tag-num[i]),i});
            }
            map.put(num[i],i);
        }
    }
}
