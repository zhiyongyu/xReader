package com.jaron.yzy.xreader.common;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * Created by Jaron Yu on 2017/4/2.
 */
public class MyImageLoaderListener implements ImageLoadingListener {
    @Override
    public void onLoadingStarted(String imageUri, View view) {

    }

    @Override
    public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

    }

    @Override
    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
        if (view instanceof ImageView) {
            ((ImageView) view).setImageBitmap(loadedImage);
        }
    }

    @Override
    public void onLoadingCancelled(String imageUri, View view) {

    }
}
