package com.yangye.meetingfilms.cinema.controller.vo;

import lombok.Data;

/**
 * @Author: yangye
 * @Date: 2022/5/9 18:37
 */
@Data
public class CinemaInfoVO {
    /**
     * 品牌编号
     */
    private String brandId;
    /**
     * 地区编号
     */
    private String areaId;
    /**
     * 影厅类型编号
     */
    private String hallTypeIds;
    /**
     * 影院名称
     */
    private String cinemaName;
    /**
     * 影院地址
     */
    private String cinemaAddress;
    /**
     * 影院电话
     */
    private String cinemaTele;
    /**
     * 影院图片
     */
    private String cinemaImgAddress;
    /**
     * 影院最低票价
     */
    private String cinemaPrice;
}
