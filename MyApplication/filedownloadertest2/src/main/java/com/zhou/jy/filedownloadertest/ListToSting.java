package com.zhou.jy.filedownloadertest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.List;


import android.util.Base64;
import android.view.View;


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
