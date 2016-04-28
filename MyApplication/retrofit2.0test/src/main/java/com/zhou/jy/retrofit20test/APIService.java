package com.zhou.jy.retrofit20test;

import java.lang.annotation.RetentionPolicy;

import retrofit.Call;
import retrofit.http.POST;

/**
 * Created by Administrator on 2016/4/28.
 */
public interface APIService {
    @POST("index.php")
    Call<Repo> loadRepo();
}
