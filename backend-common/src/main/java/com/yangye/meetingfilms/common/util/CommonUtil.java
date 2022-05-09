package com.yangye.meetingfilms.common.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Maps;
import com.yangye.meetingfilms.common.exception.CommonServiceException;
import com.yangye.meetingfilms.common.vo.BasePageVO;

import java.util.Map;
import java.util.Objects;

/**
 * @Author: yangye
 * @Date: 2022/5/9 11:30
 */
public class CommonUtil {


    public static void check(BasePageVO basePageVO) {
        if (Objects.isNull(basePageVO)) {
            throw new CommonServiceException("参数不能为空", 500);
        }
        basePageVO.checkParam();
    }


    public static <T> Map<String, Object> pageResultAssemble(String title, IPage<T> page) {
        if (Objects.isNull(page)) {
            throw new CommonServiceException("查询数据为空", 200);
        }
        Map<String, Object> map = Maps.newHashMap();
        map.put("totalSize", page.getTotal());
        map.put("totalPage", page.getPages());
        map.put("pageSize", page.getSize());
        map.put("nowPage", page.getCurrent());
        map.put(title, page.getRecords());
        return map;
    }
}
