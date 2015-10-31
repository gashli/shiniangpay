package com.shin.pay.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author gaoshiliang
 * @Date 15/10/27.
 */
public class DateUtil {
    /**
     * 按照参数format的格式，日期转字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String date2Str(Date date, String format) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.setLenient(false);
            return sdf.format(date);
        } else {
            return "";
        }
    }
}
