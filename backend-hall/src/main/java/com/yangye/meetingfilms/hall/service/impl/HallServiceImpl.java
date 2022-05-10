package com.yangye.meetingfilms.hall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangye.meetingfilms.common.exception.CommonServiceException;
import com.yangye.meetingfilms.common.util.ToolUtils;
import com.yangye.meetingfilms.hall.controller.request.HallSavedRequest;
import com.yangye.meetingfilms.hall.controller.vo.HallsResponseVO;
import com.yangye.meetingfilms.hall.dao.entity.MoocFieldT;
import com.yangye.meetingfilms.hall.dao.entity.MoocHallFilmInfoT;
import com.yangye.meetingfilms.hall.dao.mapper.MoocFieldTMapper;
import com.yangye.meetingfilms.hall.dao.mapper.MoocHallFilmInfoTMapper;
import com.yangye.meetingfilms.hall.service.HallService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: yangye
 * @Date: 2022/5/9 23:12
 */
@Slf4j
@Service
public class HallServiceImpl implements HallService {

    @Resource
    private MoocFieldTMapper moocFieldTMapper;

    @Resource
    private MoocHallFilmInfoTMapper moocHallFilmInfoTMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Override
    public IPage<HallsResponseVO> getHallsPage(Integer nowPage, Integer pageSize, String cinemaId) {
        Page<HallsResponseVO> page = new Page<>(nowPage, pageSize);
        QueryWrapper<HallsResponseVO> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(cinemaId)) {
            queryWrapper.eq("cinema_id", cinemaId);
        }
        return moocFieldTMapper.describeHalls(page, queryWrapper);
    }


    @Override
    public void saveHall(HallSavedRequest hallSavedRequest) {
        // 播放厅的列表数据
        MoocFieldT field = new MoocFieldT();

        field.setCinemaId(ToolUtils.str2Int(hallSavedRequest.getCinemaId()));
        field.setFilmId(ToolUtils.str2Int(hallSavedRequest.getFilmId()));
        field.setBeginTime(hallSavedRequest.getBeginTime());
        field.setEndTime(hallSavedRequest.getEndTime());
        field.setHallId(ToolUtils.str2Int(hallSavedRequest.getHallTypeId()));
        field.setHallName(hallSavedRequest.getHallName());
        field.setPrice(ToolUtils.str2Int(hallSavedRequest.getFilmPrice()));
        // 播放厅对应的影片数据， 影片冗余数据， 缓存里有一份
        MoocHallFilmInfoT hallFilmInfo = describeFilmInfo(hallSavedRequest.getFilmId());

//        moocHallFilmInfoTMapper.insert(hallFilmInfo);
    }


    // 播放厅对应的影片数据， 影片冗余数据， 缓存里有一份
    private MoocHallFilmInfoT describeFilmInfo(String filmId) throws CommonServiceException {
//        // 解析返回值
//        BaseResponseVO<DescribeFilmRespVO> baseResponseVO = filmFeignApi.describeFilmById(filmId);
//        DescribeFilmRespVO filmResult = baseResponseVO.getData();
//        if (filmResult == null || ToolUtils.strIsNull(filmResult.getFilmId())) {
//            throw new CommonServiceException("抱歉，未能找到对应的电影信息，filmId : " + filmId, 404);
//        }



        // 组织参数
        MoocHallFilmInfoT hallFilmInfo = new MoocHallFilmInfoT();
//        hallFilmInfo.setFilmId(ToolUtils.str2Int(filmResult.getFilmId()));
//        hallFilmInfo.setFilmName(filmResult.getFilmName());
//        hallFilmInfo.setFilmLength(filmResult.getFilmLength());
//        hallFilmInfo.setFilmCats(filmResult.getFilmCats());
//        hallFilmInfo.setActors(filmResult.getActors());
//        hallFilmInfo.setImgAddress(filmResult.getImgAddress());

        return hallFilmInfo;
    }
}
