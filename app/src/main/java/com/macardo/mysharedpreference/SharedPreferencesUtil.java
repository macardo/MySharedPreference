package com.macardo.mysharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;

public final class SharedPreferencesUtil {
    private static final String FILE_NAME = "macardo";
    private static SharedPreferencesUtil mInstance;

    private SharedPreferencesUtil() {
    }

    //单例模式
    public static SharedPreferencesUtil getInstance() {
        if (mInstance == null) {
            //synchronized 加锁，涉及多线程安全问题
            synchronized (SharedPreferencesUtil.class) {
                if (mInstance == null) {
                    mInstance = new SharedPreferencesUtil();
                }
            }
        }
        return mInstance;
    }

    public void put(Context context, String key, Object value) {
        String type = value.getClass().getSimpleName();
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if ("Integer".equals(type)) {
            editor.putInt(key, (Integer) value);
        } else if ("Boolean".equals(type)) {
            editor.putBoolean(key, (Boolean) value);
        } else if ("String".equals(type)) {
            editor.putString(key, (String) value);
        } else if ("Float".equals(type)) {
            editor.putFloat(key, (Float) value);
        } else if ("Long".equals(type)) {
            editor.putLong(key, (Long) value);
        }
        editor.apply();
    }

    public Object get(Context context,String key,Object defValue){
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        String type = defValue.getClass().getSimpleName();
        if ("Integer".equals(type)) {
            return sharedPreferences.getInt(key,(Integer) defValue);
        } else if ("Boolean".equals(type)) {
            return sharedPreferences.getBoolean(key,(Boolean) defValue);
        } else if ("String".equals(type)) {
            return sharedPreferences.getString(key,(String) defValue);
        } else if ("Float".equals(type)) {
            return sharedPreferences.getFloat(key,(Float) defValue);
        } else if ("Long".equals(type)) {
            return sharedPreferences.getLong(key,(Long) defValue);
        }
        return null;
    }
}
