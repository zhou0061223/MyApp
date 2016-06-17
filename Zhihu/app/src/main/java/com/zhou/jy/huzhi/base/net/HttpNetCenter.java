package com.zhou.jy.huzhi.base.net;

import com.zhou.jy.huzhi.base.entity.Latest;
import com.zhou.jy.huzhi.base.entity.StartImage;
import com.zhou.jy.huzhi.base.entity.ThemeData;
import com.zhou.jy.huzhi.base.entity.Themes;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/6/16.
 */
public class HttpNetCenter {

    private static HttpNetCenter instance;
    private  String BaseUrl="http://news-at.zhihu.com/api/4/";
    private APIService apiService;

    public  HttpNetCenter(){
        init();
    }

    public static HttpNetCenter getInstance(){

        if(instance==null){
            instance =new HttpNetCenter();
        }
        return instance;
    }

    private void  init(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        apiService=retrofit.create(APIService.class);
    }


    public Observable<StartImage> getStartImage(){
       return   apiService.getStartImage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io());
    }
    public Observable<Latest> getLatest(){
        return   apiService.getLatest()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io());
    }

    public Observable<Themes> getThemes(){
        return   apiService.getThemes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io());
    }

    public Observable<ThemeData> getThemeData(int id){
        return   apiService.getThemeData(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io());
    }
}
