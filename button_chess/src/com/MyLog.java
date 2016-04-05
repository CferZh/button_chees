package com;

import android.util.Log;

/**
 * Created by zxy94400 on 2016/4/5.
 */
public class MyLog {
    public final static boolean DEBUG = true;

    public static void i(String info) {
        Log.i("CHEES",info);
    }

    public static void i(String tag, String info) {
        Log.i(tag,info);
    }
}
