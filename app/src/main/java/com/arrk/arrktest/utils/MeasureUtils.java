package com.arrk.arrktest.utils;

import android.text.TextUtils;

/**
 * Created by abhiholkar on 07/06/2018.
 */

public class MeasureUtils {

    public String convertToMeters(String cms) {
        String val = "";
        if (!TextUtils.isEmpty(cms)) {
            val = String.valueOf((Float.valueOf(cms) / 100));
        }
        return val;
    }
}
