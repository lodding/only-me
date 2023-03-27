package com.me.only.Lists;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ListTest {

    @Test
    public void  test1(){
        List list  = new ArrayList();
        List partition = Lists.partition(list, 100);
        System.out.println(partition);

    }
}
