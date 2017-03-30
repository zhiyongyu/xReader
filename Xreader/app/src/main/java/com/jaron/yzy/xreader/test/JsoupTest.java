package com.jaron.yzy.xreader.test;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * jsoupDemo。
 * 熟悉jsoup的使用，及一些api
 * Created by yzy on 2017/3/29.
 */
public class JsoupTest {

    Document dc;
    List<Map<String, String>> newsList = new ArrayList<>();

    public void getHtmlInfo(){
        JsopTestAsync jsopTestAsync=new JsopTestAsync();
        jsopTestAsync.execute();
    }

    public class JsopTestAsync extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                dc = Jsoup.connect("http://www.pp122.com/").timeout(1000).post();//设置需要解析的网页，设置延时,获取完整html源码
                Document document = Jsoup.parse(dc.toString());//通过html源码的字符串
                Elements elementUL = document.body().getElementsByClass("focus_pictext");//通过class获取到需要的内容节点队列。此处开发人员需要注意，一定要取到唯一的class，如果不唯一就取上一级的，直到取到唯一
                Document documentLi = Jsoup.parse(elementUL.toString());//通过队列拿到内容
                Elements elementsLi = documentLi.getElementsByClass("pictext");//根据li这个标签，取到所有的li节点。

                for (Element elementLi : elementsLi) {
                    String title = elementLi.getElementsByClass("pic").get(0).getElementsByTag("a").attr("title");//根据节点来去相应的内容，然后因为这个节点只有一个内容，所有取index为0的，然后获取a标签下的title的内容。
                    String href = elementLi.getElementsByClass("pic").get(0).getElementsByTag("a").attr("href");//通过attr来获取href的内容。
                    Map<String, String> map = new HashMap<>();
                    map.put("title", title);
                    map.put("href", href);
                    newsList.add(map);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            for (int i = 0; i < newsList.size(); i++) {
                Log.e("title" + i, newsList.get(i).get("title"));
                Log.e("href" + i, newsList.get(i).get("href"));
            }
        }
    }

}
