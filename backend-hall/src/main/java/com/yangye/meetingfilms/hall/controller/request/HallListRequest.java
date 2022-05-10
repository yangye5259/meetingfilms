package com.yangye.meetingfilms.hall.controller.request;

import com.yangye.meetingfilms.common.vo.BasePageVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: yangye
 * @Date: 2022/5/10 10:16
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class HallListRequest extends BasePageVO {

    private String cinemaId;

    @Override
    public void checkParam() {
        super.checkParam();
    }
}
