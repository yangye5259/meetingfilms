package com.yangye.meetingfilms.hall.controller.request;

import com.yangye.meetingfilms.common.vo.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: yangye
 * @Date: 2022/5/10 10:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class HallSavedRequest extends BaseRequest {

    private String cinemaId;
    private String filmId;
    private String hallTypeId;
    private String beginTime;
    private String endTime;
    private String filmPrice;
    private String hallName;

    @Override
    public void checkParam() {

    }
}
