package com.jaron.yzy.xreader.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 小说简要信息，
 * 就是列表显示时候的数据。
 * Created by yzy on 2017/3/30.
 */
public class BookInfoEntity implements Parcelable {

    private String title;//小说标题
    private String imgUrl;//小说封面图片url
    private String bookUrl;//小说url。可以理解为详情等。
    private String bookDescrib;//小说简介
    private String updatePart;//更新到第几章节
    private String watchToPart;//看到的章节。（这个在书架中的书籍才会有）
    private String isRead;//是否是阅读过了。true：阅读过；false：只是添加到了书架
    private String timeAgo;//多久之前有操作。
    private String author;//作者名字

    public BookInfoEntity() {

    }

    protected BookInfoEntity(Parcel in) {
        title = in.readString();
        imgUrl = in.readString();
        bookUrl = in.readString();
        bookDescrib = in.readString();
        updatePart = in.readString();
        watchToPart = in.readString();
        isRead = in.readString();
        timeAgo = in.readString();
        author = in.readString();
    }

    public static final Creator<BookInfoEntity> CREATOR = new Creator<BookInfoEntity>() {
        @Override
        public BookInfoEntity createFromParcel(Parcel in) {
            return new BookInfoEntity(in);
        }

        @Override
        public BookInfoEntity[] newArray(int size) {
            return new BookInfoEntity[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public String getBookDescrib() {
        return bookDescrib;
    }

    public void setBookDescrib(String bookDescrib) {
        this.bookDescrib = bookDescrib;
    }

    public String getUpdatePart() {
        return updatePart;
    }

    public void setUpdatePart(String updatePart) {
        this.updatePart = updatePart;
    }

    public String getWatchToPart() {
        return watchToPart;
    }

    public void setWatchToPart(String watchToPart) {
        this.watchToPart = watchToPart;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public String getTimeAgo() {
        return timeAgo;
    }

    public void setTimeAgo(String timeAgo) {
        this.timeAgo = timeAgo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(imgUrl);
        dest.writeString(bookUrl);
        dest.writeString(bookDescrib);
        dest.writeString(updatePart);
        dest.writeString(watchToPart);
        dest.writeString(isRead);
        dest.writeString(timeAgo);
        dest.writeString(author);
    }
}
