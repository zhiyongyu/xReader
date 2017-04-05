package com.jaron.yzy.xreader.application;

import android.app.Application;

import com.jaron.yzy.xreader.utils.CommonVariable;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Jaron Yu on 2017/4/2.
 */
public class XreaderApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //创建默认的ImageLoader配置参数
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration
                .createDefault(this);
        //Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(configuration);
        CommonVariable.putString(this, CommonVariable.BOOKIMGURL_COMMON, "http://www.biquge.com/files/article/image/");
    }
}
