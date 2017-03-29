package com.jaron.yzy.xreader.activity;

import com.jaron.yzy.xreader.R;
import com.jaron.yzy.xreader.common.activity.BaseActivity;

/**
 * 主页
 * 此处暂时做简单布局。
 * 侧滑菜单栏。
 * 主页list列表。
 * 头部应该有几部排行榜小说，推荐给用户。
 * 顶部导航条包括了title，菜单栏按钮，右侧搜索按钮（此处搜索按钮就是一个入口，跳转至搜索页面，搜索的是书城中的书籍）
 * 底部暂时只有两个栏目，一个书架，一个书城。书架表示缓存到本地中的书，书城则是在线的网络书籍。
 * 加入到书架功能这边（思路暂定）
 * 数据将存到数据库中。
 * Created by yzy on 2017/3/28.
 */
public class HomeActivity extends BaseActivity {
    @Override
    public void initView() {
        setContentView(R.layout.home_layout);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setView() {

    }
}
