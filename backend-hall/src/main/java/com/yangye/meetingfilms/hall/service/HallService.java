package com.yangye.meetingfilms.hall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yangye.meetingfilms.hall.controller.request.HallSavedRequest;
import com.yangye.meetingfilms.hall.controller.vo.HallsResponseVO;

/**
 * @Author: yangye
 * @Date: 2022/5/9 23:12
 */
public interface HallService {
    /**
     * 分页获取播放厅接口
     *
     * @param nowPage  当前页
     * @param pageSize 页大小
     * @param cinemaId 影院id
     */
    IPage<HallsResponseVO> getHallsPage(Integer nowPage, Integer pageSize, String cinemaId);

    /**
     * 保存影厅
     */
    void saveHall(HallSavedRequest hallSavedRequest);
}
