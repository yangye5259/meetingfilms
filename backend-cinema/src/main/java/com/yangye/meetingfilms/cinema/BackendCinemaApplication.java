package com.yangye.meetingfilms.cinema;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "com.yangye.meetingfilms")
@MapperScan(basePackages = "com.yangye.meetingfilms.cinema.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class BackendCinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendCinemaApplication.class, args);
    }

}
