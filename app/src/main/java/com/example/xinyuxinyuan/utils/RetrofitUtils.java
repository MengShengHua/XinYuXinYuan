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
    private OkHttpClient okHttpClient;

    private RetrofitUtils() {
         okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(8000, TimeUnit.SECONDS)
                .readTimeout(120000,TimeUnit.SECONDS)
                .writeTimeout(20000,TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)//关闭重复的请求
                .addInterceptor(new ReceivedCookiesInterceptor(App.context))
                .addInterceptor(new AddCookiesInterceptor(App.context))
                .build();

         retrofit= new Retrofit.Builder()
                .client(okHttpClient)
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
