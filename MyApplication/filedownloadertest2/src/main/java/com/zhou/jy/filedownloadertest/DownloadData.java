package com.zhou.jy.filedownloadertest;

import com.liulishuo.filedownloader.BaseDownloadTask;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/22.
 */
public class DownloadData implements Serializable{
    private int id,soFarBytes , totalBytes;
    private String name;
    private String url;
    private String ImageUrl;
    private String Path;
    private boolean isFinish;

    public void setPath(String path) {
        Path = path;
    }

    public String getPath() {

        return Path;
    }
    public void setFinish(boolean finish) {
        isFinish = finish;
    }
    public boolean isFinish() {
        return isFinish;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setSoFarBytes(int soFarBytes) {
        this.soFarBytes = soFarBytes;
    }

    public void setTotalBytes(int totalBytes) {
        this.totalBytes = totalBytes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }



    public int getId() {

        return id;
    }

    public int getSoFarBytes() {
        return soFarBytes;
    }

    public int getTotalBytes() {
        return totalBytes;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return ImageUrl;
    }



}
