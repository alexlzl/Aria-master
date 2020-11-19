package com.gome.download;

import android.app.Activity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lzl
 * @ describe
 * @ time 2020/11/17 15:48
 */
class DateUtil {
    public static String getFileName(Activity activity) {
        //时间格式化格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return simpleDateFormat.format(new Date());
    }
}
