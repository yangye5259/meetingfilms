package com.yangye.meetingfilms.user.controller.request;

import com.yangye.meetingfilms.utils.vo.BaseRequest;
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

    private String username;

    private String password;


    @Override
    public void checkParam() {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new IllegalArgumentException("username or password is empty!");
        }
    }
}
