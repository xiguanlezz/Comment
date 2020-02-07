package com.cj.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CommonUtil {
    public static int generateRandom(int size) {
        return (int) ((Math.random() * 9 + 1) * Math.pow(10, size - 1));
    }

    //UUID保证对在同一时空中的所有机器都是唯一的
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getcurrentTime(String pattern) {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }
}
