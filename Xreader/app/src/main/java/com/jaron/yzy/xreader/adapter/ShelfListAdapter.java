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
import com.jaron.yzy.xreader.entity.BookInfoEntity;

import java.util.List;

/**
 * 书架 适配器
 * Created by yzy on 2017/3/31.
 */
public class ShelfListAdapter extends BaseAdapter {

    private Context context;
    ViewHolder viewHolder;
    private List<BookInfoEntity> bookInfoEntities;

    public ShelfListAdapter(Context context, List<BookInfoEntity> bookInfoEntities) {
        this.context = context;
        this.bookInfoEntities = bookInfoEntities;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.shelf_fragment_item, null);
            viewHolder = new ViewHolder(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        BookInfoEntity bookInfoEntity = bookInfoEntities.get(position);
        if (bookInfoEntity != null) {
            viewHolder.shelf_fragment_item_title.setText(bookInfoEntity.getTitle());
            if (!TextUtils.isEmpty(bookInfoEntity.getWatchToPart())) {
                viewHolder.shelf_fragment_item_nowpart.setText(bookInfoEntity.getWatchToPart());
            }
            if (!TextUtils.isEmpty(bookInfoEntity.getUpdatePart())) {
                viewHolder.shelf_fragment_item_updatepart.setText(bookInfoEntity.getUpdatePart());
            }
            if (!TextUtils.isEmpty(bookInfoEntity.getIsRead())) {
                if (bookInfoEntity.getIsRead().equals("true")) {
                    viewHolder.shelf_fragment_item_isread.setText("阅读");
                } else {
                    viewHolder.shelf_fragment_item_isread.setText("加入");
                }
            }
            viewHolder.shelf_fragment_item_timeago.setText(bookInfoEntity.getTimeAgo());
        }
        return convertView;
    }

    class ViewHolder {

        ImageView shelf_fragment_item_img;
        TextView shelf_fragment_item_title;
        TextView shelf_fragment_item_updatepart;
        TextView shelf_fragment_item_nowpart;
        TextView shelf_fragment_item_isread;
        TextView shelf_fragment_item_timeago;

        public ViewHolder(View view) {
            shelf_fragment_item_img = (ImageView) view.findViewById(R.id.shelf_fragment_item_img);
            shelf_fragment_item_title = (TextView) view.findViewById(R.id.shelf_fragment_item_title);
            shelf_fragment_item_updatepart = (TextView) view.findViewById(R.id.shelf_fragment_item_updatepart);
            shelf_fragment_item_nowpart = (TextView) view.findViewById(R.id.shelf_fragment_item_nowpart);
            shelf_fragment_item_isread = (TextView) view.findViewById(R.id.shelf_fragment_item_isread);
            shelf_fragment_item_timeago = (TextView) view.findViewById(R.id.shelf_fragment_item_timeago);
            view.setTag(this);
        }
    }
}
