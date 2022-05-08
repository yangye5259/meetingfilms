package com.yangye.meetingfilms.user.service;

/**
 * @Author: yangye
 * @Date: 2022/5/8 11:22
 */
public interface UserService {
    /**
     * 验证用户名密码是否正确
     *
     * @param username 用户名
     * @param password 密码
     */
    String checkUserLogin(String username, String password);
}
