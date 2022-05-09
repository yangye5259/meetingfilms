package com.yangye.meetingfilms.film.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yangye.meetingfilms.common.exception.CommonServiceException;
import com.yangye.meetingfilms.common.util.CommonUtil;
import com.yangye.meetingfilms.common.vo.BasePageVO;
import com.yangye.meetingfilms.common.vo.BaseResponseVO;
import com.yangye.meetingfilms.film.controller.request.FilmSaveRequest;
import com.yangye.meetingfilms.film.controller.vo.FilmActorVO;
import com.yangye.meetingfilms.film.controller.vo.FilmFilmVO;
import com.yangye.meetingfilms.film.controller.vo.FilmFilmsVO;
import com.yangye.meetingfilms.film.service.FilmService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: yangye
 * @Date: 2022/5/9 11:12
 */
@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @RequestMapping(value = "/actors", method = RequestMethod.GET)
    public BaseResponseVO<Map<String, Object>> describeActors(@RequestBody BasePageVO basePageVO) {
        CommonUtil.check(basePageVO);
        IPage<FilmActorVO> page = filmService.getActors(basePageVO.getNowPage(), basePageVO.getPageSize());
        return BaseResponseVO.success(CommonUtil.pageResultAssemble("actors", page));
    }

    @RequestMapping(value = "/films", method = RequestMethod.GET)
    public BaseResponseVO<Map<String, Object>> describeFilms(@RequestBody BasePageVO basePageVO) {
        CommonUtil.check(basePageVO);
        IPage<FilmFilmsVO> page = filmService.getFilms(basePageVO.getNowPage(), basePageVO.getPageSize());
        return BaseResponseVO.success(CommonUtil.pageResultAssemble("films", page));
    }

    @RequestMapping(value = "/{filmId}", method = RequestMethod.GET)
    public BaseResponseVO<FilmFilmVO> getFilmById(@PathVariable String filmId) {
        if (StringUtils.isEmpty(filmId)) {
            throw new CommonServiceException("电影id不能为空", 400);
        }
        return BaseResponseVO.success(filmService.getFilmById(filmId));
    }

    @RequestMapping(value = "/film/add", method = RequestMethod.POST)
    public BaseResponseVO<Object> saveFilm(@RequestBody FilmSaveRequest filmSaveRequest) {
        filmService.saveFilm(filmSaveRequest);
        return BaseResponseVO.success();
    }

}
