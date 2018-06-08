package com.arrk.arrktest.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by abhiholkar on 07/06/2018.
 */

public class DateTimeUtils {

    public static String getDate(String datetimeString) {
        String dateString = datetimeString;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(datetimeString);
            dateString = sdf.format(date);
        } catch (ParseException pe) {
        }
        return dateString;

    }

    public static String getTime(String datetimeString) {
        String timeString = "datetimeString";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ");
        try {
            Date date = sdf.parse(datetimeString.replaceAll("Z$", "+0000000"));
            timeString = new SimpleDateFormat("HH:mm:ss").format(date);
        } catch (ParseException pe) {
        }
        return timeString;
    }
}
