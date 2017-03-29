package com.jaron.yzy.xreader.test;

import android.app.Activity;
import android.os.Bundle;

import com.jaron.yzy.xreader.R;

import org.jsoup.Jsoup;

/**
 * Created by Jaron Yu on 2017/3/29.
 */
public class JsoupTestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JsoupTest jsoupTest = new JsoupTest();
        jsoupTest.getHtmlInfo();
    }
}
