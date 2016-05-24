package com.zhou.jy.utilslibrary;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by leon on 11/7/14.
 */
public class ScreenUtils {
  private static int screenWidth = 0;
  private static int screenHeight = 0;

  public static boolean isTablet(Context context) {
    return (context.getResources().getConfiguration().screenLayout
        & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
  }

  public static int getScreenHeight(Context c) {

    if (screenHeight == 0) {
      WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
      Display display = wm.getDefaultDisplay();
      Point size = new Point();
      display.getSize(size);
      screenHeight = size.y;
    }

    return screenHeight;
  }

  public static int getScreenWidth(Context c) {
    if (screenWidth == 0) {
      WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
      Display display = wm.getDefaultDisplay();
      Point size = new Point();
      display.getSize(size);
      screenWidth = size.x;
    }

    return screenWidth;
  }

  public static int dpToPx(int dp) {
    return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
  }

  public static int getStatusBarHeight(Context context) {
    Context appContext = context.getApplicationContext();
    int result = 0;
    int resourceId =
        appContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (resourceId > 0) {
      result = appContext.getResources().getDimensionPixelSize(resourceId);
    }
    Log.d("ScreenUtils", result + "");
    return result;
  }
}
