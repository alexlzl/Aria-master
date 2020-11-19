package com.gome.download;


public class ButtonUtils {

    /**
     * 两次点击按钮之间的点击间隔不能少于700毫秒
     */
    private static final int MIN_CLICK_DELAY_TIME = 700;
    private static long lastClickTime;

    public static boolean isFastClick() {
        boolean flag = false;
        long curClickTime = System.currentTimeMillis();
        if ((curClickTime - lastClickTime) >= MIN_CLICK_DELAY_TIME) {
            flag = true;
        }
        lastClickTime = curClickTime;
        return flag;
    }
}
