package com.yangye.meetingfilms.hall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: yangye
 * @Date: 2022/5/10 11:23
 */
@Configuration
public class HallConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
