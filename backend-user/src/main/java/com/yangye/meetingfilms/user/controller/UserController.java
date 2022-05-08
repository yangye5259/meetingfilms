package com.yangye.meetingfilms.user.controller;

import com.google.common.collect.Maps;
import com.yangye.meetingfilms.user.controller.request.LoginRequest;
import com.yangye.meetingfilms.user.service.UserService;
import com.yangye.meetingfilms.utils.exception.CommonServiceException;
import com.yangye.meetingfilms.utils.util.JwtTokenUtil;
import com.yangye.meetingfilms.utils.vo.BaseResponseVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: yangye
 * @Date: 2022/5/7 22:07
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResponseVO<Object> login(@RequestBody LoginRequest loginRequest) {
        if (Objects.isNull(loginRequest)) {
            throw new CommonServiceException("request is null", 400);
        }
        loginRequest.checkParam();
        String s = userService.checkUserLogin(loginRequest.getUsername(), loginRequest.getPassword());
        String randomKey = JwtTokenUtil.getRandomKey();
        String token = JwtTokenUtil.generateToken(s, randomKey);
        Map<String, String> map = Maps.newHashMap();
        map.put("randomKey", randomKey);
        map.put("token", token);
        return BaseResponseVO.success(map);
    }
}
