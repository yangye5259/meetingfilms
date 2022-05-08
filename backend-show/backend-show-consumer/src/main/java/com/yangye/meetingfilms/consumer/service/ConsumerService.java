package com.yangye.meetingfilms.consumer.service;

/**
 * @Author: yangye
 * @Date: 2022/5/8 22:39
 */
public interface ConsumerService {
    /**
     * 写死获取
     */
    String sayHello(String message);

    /**
     * 根据eureka获取
     */
    String sayHelloWithEureka(String message);
}
