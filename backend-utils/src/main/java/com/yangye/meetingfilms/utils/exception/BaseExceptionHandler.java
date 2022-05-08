package com.yangye.meetingfilms.utils.exception;

import com.yangye.meetingfilms.utils.vo.BaseResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: yangye
 * @Date: 2022/5/8 10:15
 * 公共异常处理类
 */
@Slf4j
@ControllerAdvice
public class BaseExceptionHandler {


    @ResponseBody
    @ExceptionHandler(CommonServiceException.class)
    public BaseResponseVO<Object> serviceExceptionHandler(CommonServiceException exception) {
        log.error("公共异常捕获：", exception);
        return BaseResponseVO.withException(exception);
    }
}
