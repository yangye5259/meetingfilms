package com.yangye.meetingfilms.user.controller.request;

import com.yangye.meetingfilms.common.exception.CommonServiceException;
import com.yangye.meetingfilms.common.vo.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: yangye
 * @Date: 2022/5/7 22:09
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LoginRequest extends BaseRequest {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;


    @Override
    public void checkParam() {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new CommonServiceException("username or password is empty!", 400);
        }
    }
}
