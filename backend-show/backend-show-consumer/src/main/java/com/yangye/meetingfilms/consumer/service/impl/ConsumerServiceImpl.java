package com.yangye.meetingfilms.consumer.service.impl;

import com.yangye.meetingfilms.consumer.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: yangye
 * @Date: 2022/5/8 22:39
 */
@Slf4j
@Service
public class ConsumerServiceImpl implements ConsumerService {


    private static final String PRE_HTTP = "http://";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Override
    public String sayHello(String message) {
        //rpc调用provider方法
        String host = "127.0.0.1:";
        int port = 8999;
        String uri = "/provider/say?message=" + message;
        String url = PRE_HTTP + host + port + uri;
        log.info("consumer there sayHello");
        return restTemplate.getForObject(url, String.class);
    }

    @Override
    public String sayHelloWithEureka(String message) {
        ServiceInstance instance = loadBalancerClient.choose("service-provider");
        String host = instance.getHost();
        int port = instance.getPort();
        String uri = "/provider/say?message=" + message;
        String url = PRE_HTTP + host + ":" + port + uri;
        log.info("consumer there sayHello");
        return restTemplate.getForObject(url, String.class);
    }
}
