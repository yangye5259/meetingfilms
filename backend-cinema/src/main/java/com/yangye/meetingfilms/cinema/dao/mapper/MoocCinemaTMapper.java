package com.yangye.meetingfilms.cinema.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangye.meetingfilms.cinema.controller.vo.CinemaInfoVO;
import com.yangye.meetingfilms.cinema.dao.entity.MoocCinemaT;

/**
 * <p>
 * 影院信息表 Mapper 接口
 * </p>
 *
 * @author yangye
 * @since 2022-05-07
 */
public interface MoocCinemaTMapper extends BaseMapper<MoocCinemaT> {
    /**
     * 分页查询
     */
    IPage<CinemaInfoVO> listCinema(Page<CinemaInfoVO> page);
}
