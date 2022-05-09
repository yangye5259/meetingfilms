package com.yangye.meetingfilms.film.controller.vo;

import lombok.Data;

/**
 * @Author: yangye
 * @Date: 2022/5/9 15:18
 */
@Data
public class FilmFilmVO {

    private String filmId;

    private String filmName;
    /**
     * 电影时长
     */
    private String filmLength;
    /**
     * 演员列表（用，分隔）
     */
    private String actors;
    /**
     * 图片地址
     */
    private String imgAddress;
    /**
     * 预览图
     */
    private String subAddress;
    /**
     * 影片分类（用，分隔）
     */
    private String filmCats;
}
