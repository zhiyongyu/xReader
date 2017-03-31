package com.jaron.yzy.xreader.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaron.yzy.xreader.R;

/**
 * 书架的Fragment
 * Created by yzy on 2017/3/31.
 */
public class ShelfFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView shelf_fragment_list;
    private RelativeLayout shelf_fragment_none_layout;
    private TextView shelf_fragment_none_message1;
    private TextView shelf_fragment_none_message2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shelf_fragment_layout, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        shelf_fragment_list = (ListView) view.findViewById(R.id.shelf_fragment_list);
        shelf_fragment_none_layout = (RelativeLayout) view.findViewById(R.id.shelf_fragment_none_layout);
        shelf_fragment_none_message1 = (TextView) view.findViewById(R.id.shelf_fragment_none_message1);
        shelf_fragment_none_message2 = (TextView) view.findViewById(R.id.shelf_fragment_none_message2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shelf_fragment_none_message2:
                // TODO: 2017/3/31 跳转书城
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
