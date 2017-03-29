package com.jaron.yzy.xreader.test;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * jsoupDemo。
 * 熟悉jsoup的使用，及一些api
 * Created by yzy on 2017/3/29.
 */
public class JsoupTest {

    Document dc;

    public static void main(String[] args) {

    }

    class JsopTestAsync extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                dc = Jsoup.connect("https://www.baidu.com/").timeout(5000).post();//设置需要解析的网页，设置延时,获取完整html源码
                Document document = Jsoup.parse(dc.toString());//通过html源码的字符串
                Elements elementUL = document.getElementsByClass("s-news-rank-content");//通过class获取到需要的内容节点。此处开发人员需要注意，一定要取到唯一的class，如果不唯一就取上一级的，直到取到唯一
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

}
