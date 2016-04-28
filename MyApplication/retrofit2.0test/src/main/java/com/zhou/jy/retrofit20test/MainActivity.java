package com.zhou.jy.retrofit20test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    private  APIService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.baidu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         service = retrofit.create(APIService.class);
        new Thread(new Runnable() {
            @Override
            public void run() {


                Call<Repo> call=service.loadRepo();
                try {
                    Response<Repo> repo=call.execute();
                    Log.i("aaaaaa","ccccccccc");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
