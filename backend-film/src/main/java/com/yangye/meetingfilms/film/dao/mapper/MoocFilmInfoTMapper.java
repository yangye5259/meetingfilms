package com.yangye.meetingfilms.film.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangye.meetingfilms.film.dao.entity.MoocFilmInfoT;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author yangye
 * @since 2022-05-07
 */
public interface MoocFilmInfoTMapper extends BaseMapper<MoocFilmInfoT> {

    MoocFilmInfoT selectByFilmIdMoocFilmInfoT(@Param("filmId") String filmId);

}
