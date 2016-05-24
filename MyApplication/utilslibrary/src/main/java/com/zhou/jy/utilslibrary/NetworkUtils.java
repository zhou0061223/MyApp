package com.zhou.jy.utilslibrary;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by leon on 14/10/11.
 */
public class NetworkUtils {

  public static boolean isWifiAviliable(Context context) {
    ConnectivityManager con =
        (ConnectivityManager) context.getSystemService(Activity.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = con.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
    return activeNetworkInfo != null;
  }

  public boolean isNetworkAvailable(Context context) {
    ConnectivityManager connectivityManager =
        (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    return activeNetworkInfo != null;
  }
}
