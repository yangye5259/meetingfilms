package com.yangye.meetingfilms.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangye
 * @Date: 2022/5/8 22:34
 */
@Slf4j
@RestController
@RequestMapping("/provider")
public class HelloController {


    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say(String message) {
        log.info("provider there say");
        return message + ", provider get it.";
    }
}
