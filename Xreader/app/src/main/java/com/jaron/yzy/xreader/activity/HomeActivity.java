package com.jaron.yzy.xreader.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.jaron.yzy.xreader.R;
import com.jaron.yzy.xreader.common.activity.BaseActivity;
import com.jaron.yzy.xreader.fragment.BookStoreFragment;
import com.jaron.yzy.xreader.fragment.ShelfFragment;

/**
 * 主页
 * 此处暂时做简单布局。
 * 侧滑菜单栏。
 * 主页list列表。
 * 头部应该有几部排行榜小说，推荐给用户。
 * 顶部导航条包括了title，菜单栏按钮，右侧搜索按钮（此处搜索按钮就是一个入口，跳转至搜索页面，搜索的是书城中的书籍）
 * 底部暂时只有两个栏目，一个书架，一个书城。书架表示缓存到本地中的书，书城则是在线的网络书籍。
 * 加入到书架功能这边（思路暂定）
 * 缓存的概念就是将文本写入到本地文件中。
 * 通过Canvars 来绘制小说内容到页面。
 * 数据将存到数据库中。
 * Created by yzy on 2017/3/28.
 */
public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private TextView home_bottom_item1;
    private TextView home_bottom_item2;
    BookStoreFragment bookStoreFragment;
    ShelfFragment shelfFragment;
    FragmentManager fm = getFragmentManager();

    @Override
    public String getTitleText() {
        return "XReader";
    }

    @Override
    public void initView() {
        setContentView(R.layout.home_layout);
        getTitleBar().setLeftText("菜单");
        getTitleBar().setRightText("搜索");
        home_bottom_item1 = (TextView) findViewById(R.id.home_bottom_item1);
        home_bottom_item2 = (TextView) findViewById(R.id.home_bottom_item2);
        home_bottom_item1.setOnClickListener(this);
        home_bottom_item2.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setView() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_bottom_item1:
                // TODO: 2017/3/31 书架相关
                // 开启Fragment事务
                FragmentTransaction transaction = fm.beginTransaction();
                shelfFragment = new ShelfFragment();
                transaction.replace(R.id.home_content_layout, shelfFragment).commit();
                break;
            case R.id.home_bottom_item2:
                // TODO: 2017/3/31 书城相关
                // 开启Fragment事务
                FragmentTransaction transaction1 = fm.beginTransaction();
                bookStoreFragment = new BookStoreFragment();
                transaction1.replace(R.id.home_content_layout, bookStoreFragment).commit();
                break;
        }
    }
}
