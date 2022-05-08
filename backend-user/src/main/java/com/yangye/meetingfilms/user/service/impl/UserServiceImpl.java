package com.yangye.meetingfilms.user.service.impl;

import com.yangye.meetingfilms.user.dao.mapper.MoocBackendUserTMapper;
import com.yangye.meetingfilms.user.dao.mapper.entity.MoocBackendUserT;
import com.yangye.meetingfilms.user.service.UserService;
import com.yangye.meetingfilms.utils.exception.CommonServiceException;
import com.yangye.meetingfilms.utils.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author: yangye
 * @Date: 2022/5/8 11:22
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private MoocBackendUserTMapper backendUserTMapper;

    @Override
    public void checkUserLogin(String username, String password) {
        MoocBackendUserT moocBackendUserT = backendUserTMapper.getByUserName(username);
        if (Objects.isNull(moocBackendUserT)) {
            throw new CommonServiceException("User does not exist", 500);
        }
        String encrypt = MD5Util.encrypt(password);
        if (StringUtils.equals(encrypt, moocBackendUserT.getUserPwd())) {
            return;
        }
        throw new CommonServiceException("Incorrect password", 500);
    }
}
