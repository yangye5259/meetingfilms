package com.yangye.meetingfilms.hall.controller.vo;

import lombok.Data;

/**
 * @Author: yangye
 * @Date: 2022/5/10 10:21
 */
@Data
public class HallsResponseVO {

    private String cinemaName;
    private String hallName;
    private String filmName;
    private String hallTypeName;
    private String beginTime;
    private String endTime;
    private String filmPrice;
}
