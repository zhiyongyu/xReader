package com.jaron.yzy.xreader.common.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 所有Activity的基类
 * Created by yzy on 2017/3/28.
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        setView();
    }

    @Override
    public void setContentView(int layoutResID) {
        View view = LayoutInflater.from(this).inflate(layoutResID,null);
        setCustomLayout(view,null);
        super.setContentView(layoutResID);
    }

    private void setCustomLayout(View view, ViewGroup.LayoutParams params) {

    }

    /**
     * 初始化控件
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 将数据填充到View中。
     */
    public abstract void setView();

}
