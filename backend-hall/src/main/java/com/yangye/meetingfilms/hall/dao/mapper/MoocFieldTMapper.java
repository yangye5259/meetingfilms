package com.yangye.meetingfilms.hall.dao.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangye.meetingfilms.hall.controller.vo.HallsResponseVO;
import com.yangye.meetingfilms.hall.dao.entity.MoocFieldT;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 放映场次表 Mapper 接口
 * </p>
 *
 * @author yangye
 * @since 2022-05-07
 */
public interface MoocFieldTMapper extends BaseMapper<MoocFieldT> {

    IPage<HallsResponseVO> describeHalls(Page<HallsResponseVO> page, @Param("ew") QueryWrapper<HallsResponseVO> queryWrapper);
}
