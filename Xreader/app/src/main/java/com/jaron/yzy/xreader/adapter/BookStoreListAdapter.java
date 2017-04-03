package com.jaron.yzy.xreader.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaron.yzy.xreader.R;
import com.jaron.yzy.xreader.common.MyImageLoaderListener;
import com.jaron.yzy.xreader.entity.BookInfoEntity;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;

/**
 * 书城适配器
 * Created by Jaron Yu on 2017/4/2.
 */
public class BookStoreListAdapter extends BaseAdapter {

    Context context;
    List<BookInfoEntity> bookInfoEntities= new ArrayList<>();
    ViewHolder viewHolder;
    DisplayImageOptions options;
    MyImageLoaderListener myImageLoaderListener = new MyImageLoaderListener();

    public BookStoreListAdapter(Context context, List<BookInfoEntity> bookInfoEntities) {
        this.context = context;
        this.bookInfoEntities = bookInfoEntities;
        options = new DisplayImageOptions.Builder().showImageOnLoading(R.mipmap.ic_launcher) // resource or drawable
                .showImageForEmptyUri(R.mipmap.ic_launcher) // resource or drawable
                .showImageOnFail(R.mipmap.ic_launcher) // resource or drawable
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .displayer(new SimpleBitmapDisplayer())
                .build();
    }

    @Override
    public int getCount() {
        return bookInfoEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return bookInfoEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.bookstore_fragment_item_layout, null);
            viewHolder = new ViewHolder(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        BookInfoEntity bookInfoEntity = bookInfoEntities.get(position);
        if (bookInfoEntity != null) {
            ImageLoader.getInstance().displayImage(bookInfoEntity.getImgUrl(), viewHolder.bookstore_fragment_item_img, options, myImageLoaderListener);
            viewHolder.bookstore_fragment_item_author.setText(bookInfoEntity.getAuthor());
            viewHolder.bookstore_fragment_item_title.setText(bookInfoEntity.getTitle());
            if (!TextUtils.isEmpty(bookInfoEntity.getBookDescrib())) {
                if (bookInfoEntity.getBookDescrib().length() > 40) {
                    viewHolder.bookstore_fragment_item_desc.setText(bookInfoEntity.getBookDescrib().substring(0, 40) + "...");
                } else {
                    viewHolder.bookstore_fragment_item_desc.setText(bookInfoEntity.getBookDescrib());
                }
            }

        }

        return convertView;
    }

    class ViewHolder {
        ImageView bookstore_fragment_item_img;
        TextView bookstore_fragment_item_title;
        TextView bookstore_fragment_item_author;
        TextView bookstore_fragment_item_desc;

        public ViewHolder(View view) {
            bookstore_fragment_item_img = (ImageView) view.findViewById(R.id.bookstore_fragment_item_img);
            bookstore_fragment_item_title = (TextView) view.findViewById(R.id.bookstore_fragment_item_title);
            bookstore_fragment_item_author = (TextView) view.findViewById(R.id.bookstore_fragment_item_author);
            bookstore_fragment_item_desc = (TextView) view.findViewById(R.id.bookstore_fragment_item_desc);
            view.setTag(this);
        }

    }

}
