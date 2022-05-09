package com.yangye.meetingfilms.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.utils.util
 * @description : 基础工具类
 **/
public class ToolUtils {

    private ToolUtils() {
    }

    // 判断数字正则表达式
    private static final Pattern pattern = Pattern.compile("[0-9]*");

    // 检查字符串是不是int类型
    public static boolean checkInt(String str) {
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

    // 字符串转换为int类型
    public static Integer str2Int(String str) {
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return 0;
        } else {
            return Integer.parseInt(str);
        }
    }

    // 字符串转换为LocalDateTime
    public static Date str2LocalDateTime(String dateStr) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.parse(dateStr);
    }

}
