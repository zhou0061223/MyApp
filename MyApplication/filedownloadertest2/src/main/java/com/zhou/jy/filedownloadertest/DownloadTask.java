package com.zhou.jy.filedownloadertest;

import android.util.Log;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadList;
import com.liulishuo.filedownloader.FileDownloader;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/22.
 */
public class DownloadTask {
    private int id,soFarBytes , totalBytes;
    private String name;
    private String url;
    private String ImageUrl;
    private String Path;
    private BaseDownloadTask  baseDownloadTask;
    private boolean isFinish=false;

    public DownloadTask setPath(String path) {
        Path = path;
        return this;
    }


    public DownloadTask setFinish(boolean finish) {
        isFinish = finish;
        return this;
    }
    public boolean isFinish() {
        return isFinish;
    }
    public DownloadTask setId(int id) {
        this.id = id;
        return this;
    }

    public DownloadTask setSoFarBytes(int soFarBytes) {
        this.soFarBytes = soFarBytes;
        return this;
    }

    public DownloadTask setTotalBytes(int totalBytes) {
        this.totalBytes = totalBytes;
        return this;
    }

    public DownloadTask setName(String name) {
        this.name = name;
        return this;
    }

    public DownloadTask setUrl(String url) {
        this.url = url;
        return this;
    }

    public DownloadTask setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
        return  this;
    }

    public DownloadTask setBaseDownloadTask(BaseDownloadTask baseDownloadTask) {
        this.baseDownloadTask = baseDownloadTask;
        return this;
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

    public BaseDownloadTask getBaseDownloadTask() {
        return baseDownloadTask;
    }
    public String getPath() {

        return Path;
    }
    public  BaseDownloadTask build(){
        this.baseDownloadTask=FileDownloader.getImpl().create(this.getUrl()).setPath(this.getPath());
        return this.baseDownloadTask;
    }


}
