package com.jaron.yzy.xreader.common.customUI;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaron.yzy.xreader.R;
import com.jaron.yzy.xreader.common.impl.TitleBarInterface;

/**
 * 自定义头部导航条
 * Created by yzy on 2017/3/28.
 */
public class TitleBar extends FrameLayout implements TitleBarInterface {

    ImageView titlebar_back_img;
    TextView titlebar_back_tv;
    TextView titlebar_title_tv;
    TextView titlebar_right_tv;
    ImageView titlebar_right_img;


    public TitleBar(Context context) {
        super(context);
        init();
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        this.setId(R.id.titlebar_top_view);
        this.removeAllViewsInLayout();
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.titlebar_layout, this, false);
        addView(view, new RelativeLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
        titlebar_back_img = (ImageView) view.findViewById(R.id.titlebar_back_img);
        titlebar_back_tv = (TextView) view.findViewById(R.id.titlebar_back_tv);
        titlebar_title_tv = (TextView) view.findViewById(R.id.titlebar_title_tv);
        titlebar_right_tv = (TextView) view.findViewById(R.id.titlebar_right_tv);
        titlebar_right_img = (ImageView) view.findViewById(R.id.titlebar_right_img);
        setListener();
    }

    private void setListener() {
        titlebar_back_img.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (titleBarLeftClickedListener != null) {
                    titleBarLeftClickedListener.onLeftClicked(v);
                }
            }
        });
        titlebar_back_tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (titleBarLeftClickedListener != null) {
                    titleBarLeftClickedListener.onLeftClicked(v);
                }
            }
        });
        titlebar_right_tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (titleBarRightClickedListener != null) {
                    titleBarRightClickedListener.onRightClicked(v);
                }
            }
        });
        titlebar_right_img.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (titleBarRightClickedListener != null) {
                    titleBarRightClickedListener.onRightClicked(v);
                }
            }
        });
    }


    public TitleBarLeftClickedListener getTitleBarLeftClickedListener() {
        return titleBarLeftClickedListener;
    }

    public void setTitleBarLeftClickedListener(TitleBarLeftClickedListener titleBarLeftClickedListener) {
        this.titleBarLeftClickedListener = titleBarLeftClickedListener;
    }

    public TitleBarRightClickedListener getTitleBarRightClickedListener() {
        return titleBarRightClickedListener;
    }

    public void setTitleBarRightClickedListener(TitleBarRightClickedListener titleBarRightClickedListener) {
        this.titleBarRightClickedListener = titleBarRightClickedListener;
    }

    private TitleBarLeftClickedListener titleBarLeftClickedListener;
    private TitleBarRightClickedListener titleBarRightClickedListener;

    @Override
    public void setTitle(CharSequence title) {
        titlebar_title_tv.setText(title);
    }

    @Override
    public void setBackground(int backgroundRes) {
        this.setBackground(backgroundRes);
    }

    @Override
    public void setLeftImg(int leftImgRes) {
        titlebar_back_img.setVisibility(View.VISIBLE);
        titlebar_back_tv.setVisibility(View.GONE);
        titlebar_back_img.setImageResource(leftImgRes);
    }

    @Override
    public void setLeftText(CharSequence leftText) {
        titlebar_back_img.setVisibility(View.GONE);
        titlebar_back_tv.setVisibility(View.VISIBLE);
        titlebar_back_tv.setText(leftText);
    }

    @Override
    public void setRightImg(int rightImgRes) {
        titlebar_right_img.setVisibility(View.VISIBLE);
        titlebar_right_tv.setVisibility(View.GONE);
        titlebar_right_img.setImageResource(rightImgRes);
    }

    @Override
    public void setRightText(CharSequence rightText) {
        titlebar_right_img.setVisibility(View.GONE);
        titlebar_right_tv.setVisibility(View.VISIBLE);
        titlebar_right_tv.setText(rightText);
    }

    @Override
    public void setOnlyTitle() {
        titlebar_right_img.setVisibility(View.GONE);
        titlebar_right_tv.setVisibility(View.GONE);
        titlebar_back_tv.setVisibility(View.GONE);
        titlebar_back_img.setVisibility(View.GONE);
    }

    @Override
    public void setOnlyBackImg(int leftImgRes) {
        titlebar_back_img.setVisibility(View.VISIBLE);
        titlebar_back_tv.setVisibility(View.GONE);
        titlebar_right_img.setVisibility(View.GONE);
        titlebar_title_tv.setVisibility(View.GONE);
        titlebar_back_img.setVisibility(View.GONE);
        titlebar_back_img.setImageResource(leftImgRes);
    }

    @Override
    public void setTitleSize(float size) {
        titlebar_title_tv.setTextSize(size);
    }

    @Override
    public void setTitleColor(int color) {
        titlebar_title_tv.setTextColor(color);
    }

    @Override
    public void setLeftTextSize(float size) {
        titlebar_back_tv.setTextSize(size);
    }

    @Override
    public void setLeftTextColor(int color, int type) {
        titlebar_back_tv.setTextColor(color);
    }

    @Override
    public void setRightTextSize(float size) {
        titlebar_right_tv.setTextSize(size);
    }

    @Override
    public void setRightTextColor(int color, int type) {
        titlebar_right_tv.setTextColor(color);
    }

    @Override
    public void setRightTextBackground(int backRes) {
        titlebar_right_tv.setBackgroundResource(backRes);
    }

    @Override
    public TextView getRightTextView() {
        return titlebar_right_tv;
    }

    @Override
    public ImageView getRightImageView() {
        return titlebar_right_img;
    }

    @Override
    public ImageView getLeftImageView() {
        return titlebar_back_img;
    }

    public interface TitleBarRightClickedListener {
        void onRightClicked(View v);
    }

    public interface TitleBarLeftClickedListener {
        void onLeftClicked(View v);
    }

}
