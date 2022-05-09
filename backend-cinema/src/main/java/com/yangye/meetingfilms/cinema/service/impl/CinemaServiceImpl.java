package com.yangye.meetingfilms.cinema.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangye.meetingfilms.cinema.controller.request.CinemaSaveRequest;
import com.yangye.meetingfilms.cinema.controller.vo.CinemaInfoVO;
import com.yangye.meetingfilms.cinema.dao.entity.MoocCinemaT;
import com.yangye.meetingfilms.cinema.dao.mapper.MoocCinemaTMapper;
import com.yangye.meetingfilms.cinema.service.CinemaService;
import com.yangye.meetingfilms.common.util.ToolUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: yangye
 * @Date: 2022/5/9 18:10
 */
@Service
public class CinemaServiceImpl implements CinemaService {

    @Resource
    private MoocCinemaTMapper moocCinemaTMapper;

    @Override
    public void saveCinema(CinemaSaveRequest cinemaSaveRequest) {
        MoocCinemaT moocCinemaT = new MoocCinemaT();
        moocCinemaT.setCinemaName(cinemaSaveRequest.getCinemaName());
        moocCinemaT.setCinemaPhone(cinemaSaveRequest.getCinemaTele());
        moocCinemaT.setBrandId(ToolUtils.str2Int(cinemaSaveRequest.getBrandId()));
        moocCinemaT.setAreaId(ToolUtils.str2Int(cinemaSaveRequest.getAreaId()));
        moocCinemaT.setHallIds(cinemaSaveRequest.getHallTypeIds());
        moocCinemaT.setImgAddress(cinemaSaveRequest.getCinemaImgAddress());
        moocCinemaT.setCinemaAddress(cinemaSaveRequest.getCinemaAddress());
        moocCinemaT.setMinimumPrice(ToolUtils.str2Int(cinemaSaveRequest.getCinemaPrice()));
        moocCinemaTMapper.insert(moocCinemaT);
    }

    @Override
    public IPage<CinemaInfoVO> listCinema(Integer nowPage, Integer pageSize) {
        Page<CinemaInfoVO> page = new Page<>(nowPage, pageSize);
        return moocCinemaTMapper.listCinema(page);
    }
}
