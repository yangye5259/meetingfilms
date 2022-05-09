package com.yangye.meetingfilms.user;

import com.yangye.meetingfilms.user.dao.mapper.MoocBackendUserTMapper;
import com.yangye.meetingfilms.user.dao.entity.MoocBackendUserT;
import com.yangye.meetingfilms.utils.util.MD5Util;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * @Author: yangye
 * @Date: 2022/5/7 20:33
 */
public class UserTest extends BackendUserApplicationTests {

    @Resource
    private MoocBackendUserTMapper moocBackendUserTMapper;

    @Test
    public void test01() {
        System.out.println(moocBackendUserTMapper.selectList(null));
    }

    @Test
    public void add() {
        MoocBackendUserT moocBackendUserT = new MoocBackendUserT();
        moocBackendUserT.setUserName("admin");
        moocBackendUserT.setUserPwd(MD5Util.encrypt("095261"));
        moocBackendUserT.setUserPhone("18115166503");
        moocBackendUserTMapper.insert(moocBackendUserT);
    }
}
