package com.zhou.jy.filedownloadertest;

import android.app.DownloadManager;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private BaseDownloadTask aa;

    private DownLoadAdapter adapter;


    private int i=0;
    @Bind(R.id.Btn)
     Button btn;

    @Bind(R.id.Pb)
     ProgressBar pb;

    @Bind(R.id.Lv_mian)
    ListView lv_main;


    @OnClick(value = {R.id.Btn,R.id.Btn_test})
    public  void aaclick(View view){
        switch (view.getId()){
            case R.id.Btn :

                if(i==0){

                    aa.start();
                    i=1;
                }else{
                    aa.pause();
                    i=0;
                }



            break;
            case R.id.Btn_test:
                DownLoadManager.getSingleton(this).createTask("http://183.58.18.32/apk.r1.market.hiapk.com/data/upload/marketClient/HiMarket7.0.81_1460024188881.apk?wsiphost=local","HiMarket7.apk","http://img.r1.market.hiapk.com/data/upload/2016/04_06/11/72_72_20160406114509_2825.png");
                DownLoadManager.getSingleton(this).createTask("http://filelx.liqucn.com/upload/2015/anquan/360MobileSafe.apk","360MobileSafe.apk","http://images.liqucn.com/mini/120x120/h021/h05/images201503201118220_info121X121_120x120.jpg");
                DownLoadManager.getSingleton(this).createTask("http://downali.game.uc.cn/wm/14/14/Clash_Royale-1.2.6-kunlun_uc-release_5182542_111552e266c6.apk?sh=10&sf=93959947&vh=3054280d557109c1a0a3a87ba420f5a1&cc=316613636","Clash_Royale-1.2.6.apk","http://images.liqucn.com/mini/120x120/img/h1/h858/img201603290953090_info200X200_120x120.png");
                adapter.notifyDataSetChanged();
            break;


        }





    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DownloadTask downloadTask=new DownloadTask();

        aa = FileDownloader.getImpl().create("http://hezuo.down.xunlei.com/xunlei_hezuo_1/thunder(00008).exe")
                .setPath(Environment.getExternalStorageDirectory().getPath() + "/aa.exe")
                .setListener(new FileDownloadListener() {
                    @Override
                    protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {

                    }

                    @Override
                    protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        Log.i("progress", "a");
                        pb.setMax(totalBytes);
                        pb.setProgress(soFarBytes);
                    }

                    @Override
                    protected void completed(BaseDownloadTask task) {
                        Log.i("completed", task.toString());
                    }

                    @Override
                    protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        Log.i("paused", task.toString());
                    }

                    @Override
                    protected void error(BaseDownloadTask task, Throwable e) {
                        Log.i("error", e.getMessage());
                    }

                    @Override
                    protected void warn(BaseDownloadTask task) {
                        Log.i("warn", task.toString());
                    }
                });



        adapter= new DownLoadAdapter(this, DownLoadManager.getSingleton(this).getDownList());
        lv_main.setAdapter(adapter);


    }

    @Override
    protected void onStart() {
        super.onStart();
        DownLoadManager.getSingleton(this).DownLoad(this);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onPause() {
        super.onPause();
         DownLoadManager.getSingleton(this).DownSave(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
