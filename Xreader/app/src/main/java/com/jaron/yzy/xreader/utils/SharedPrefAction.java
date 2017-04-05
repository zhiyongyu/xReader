package com.jaron.yzy.xreader.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences封装
 * Created by Jaron Yu on 2017/4/5.
 */
public class SharedPrefAction {
    private SharedPreferences Obj = null;

    public void open(Context ct, String fileName) {
        Obj = ct.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    public boolean getBoolean(String key, boolean value) {
        if (Obj != null) {
            return Obj.getBoolean(key, value);
        }
        return false;
    }

    public boolean putBoolean(String key, boolean value) {
        if (Obj != null) {
            SharedPreferences.Editor editor = Obj.edit();
            editor.putBoolean(key, value);
            return editor.commit();
        }
        return false;
    }

    public int getInt(String key, int value) {
        if (Obj != null) {
            return Obj.getInt(key, value);
        }
        return 0;
    }

    public boolean putInt(String key, int value) {
        if (Obj != null) {
            SharedPreferences.Editor editor = Obj.edit();
            editor.putInt(key, value);
            return editor.commit();
        }
        return false;
    }

    public String getString(String key, String value) {
        if (Obj != null) {
            return Obj.getString(key, value);
        }
        return null;
    }

    public boolean putString(String key, String value) {
        if (Obj != null) {
            SharedPreferences.Editor editor = Obj.edit();
            editor.putString(key, value);
            return editor.commit();
        }
        return false;
    }
}
