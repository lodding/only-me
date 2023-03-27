package com.me.only.mq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest

public class MqTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void test1(){
        String messageId = UUID.randomUUID().toString();
        String messageData = "test message,hello!";
        String current = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Map<String,Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("data",messageData);
        map.put("current",current);
        rabbitTemplate.convertAndSend("TestDirectExchange", "123", map, new CorrelationData(UUID.randomUUID().toString()));
    }

    @Test
    public void rest2(){

     int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
            int pre = 0;
            int res = nums[0];
            for (int num : nums) {
                pre = Math.max(pre + num, num);
                res = Math.max(res, pre);
            }
            System.out.println(res);

    }
}
