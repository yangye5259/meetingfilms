package com.yangye.meetingfilms.cinema.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yangye.meetingfilms.cinema.controller.request.CinemaSaveRequest;
import com.yangye.meetingfilms.cinema.controller.vo.CinemaInfoVO;
import com.yangye.meetingfilms.cinema.service.CinemaService;
import com.yangye.meetingfilms.common.util.CommonUtil;
import com.yangye.meetingfilms.common.vo.BasePageVO;
import com.yangye.meetingfilms.common.vo.BaseResponseVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author: yangye
 * @Date: 2022/5/9 18:10
 */
@RestController
@RequestMapping("/cinema")
public class CinemaController {

    @Resource
    private CinemaService cinemaService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public BaseResponseVO<Object> saveCinema(@RequestBody CinemaSaveRequest cinemaSaveRequest) {
        CommonUtil.checkNotNull(cinemaSaveRequest);
        cinemaSaveRequest.checkParam();
        cinemaService.saveCinema(cinemaSaveRequest);
        return BaseResponseVO.success();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public BaseResponseVO<Map<String, Object>> listCinema(@RequestBody BasePageVO basePageVO) {
        CommonUtil.check(basePageVO);
        IPage<CinemaInfoVO> page = cinemaService.listCinema(basePageVO.getNowPage(), basePageVO.getPageSize());
        Map<String, Object> map = CommonUtil.pageResultAssemble("cinemas", page);
        return BaseResponseVO.success(map);
    }
}
