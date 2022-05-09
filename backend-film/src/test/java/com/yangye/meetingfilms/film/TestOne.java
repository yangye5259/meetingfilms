package com.yangye.meetingfilms.film;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: yangye
 * @Date: 2022/5/9 16:45
 */
public class TestOne {


    @Test
    public void test01() {
        String s = "#2#4#22#";
        String[] split = s.split("#");
        List<String> idList = new ArrayList<>(Arrays.asList(split));
        System.out.println(idList);
    }
}
