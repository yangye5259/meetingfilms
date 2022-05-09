package com.yangye.meetingfilms.common.vo;

import com.yangye.meetingfilms.common.exception.CommonServiceException;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: yangye
 * @Date: 2022/5/9 11:15
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BasePageVO extends BaseRequest {
    /**
     * 当前请求页
     */
    private Integer nowPage = 1;
    /**
     * 页大小
     */
    private Integer pageSize = 10;

    @Override
    public void checkParam() {
        if (nowPage <= 0 || pageSize <= 0) {
            throw new CommonServiceException("页数或页码参数不合法", 500);
        }
    }
}
