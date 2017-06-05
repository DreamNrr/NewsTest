package com.example.wzh.newstest.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by WZH on 2017/6/5.
 */

public class CacheUtils {
    public static void putBoolean(Context context, String key, boolean b){
        SharedPreferences sp = context.getSharedPreferences("atguigu",Context.MODE_PRIVATE);
        sp.edit().putBoolean(key,b).commit();
    }
    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences("atguigu",Context.MODE_PRIVATE);
        return sp.getBoolean(key,false);
    }
}
