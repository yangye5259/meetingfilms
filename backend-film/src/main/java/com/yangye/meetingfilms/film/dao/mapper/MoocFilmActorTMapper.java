package com.yangye.meetingfilms.film.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangye.meetingfilms.film.dao.entity.MoocFilmActorT;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 影片与演员映射表 Mapper 接口
 * </p>
 *
 * @author yangye
 * @since 2022-05-07
 */
public interface MoocFilmActorTMapper extends BaseMapper<MoocFilmActorT> {

    List<MoocFilmActorT> listRecordsByFilmId(@Param("filmId") String filmId);
}
