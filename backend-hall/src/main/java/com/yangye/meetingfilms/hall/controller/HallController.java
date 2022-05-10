package com.yangye.meetingfilms.hall.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yangye.meetingfilms.common.util.CommonUtil;
import com.yangye.meetingfilms.common.vo.BaseResponseVO;
import com.yangye.meetingfilms.hall.controller.request.HallListRequest;
import com.yangye.meetingfilms.hall.controller.request.HallSavedRequest;
import com.yangye.meetingfilms.hall.controller.vo.HallsResponseVO;
import com.yangye.meetingfilms.hall.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: yangye
 * @Date: 2022/5/9 23:11
 */
@RestController
@RequestMapping("/hall")
public class HallController {

    @Autowired
    private HallService hallService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public BaseResponseVO<Map<String, Object>> listHalls(@RequestBody HallListRequest hallListRequest) {
        hallListRequest.checkParam();
        IPage<HallsResponseVO> page = hallService.getHallsPage(hallListRequest.getNowPage(),
                hallListRequest.getPageSize(), hallListRequest.getCinemaId());
        Map<String, Object> map = CommonUtil.pageResultAssemble("halls", page);
        return BaseResponseVO.success(map);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResponseVO<Object> saveHalls(@RequestBody HallSavedRequest hallSavedRequest) {
        hallService.saveHall(hallSavedRequest);
        return BaseResponseVO.success();
    }
}
