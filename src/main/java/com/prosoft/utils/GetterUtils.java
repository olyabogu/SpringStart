package com.prosoft.utils;

import java.sql.Date;


public class GetterUtils {

    public static Integer parseInt(String s) {
        Integer result;
        try {
            result = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            result = null;
        }
        return result;
    }

    public static Date parseDate(String strDate) {
        Date result;
        try {
            result = Date.valueOf(strDate);
        } catch (IllegalArgumentException e) {
            result = null;
        }
        return result;
    }

    public static Long parseLong(String s) {
        Long result;
        try {
            result = Long.valueOf(s);
        } catch (NumberFormatException e) {
            result = null;
        }
        return result;
    }
}
