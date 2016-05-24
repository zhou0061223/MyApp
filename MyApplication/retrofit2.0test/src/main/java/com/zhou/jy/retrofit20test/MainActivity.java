package com.zhou.jy.retrofit20test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.squareup.okhttp.ResponseBody;

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
                .baseUrl("http://gc.ditu.aliyun.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         service = retrofit.create(APIService.class);



        new Thread(new Runnable() {
            @Override
            public void run() {

                Call<City> call=service.getCity("aaaa","bbbb");
                try {
                    City city=call.execute().body();
                    if(city!=null){

                        Log.i("aaaaa",city.lon+""+call.toString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

           /*     Call<ResponseBody> call = service.get();
                Response<ResponseBody> bodyResponse = null;
                try {
                    bodyResponse = call.execute();
                    String body = bodyResponse.body().string();//获取返回体的字符串
                    Log.i("aaaaa",body);
                } catch (IOException e) {
                    e.printStackTrace();
                }*/

            /*    Call<ResponseBody> call = service.loadRepo();
                try {
                    Log.i("aaaaa",call.execute().body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }*/


            }
        }).start();
    }
}
