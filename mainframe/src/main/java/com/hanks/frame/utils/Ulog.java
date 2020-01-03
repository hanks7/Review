package com.hanks.frame.utils;

import android.util.Log;

/**
 * @author 侯建军
 * @data on 2018/1/4 10:40
 * @org www.hopshine.com
 * @function 请填写
 * @email 474664736@qq.com
 */

public class Ulog {
    public static final String TAG = "cc-";

    public static void i(Object content) {
        Log.i(TAG, content + "");
    }

    public static void i(Object tag, Object... content) {
        for (Object o : content) {
            Log.i(TAG + tag, o + "");
        }
    }

    public static void i(Object tag, Object content) {
        Log.i(TAG + tag, content + "");
    }

    public static void e(Object content) {
        Log.e(TAG, content + "");
    }

    public static void e(Object tag, Object content) {
        Log.e(TAG + tag, content + "");
    }


    public static void o(Object tag, Object content) {
        System.out.println(tag + ":" + content);
    }

    public static void o(Object content) {
        System.out.println("result:" + content);
    }

}
