package com.yangye.meetingfilms.film.controller.vo;

import lombok.Data;

/**
 * @Author: yangye
 * @Date: 2022/5/9 15:11
 */
@Data
public class FilmFilmsVO {
    /**
     * 影片id
     */
    private String filmId;
    /**
     * 影片状态
     */
    private String filmStatus;
    /**
     * 影片名称
     */
    private String filmName;
    /**
     * 影片英文名称
     */
    private String filmEnName;
    /**
     * 影片评分
     */
    private String filmScore;
    /**
     * 预售款
     */
    private String preSaleNum;
    /**
     * 票房
     */
    private String boxOffice;
    /**
     * 影片上映时间
     */
    private String filmTime;
    /**
     * 影片市场
     */
    private String filmLength;
    /**
     * 图片
     */
    private String mainImg;
}
