package com.yangye.meetingfilms.film.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangye.meetingfilms.film.controller.vo.FilmActorVO;
import com.yangye.meetingfilms.film.dao.entity.MoocActorT;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 演员表 Mapper 接口
 * </p>
 *
 * @author yangye
 * @since 2022-05-07
 */
public interface MoocActorTMapper extends BaseMapper<MoocActorT> {


    MoocActorT getMoocActorTByName(@Param("actorName") String name);

    List<MoocActorT> listMoocActorTByName(@Param("actorName") String name);

    IPage<FilmActorVO> selectPageActors(Page<FilmActorVO> page);

}
