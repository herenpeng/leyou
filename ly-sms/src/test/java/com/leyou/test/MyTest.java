package com.leyou.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hrp
 * 2020/2/15 15:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void test() throws InterruptedException {
        Map<String,String> msg = new HashMap<>();
        msg.put("phone","15465789123");
        msg.put("code","Hello 阿里云！");
        amqpTemplate.convertAndSend("ly.sms.exchange","sms.verify.code", msg);
        Thread.sleep(10000L);
    }

}
