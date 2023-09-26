package com.heima.kafka.listener;

import com.alibaba.fastjson.JSON;
import com.heima.kafka.pojo.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class HelloListener {

    @KafkaListener(topics = "user-topic")
    public void onMessage(String message){
        if (!StringUtils.isEmpty(message)){
            User user = JSON.parseObject(message, User.class);
            System.out.println("对象转json后接收到再转为对象："+user);
            System.out.println(message);
        }
    }
}
