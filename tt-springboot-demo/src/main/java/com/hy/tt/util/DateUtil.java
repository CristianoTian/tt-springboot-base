package com.hy.tt.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @auther thy
 * @date 2019/11/11
 */
public class DateUtil {

    private static  final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    private static  final String YYYY_MM_DD = "yyyy-MM-dd";
    private static  final String HH_MM_SS = "HH:mm:ss";

    public static String getNow(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        String s = transferDateToString(localDateTime);
        return s;
    }

    private static String transferDateToString(LocalDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD);
        String format = formatter.format(dateTime);
        return format;
    }

    public static void main(String[] args) {
        String now = getNow();
        System.out.println(now);
    }
}
