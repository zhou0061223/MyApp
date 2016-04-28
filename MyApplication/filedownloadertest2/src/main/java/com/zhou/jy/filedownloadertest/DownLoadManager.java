package com.zhou.jy.filedownloadertest;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/25.
 */
public class DownLoadManager {


    private static DownLoadManager downLoadManager;
    public static  List<DownloadTask>  DownList=new ArrayList<DownloadTask>();
    private static String  PATH=Environment.getExternalStorageDirectory().getPath();


    public static DownLoadManager getSingleton() {
        if(downLoadManager == null){
            downLoadManager = new DownLoadManager();
        }
        return downLoadManager;
    }


    public boolean  createTask(DownloadTask downloadTask){
      BaseDownloadTask  task= FileDownloader.getImpl().create(downloadTask.getUrl()).setPath( PATH +"/"+downloadTask.getName());

        for(DownloadTask downloadTask1:DownList){
            if(task.getDownloadId()==downloadTask1.getId()){
                return false;
            }
        }
        downloadTask.setPath(task.getPath()).setId(task.getDownloadId()).setBaseDownloadTask(task);
        DownList.add(downloadTask);

        return  true;
    }

    public boolean   createTask(String url, String name,String ImageUrl){
        DownloadTask downloadTask=new DownloadTask()
                .setUrl(url)
                .setName(name)
                .setImageUrl(ImageUrl)
                .setTotalBytes(0)
                .setSoFarBytes(0)
                .setFinish(false);
        return createTask(downloadTask);
    }

    public   void init(Context context){
        DownList=new ArrayList<DownloadTask>();

        ListToSting<DownloadData> listToSting=new ListToSting<>();
        List<DownloadData> datas=new ArrayList<DownloadData>();
        String str=PreferenceTool.LoadData("test","down",context);
        if (str!=null && !str.equals("error")){

            try {
                datas=listToSting.StringToMybeansList(str);
                if(datas.size()<=0){
                    return;
                }
                for(DownloadData downloadData:datas){
                    if(downloadData!=null) {
                        DownloadTask downloadTask=new DownloadTask()
                                .setUrl(downloadData.getUrl())
                                .setName(downloadData.getName())
                                .setImageUrl(downloadData.getImageUrl())
                                .setTotalBytes(downloadData.getTotalBytes())
                                .setSoFarBytes(downloadData.getSoFarBytes())
                                .setFinish(downloadData.isFinish());
                        DownLoadManager.getSingleton().createTask(downloadTask);
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


    }


    public   void DownSave(Context context){
        ListToSting<DownloadData> listToSting=new ListToSting<>();
        List<DownloadData> datas=new ArrayList<DownloadData>();
        for(DownloadTask downloadTask: DownLoadManager.DownList){
            if(downloadTask!=null) {
                DownloadData downloadData=new DownloadData();
                downloadData.setImageUrl(downloadTask.getImageUrl());
                downloadData.setSoFarBytes(downloadTask.getSoFarBytes());
                downloadData.setTotalBytes(downloadTask.getTotalBytes());
                downloadData.setUrl(downloadTask.getUrl());
                downloadData.setName(downloadTask.getName());
                downloadData.setFinish(downloadTask.isFinish());
                downloadData.setPath(downloadTask.getPath());
                datas.add(downloadData);
            }
        }
        String str="";
        try {
            if(datas.size()<=0) return;
            str= listToSting.MybeansListToString(datas);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PreferenceTool.SaveData("test","down",str,context);

    }


}
