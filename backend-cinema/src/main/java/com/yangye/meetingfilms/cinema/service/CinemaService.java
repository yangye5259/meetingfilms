package com.yangye.meetingfilms.cinema.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yangye.meetingfilms.cinema.controller.request.CinemaSaveRequest;
import com.yangye.meetingfilms.cinema.controller.vo.CinemaInfoVO;

/**
 * @Author: yangye
 * @Date: 2022/5/9 18:09
 */
public interface CinemaService {
    /**
     * 获取影厅列表
     *
     * @param nowPage  当前页
     * @param pageSize 页大小
     */
    IPage<CinemaInfoVO> listCinema(Integer nowPage, Integer pageSize);

    /**
     * 保存影院信息
     */
    void saveCinema(CinemaSaveRequest cinemaSaveRequest);
}
