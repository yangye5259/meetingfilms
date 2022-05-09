package com.yangye.meetingfilms.common.vo;

import com.yangye.meetingfilms.common.exception.CommonServiceException;
import lombok.Data;

/**
 * @Author: yangye
 * @Date: 2022/5/7 19:53
 */
@Data
public class BaseResponseVO<T> {
    /**
     * 业务code
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String message;
    /**
     * 业务数据
     */
    private T data;

    private BaseResponseVO() {
    }

    /**
     * 成功无参数
     */
    public static BaseResponseVO<Object> success() {
        BaseResponseVO<Object> responseVO = new BaseResponseVO<>();
        responseVO.setCode(200);
        return responseVO;
    }

    /**
     * 成功有参数
     */
    public static <T> BaseResponseVO<T> success(T data) {
        BaseResponseVO<T> responseVO = new BaseResponseVO<>();
        responseVO.setCode(200);
        responseVO.setData(data);
        return responseVO;
    }

    /**
     * 成功有参数有信息
     */
    public static <T> BaseResponseVO<T> success(T data, String message) {
        BaseResponseVO<T> responseVO = new BaseResponseVO<>();
        responseVO.setCode(200);
        responseVO.setData(data);
        responseVO.setMessage(message);
        return responseVO;
    }


    public static BaseResponseVO<Object> fail() {
        BaseResponseVO<Object> responseVO = new BaseResponseVO<>();
        responseVO.setCode(500);
        return responseVO;
    }

    public static BaseResponseVO<Object> fail(String message) {
        BaseResponseVO<Object> responseVO = new BaseResponseVO<>();
        responseVO.setCode(500);
        responseVO.setMessage(message);
        return responseVO;
    }

    public static BaseResponseVO<Object> withException(CommonServiceException e) {
        BaseResponseVO<Object> responseVO = new BaseResponseVO<>();
        responseVO.setCode(e.getCode());
        responseVO.setMessage(e.getMessage());
        return responseVO;
    }
}
