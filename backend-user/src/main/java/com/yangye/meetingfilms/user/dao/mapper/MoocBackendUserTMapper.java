package com.yangye.meetingfilms.user.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangye.meetingfilms.user.dao.mapper.entity.MoocBackendUserT;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author yangye
 * @since 2022-05-07
 */
public interface MoocBackendUserTMapper extends BaseMapper<MoocBackendUserT> {
    /**
     * 根据用户名获取用户记录
     *
     * @param username 用户名
     * @return 用户记录
     */
    MoocBackendUserT getByUserName(@Param("username") String username);
}
