package com.jaron.yzy.xreader.entity;

import java.util.List;

/**
 * 分页实体类
 * Created by Jaron Yu on 2017/4/5.
 */
public class PageEntity {
    private int firstbyetposition;
    private int lastbyteposition;
    private int pageindex;
    private List<String> linesData;

    public int getFirstbyetposition() {
        return firstbyetposition;
    }

    public void setFirstbyetposition(int firstbyetposition) {
        this.firstbyetposition = firstbyetposition;
    }

    public int getLastbyteposition() {
        return lastbyteposition;
    }

    public void setLastbyteposition(int lastbyteposition) {
        this.lastbyteposition = lastbyteposition;
    }

    public int getPageindex() {
        return pageindex;
    }

    public void setPageindex(int pageindex) {
        this.pageindex = pageindex;
    }

    public List<String> getLinesData() {
        return linesData;
    }

    public void setLinesData(List<String> linesData) {
        this.linesData = linesData;
    }
}
