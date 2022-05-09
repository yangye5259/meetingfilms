package com.yangye.meetingfilms.film.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yangye.meetingfilms.film.controller.request.FilmSaveRequest;
import com.yangye.meetingfilms.film.controller.vo.FilmActorVO;
import com.yangye.meetingfilms.film.controller.vo.FilmFilmVO;
import com.yangye.meetingfilms.film.controller.vo.FilmFilmsVO;

/**
 * @Author: yangye
 * @Date: 2022/5/9 11:19
 */
public interface FilmService {
    /**
     * 获取演员信息
     *
     * @param nowPage  当前页
     * @param pageSize 页大小
     * @return 分页数据
     */
    IPage<FilmActorVO> getActors(int nowPage, int pageSize);

    /**
     * 获取影片信息
     *
     * @param nowPage  当前页
     * @param pageSize 页大小
     * @return 分页数据
     */
    IPage<FilmFilmsVO> getFilms(Integer nowPage, Integer pageSize);

    /**
     * 根据电影id获取电影详情
     *
     * @param filmId 电影id
     */
    FilmFilmVO getFilmById(String filmId);

    /**
     * 添加电影信息
     *
     * @param filmSaveRequest 请求信息
     */
    void saveFilm(FilmSaveRequest filmSaveRequest);
}
