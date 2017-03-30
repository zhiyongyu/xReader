package com.jaron.yzy.xreader.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 小说目录
 * 包括小说章节链接。
 * 小说章节标题等
 * Created by yzy on 2017/3/30.
 */
public class BookDirectoriesEntity implements Parcelable {
    private String directoriesTitle;//章节名称
    private String directoriesUrl;//章节链接

    protected BookDirectoriesEntity(Parcel in) {
        directoriesTitle = in.readString();
        directoriesUrl = in.readString();
    }

    public static final Creator<BookDirectoriesEntity> CREATOR = new Creator<BookDirectoriesEntity>() {
        @Override
        public BookDirectoriesEntity createFromParcel(Parcel in) {
            return new BookDirectoriesEntity(in);
        }

        @Override
        public BookDirectoriesEntity[] newArray(int size) {
            return new BookDirectoriesEntity[size];
        }
    };

    public String getDirectoriesTitle() {
        return directoriesTitle;
    }

    public void setDirectoriesTitle(String directoriesTitle) {
        this.directoriesTitle = directoriesTitle;
    }

    public String getDirectoriesUrl() {
        return directoriesUrl;
    }

    public void setDirectoriesUrl(String directoriesUrl) {
        this.directoriesUrl = directoriesUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(directoriesTitle);
        dest.writeString(directoriesUrl);
    }
}
