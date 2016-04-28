package com.zhou.jy.filedownloadertest;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class PreferenceTool {
	
	
	static public void SaveData(String filename,String name, String data,Context ctx) {
		//Context ctx = LoginActivity.this;
		SharedPreferences sp = ctx.getSharedPreferences(filename, ctx.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString(name, data);
		editor.commit();

	}

	static public String LoadData(String filename,String name ,Context ctx) {
		SharedPreferences sharedPreferences = ctx.getSharedPreferences(filename,
				ctx.MODE_PRIVATE);
		return sharedPreferences.getString(name, "error");

	}

}
