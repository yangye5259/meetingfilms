package com.yangye.meetingfilms.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: yangye
 * @Date: 2022/5/7 22:15
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CommonServiceException extends RuntimeException {

    private String message;

    private Integer code;
}
