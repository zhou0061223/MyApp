package com.zhou.jy.retrofit20test;

import com.squareup.okhttp.ResponseBody;

import java.lang.annotation.RetentionPolicy;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Administrator on 2016/4/28.
 */
public interface APIService {
    @POST("geocoding?a=北京")
    Call<City> getCity(@Field("ddd")String aaa,@Field("bbb")String bbb);

    @POST("http://www.baidu.com/")
    Call<ResponseBody> loadRepo();

    @GET("http://www.baidu.com/")
    Call<ResponseBody> get();
}
