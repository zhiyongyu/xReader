package com.jaron.yzy.xreader.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jaron.yzy.xreader.R;
import com.jaron.yzy.xreader.adapter.BookStoreListAdapter;
import com.jaron.yzy.xreader.entity.BookInfoEntity;
import com.jaron.yzy.xreader.utils.FileUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.os.Handler;

/**
 * 书城 界面
 * Created by Jaron Yu on 2017/4/2.
 */
public class BookStoreFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener {

    ListView bookstore_fragment_list;
    SwipeRefreshLayout bookstore_fragment_swipe;
    BookStoreListAdapter bookStoreListAdapter;
    Document dc;
    List<BookInfoEntity> bookInfoEntities = new ArrayList<>();
    Thread thread;
    private final int JSOUP_SUCCESS = 1;
    private final int JSOUP_FAIL = 2;
    private final String BOOKSITE_URL = "http://www.biquge.tw/";

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == JSOUP_SUCCESS) {
                bookStoreListAdapter = new BookStoreListAdapter(getActivity(), bookInfoEntities);
                bookstore_fragment_list.setAdapter(bookStoreListAdapter);
                bookstore_fragment_swipe.setRefreshing(false);
            } else {
                bookstore_fragment_swipe.setRefreshing(false);
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bookstore_fragment_layout, null);
        initView(view);
//        initData();
        return view;
    }

    private void initData() {
    }

    @Override
    public void onRefresh() {
        thread = new Thread(runnable);
        thread.start();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        FileUtils.createFile(FileUtils.FILE_DIRECTORY, bookInfoEntities.get(position).getTitle() + ".txt");
        // TODO: 2017/4/5 跳转到小说详情
        /**
         * 小说分页思路，
         * 首先需要根据<br>标签 将段落抽离出来，获取到段落集合，
         * 再将每个段落通过Paint方法计算出一行可以显示多少个字，以此完成分行，并将分行保存到list集合中。
         * 数据库中需要保存一篇文章的行的集合，当前页数。起始的字节，结束的字节。
         */
    }


    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                dc = Jsoup.connect(BOOKSITE_URL).post();//设置需要解析的网页，设置延时,获取完整html源码
                Document document = Jsoup.parse(dc.toString());//通过html源码的字符串
                Element elementUL = document.getElementById("hotcontent");//通过class获取到需要的内容节点队列。此处开发人员需要注意，一定要取到唯一的class，如果不唯一就取上一级的，直到取到唯一
//                Document documentLi = Jsoup.parse(elementUL.toString());//通过队列拿到内容
                Elements elementsLi = elementUL.getElementsByClass("l");//根据li这个标签，取到所有的li节点。
                Document documents = Jsoup.parse(elementsLi.toString());
                Elements elements = documents.getElementsByClass("item");

                for (Element elementLi : elements) {
                    String imgUrl = BOOKSITE_URL + elementLi.getElementsByClass("image").get(0).getElementsByTag("img").attr("src");
                    String title = elementLi.getElementsByClass("image").get(0).getElementsByTag("img").attr("alt");
                    String author = elementLi.getElementsByTag("dl").get(0).getElementsByTag("span").text();
                    String bookUrl = BOOKSITE_URL + elementLi.getElementsByClass("image").get(0).getElementsByTag("a").attr("href");
                    String bookDescrib = elementLi.getElementsByTag("dd").get(0).text();
                    BookInfoEntity bookInfoEntity = new BookInfoEntity();
                    bookInfoEntity.setTitle(title);
                    bookInfoEntity.setAuthor(author);
                    bookInfoEntity.setBookUrl(bookUrl);
                    bookInfoEntity.setBookDescrib(bookDescrib);
                    bookInfoEntity.setImgUrl(imgUrl);
                    bookInfoEntities.add(bookInfoEntity);

                }
                Message msg = new Message();
                msg.what = JSOUP_SUCCESS;
                handler.sendMessage(msg);
            } catch (IOException e) {
                e.printStackTrace();
                Message msg = new Message();
                msg.what = JSOUP_FAIL;
                handler.sendMessage(msg);
            }
        }
    };

    private void initView(View view) {
        bookstore_fragment_list = (ListView) view.findViewById(R.id.bookstore_fragment_list);
        bookstore_fragment_swipe = (SwipeRefreshLayout) view.findViewById(R.id.bookstore_fragment_swipe);
        bookstore_fragment_list.setOnItemClickListener(this);
        bookstore_fragment_swipe.setColorSchemeColors(Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN);
        bookstore_fragment_swipe.setRefreshing(true);
        bookstore_fragment_swipe.setOnRefreshListener(this);
        bookstore_fragment_swipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
//        bookstore_fragment_swipe.post(runnable);
        onRefresh();
    }
}
