package com.zhou.jy.filedownloadertest;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;

/**
 * Created by Administrator on 2016/4/25.
 */
public class DownloadListener extends FileDownloadListener{



    private DownLoadAdapter.FileViewHolder fileViewHolder;
    private int position;
    private Context context;


    public  DownloadListener(DownLoadAdapter.FileViewHolder fileViewHolder, int  position, Context context){
        this.fileViewHolder=fileViewHolder;
        this.position=position;
        this.context=context;
    }
    @Override
    protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {

    }

    @Override
    protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
        fileViewHolder.updateDownloading(soFarBytes,totalBytes ,task.getSpeed());
        DownloadTask downloadTask = DownLoadManager.getSingleton(context).getDownListPosition(position);
        downloadTask.setTotalBytes(totalBytes);
        downloadTask.setSoFarBytes(soFarBytes);
        DownLoadManager.getSingleton(context).setDownListPosition(position,downloadTask);
    }

    @Override
    protected void completed(BaseDownloadTask task) {
        fileViewHolder.mBtnOperate.setText("打开");
        fileViewHolder.mNumberProgressBar.setVisibility(View.GONE);
        fileViewHolder.mTvDownloadSpeed.setVisibility(View.GONE);
        DownloadTask downloadTask = DownLoadManager.getSingleton(context).getDownListPosition(position);
        downloadTask.setFinish(true);
        DownLoadManager.getSingleton(context).setDownListPosition(position,downloadTask);
    }

    @Override
    protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {

    }

    @Override
    protected void error(BaseDownloadTask task, Throwable e) {

    }

    @Override
    protected void warn(BaseDownloadTask task) {

    }
}
