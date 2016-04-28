package com.zhou.jy.filedownloadertest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.squareup.picasso.Picasso;


import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/4/25.
 */
public class DownLoadAdapter extends CommonBaseAdapter<DownLoadAdapter.FileViewHolder,DownloadTask>{



    public DownLoadAdapter(Context context, List<DownloadTask> list) {
        super(context, list);
    }


    @Override
    public FileViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = inflate(R.layout.download_item, parent);
        FileViewHolder holder = new FileViewHolder(view);
        holder.mBtnOperate.setOnClickListener(taskActionOnClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(FileViewHolder holder, int position) {
        holder.mTvTitle.setText(mList.get(position).getName());
        holder.setDownloadId(position);
        holder.mBtnOperate.setTag(holder);
        if(mList.get(position).isFinish() && new File(mList.get(position).getPath()).exists()){
            holder.mBtnOperate.setText("打开");
            holder.mNumberProgressBar.setVisibility(View.GONE);
            holder.mTvDownloadSpeed.setVisibility(View.GONE);
        }else if(mList.get(position).isFinish() && !new File(mList.get(position).getPath()).exists()){
            holder.mBtnOperate.setText("开始");
            holder.mNumberProgressBar.setVisibility(View.VISIBLE);
            holder.mTvDownloadSpeed.setVisibility(View.VISIBLE);
            holder.mNumberProgressBar.setMax(mList.get(position).getTotalBytes());
            holder.mNumberProgressBar.setProgress(mList.get(position).getSoFarBytes());
            DownLoadManager.DownList.get(position).setFinish(false);
            holder.updateDownloading(0,0,0);

        } else {
            holder.mBtnOperate.setText("继续");
            holder.mNumberProgressBar.setVisibility(View.VISIBLE);
            holder.mTvDownloadSpeed.setVisibility(View.VISIBLE);
            holder.mNumberProgressBar.setMax(mList.get(position).getTotalBytes());
            holder.mNumberProgressBar.setProgress(mList.get(position).getSoFarBytes());
            holder.updateDownloading(mList.get(position).getSoFarBytes(),mList.get(position).getTotalBytes(),0);
        }
        Picasso.with(mContext)
                .load(mList.get(position).getImageUrl())
                .resize(96, 96)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .centerInside()
                .into(holder.mIvIcon);


    }


    private View.OnClickListener taskActionOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

           if (v.getTag() == null) {
                return;
            }
            final FileViewHolder holder = (FileViewHolder) v.getTag();
            int position = holder.id;
            BaseDownloadTask task= mList.get(position).getBaseDownloadTask();
            DownloadTask downloadTask=mList.get(position);
           if(task.getStatus()==-3 &&  new File(mList.get(position).getPath()).exists()){

               String command     = "chmod " + "777" + " " + downloadTask.getPath();
               Runtime runtime = Runtime.getRuntime();
               try {
                   runtime.exec(command);
               } catch (IOException e) {
                   e.printStackTrace();
               }
               holder.mBtnOperate.setText("打开");
               Intent intent = new Intent(Intent.ACTION_VIEW);
               intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               intent.setDataAndType(Uri.parse("file://" + downloadTask.getPath()),"application/vnd.android.package-archive");
               mContext.startActivity(intent);
           }else if (task.getStatus()==3){
               task.pause();
               holder.mBtnOperate.setText("继续");

            } else if (task.getStatus()==0 || task.getStatus()==-2){
               holder.mBtnOperate.setText("暂停");

               task= downloadTask.build();
               task.setListener(new DownloadListener(holder,position));
             //  task=DownLoadManager.getSingleton().createTask(downloadTask.getUrl(),downloadTask.getPath());
               task.start();
               mList.get(position).setBaseDownloadTask(task);
           }

        }
    };




    static  class FileViewHolder extends CommonBaseAdapter.ViewHolder {
    @Bind(R.id.iv_icon)
    ImageView mIvIcon;
    @Bind(R.id.number_progress_bar)
    ProgressBar mNumberProgressBar;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.btn_operate)
    Button mBtnOperate;
    @Bind(R.id.tv_download_speed)
    TextView mTvDownloadSpeed;
    /**
     * download id
     */
    private int id;

    public void setDownloadId(final int id) {
        this.id = id;
    }

    public void updateDownloaded() {
        mNumberProgressBar.setProgress(100);
        mBtnOperate.setText("Delete");
    }

    public void updateNotDownloaded(int progress) {
        mNumberProgressBar.setProgress(progress);
        mBtnOperate.setText("Start");
    }

    /**
     * 更新下载进度
     *
     */
    public void updateDownloading(int to,int tota, long speed) {
        mNumberProgressBar.setProgress(to);
        mNumberProgressBar.setMax(tota);
        mTvDownloadSpeed.setText("Speed:" + generateFileSize(speed)+"/"+ new DecimalFormat("#.00").format(tota/MB)+" MB");
    }

    public void updateWait(int progress) {
        mNumberProgressBar.setProgress(progress);
        mBtnOperate.setText("Pause");
    }

    public FileViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    static final double KB = 1024.0;
    static final double MB = KB * KB;
    static final double GB = KB * KB * KB;

    static String generateFileSize(long size) {
        String fileSize;
        if (size < KB) {
            fileSize = size + "kB";
        } else {
            fileSize = new DecimalFormat("#.00").format(size / KB) + "MB";
        }

        return fileSize;
    }
}

}
