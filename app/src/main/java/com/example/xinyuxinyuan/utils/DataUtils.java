package com.example.xinyuxinyuan.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by 键盘上的手艺人 on 2018/5/4.
 */

public class DataUtils {

    public static String getDateToString(long time) {
        Date d = new Date(time);
        return new SimpleDateFormat("MM-dd HH:mm").format(d);
    }
}
