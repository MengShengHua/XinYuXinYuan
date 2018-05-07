package com.example.xinyuxinyuan.utils;


import com.example.xinyuxinyuan.App;
import com.example.xinyuxinyuan.utils.zidingyi.AddCookiesInterceptor;
import com.example.xinyuxinyuan.utils.zidingyi.ReceivedCookiesInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by asd on 2018/5/3.
 */

public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils;
    private Retrofit retrofit;

    private RetrofitUtils() {

         retrofit= new Retrofit.Builder()
                .baseUrl(UrlData.KEHU_DUAN)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }



    public static RetrofitUtils getRetrofitUtils(){
        if (retrofitUtils == null){
            synchronized (RetrofitUtils.class){
                if (retrofitUtils == null){
                    return retrofitUtils = new RetrofitUtils();
                }
            }

        }
        return retrofitUtils;
    }



    public <T> T getService(Class<T> tClass) {
        return retrofit.create(tClass);
    }
}
