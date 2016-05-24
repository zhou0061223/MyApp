package com.zhou.jy.utilslibrary;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;

/**
 * Created by leon on 2/16/15.
 * Download update apk with SystemService.
 */
public class DownloadUtils {

  public static String MINETYPE_APPLCATION = "application/vnd.android.package-archive";

  public static long DownloadApkWithProgress(Context context, String url) {

    DownloadManager downloadManager =
        (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);

    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
    request.setDestinationInExternalPublicDir("/headline", "update.apk");
    request.setTitle("Updating" + context.getPackageName());
    request.setMimeType(MINETYPE_APPLCATION);
    long downloadId = downloadManager.enqueue(request);
    return downloadId;
  }

}
