package com.yangye.meetingfilms.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.yangye.meetingfilms.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: yangye
 * @Date: 2022/5/8 22:40
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("/sayHello")
    public String sayHello(String message) {
        String one = consumerService.sayHello(message);
        String two = consumerService.sayHelloWithEureka(message);
        Map<String, String> map = Maps.newHashMap();
        map.put("one", one);
        map.put("two", two);
        return JSON.toJSONString(map);
    }
}
