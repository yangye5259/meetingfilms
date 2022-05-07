package com.yangye.meetingfilms.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangye.meetingfilms.common.entity.MoocActorT;
import com.yangye.meetingfilms.common.mapper.MoocActorTMapper;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: yangye
 * @Date: 2022/5/7 15:45
 */
public class Test01 extends BackendCommonApplicationTests {

    @Resource
    private MoocActorTMapper moocActorTMapper;

    @Test
    public void add() {
        MoocActorT moocActorT = new MoocActorT();
        moocActorT.setActorName("杨烨");
        moocActorT.setActorImg("wobuzhidao");
        moocActorTMapper.insert(moocActorT);
    }

    @Test
    public void select() {
        MoocActorT moocActorT = moocActorTMapper.selectById(1);
        System.out.println(moocActorT);
        List<MoocActorT> moocActorTS = moocActorTMapper.selectList(null);
        System.out.println(moocActorTS);
    }
    @Test
    public void selectByName() {
        MoocActorT moocActorT = moocActorTMapper.getMoocActorTByName("强森");
        System.out.println(moocActorT);

        List<MoocActorT> moocActorTS = moocActorTMapper.listMoocActorTByName("强森");
        System.out.println(moocActorTS);
    }

    @Test
    public void selectByWrapper() {
        QueryWrapper<MoocActorT> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("actor_name", "王传君");
        List<MoocActorT> moocActorTS = moocActorTMapper.selectList(queryWrapper);
        moocActorTS.forEach(System.out::println);
    }

    @Test
    public void selectByPage() {
        for (int i = 1; i <= 3; i++) {
            Page<MoocActorT> page = new Page<>(i, 3);
            IPage<MoocActorT> moocActorTIPage = moocActorTMapper.selectPage(page, null);
            List<MoocActorT> records = moocActorTIPage.getRecords();
            System.out.println(records);
        }
    }

    @Test
    public void update() {
        MoocActorT moocActorT = new MoocActorT();
        moocActorT.setActorName("于季菲");
        moocActorT.setActorImg("我真的好想你");
        moocActorT.setUuid(11);
        moocActorTMapper.updateById(moocActorT);
    }

    @Test
    public void delete() {
        moocActorTMapper.deleteById(11);
    }
}
