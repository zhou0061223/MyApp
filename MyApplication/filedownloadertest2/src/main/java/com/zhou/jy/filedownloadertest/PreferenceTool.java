package com.zhou.jy.filedownloadertest;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.List;


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


	public class ListToSting<T> {
		public String MybeansListToString(List<T> mybeans)
				throws IOException {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					byteArrayOutputStream);
			objectOutputStream.writeObject(mybeans);
			String myList = new String(Base64.encode(
					byteArrayOutputStream.toByteArray(), Base64.DEFAULT));
			objectOutputStream.close();
			return myList;
		}

		@SuppressWarnings("unchecked")
		public  List<T>  StringToMybeansList(String myList)
				throws StreamCorruptedException, IOException,
				ClassNotFoundException {
			byte[] mobileBytes = Base64.decode(myList.getBytes(),
					Base64.DEFAULT);
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
					mobileBytes);
			ObjectInputStream objectInputStream = new ObjectInputStream(
					byteArrayInputStream);
			List<T> mybeans = (List<T>) objectInputStream
					.readObject();
			objectInputStream.close();
			return  mybeans;
		}
	}


}
