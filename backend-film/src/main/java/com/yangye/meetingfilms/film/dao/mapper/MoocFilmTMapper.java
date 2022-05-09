package com.yangye.meetingfilms.film.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangye.meetingfilms.film.controller.vo.FilmActorVO;
import com.yangye.meetingfilms.film.controller.vo.FilmFilmsVO;
import com.yangye.meetingfilms.film.dao.entity.MoocFilmT;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author yangye
 * @since 2022-05-07
 */
public interface MoocFilmTMapper extends BaseMapper<MoocFilmT> {
    /**
     * 分页查询影片
     *
     * @param page 参数
     */
    IPage<FilmFilmsVO> selectPageFilms(Page<FilmActorVO> page);


    MoocFilmT getById(@Param("id") Integer id);
}
