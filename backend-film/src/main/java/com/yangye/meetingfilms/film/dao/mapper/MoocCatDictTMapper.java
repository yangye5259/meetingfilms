package com.yangye.meetingfilms.film.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangye.meetingfilms.film.dao.entity.MoocCatDictT;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 类型信息表 Mapper 接口
 * </p>
 *
 * @author yangye
 * @since 2022-05-07
 */
public interface MoocCatDictTMapper extends BaseMapper<MoocCatDictT> {

    List<MoocCatDictT> listRecordsByIds(@Param("list") List<Integer> idList);
}
