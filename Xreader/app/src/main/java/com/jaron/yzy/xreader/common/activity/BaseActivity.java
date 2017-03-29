package com.jaron.yzy.xreader.common.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;

import com.jaron.yzy.xreader.R;
import com.jaron.yzy.xreader.common.customUI.TitleBar;
import com.jaron.yzy.xreader.utils.ViewUtils;

/**
 * 所有Activity的基类
 * Created by yzy on 2017/3/28.
 */
public abstract class BaseActivity extends Activity {

    private Activity mActivity;
    private LinearLayout mThemeFrameLayout;
    private TitleBar titleLayout;
    private final static int CUSTOM_LAYOUT_WEIGHT = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        initView();
        initData();
        setView();
    }

    @Override
    public void setContentView(int layoutResID) {
        View view = LayoutInflater.from(this).inflate(layoutResID, null);
        setCustomLayout(view, null);
        super.setContentView(layoutResID);
    }

    public TitleBar getTitleBar() {
        return titleLayout;
    }

    /**
     * 设置是否显示titleBar
     *
     * @return true ： 显示; false: 不显示
     */
    public boolean setTitleBar() {
        return true;
    }

    private void setCustomLayout(View view, ViewGroup.LayoutParams params) {
        mThemeFrameLayout = new LinearLayout(mActivity);
        mThemeFrameLayout.setOrientation(LinearLayout.VERTICAL);
        titleLayout = new TitleBar(mActivity);

        if (setTitleBar()) {
            LinearLayout.LayoutParams titleLlp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    ViewUtils.dip2px(mActivity, 48));

            mThemeFrameLayout.addView(titleLayout, titleLlp);


            titleLayout.setLeftImg(R.drawable.actionbar_back_icon_svg);
            titleLayout.setTitleBarLeftClickedListener(tbLeftClick);

            initThemeFrame();
        }
        if (params == null) {
            LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0,
                    CUSTOM_LAYOUT_WEIGHT);
            mThemeFrameLayout.addView(view, llp);
        } else {
            mThemeFrameLayout.addView(view, params);
        }

        super.setContentView(mThemeFrameLayout);

    }


    protected void initThemeFrame() {

        titleLayout.setTitle(getTitleText());
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(200);
        titleLayout.titlebar_title_tv.startAnimation(anim);
    }

    /**
     * 设置TitleBar的title
     *
     * @return
     */
    public String getTitleText() {
        return "";
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


    TitleBar.TitleBarLeftClickedListener tbLeftClick = new TitleBar.TitleBarLeftClickedListener() {
        @Override
        public void onLeftClicked(View v) {
            backClick(v);
        }
    };

    public void backClick(View v) {
        finish();
    }


}
