package com.example.xinyuxinyuan.utils;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by asd on 2018/5/3.
 */

public class RetrofitUtils {
    public static RetrofitUtils retrofitUtils;
    private Retrofit retrofit;

    private RetrofitUtils() {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://www.univstar.com/v1/m/user/")
                .build();
    }

    public static RetrofitUtils getRetrofitUtils() {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (retrofitUtils == null) {
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
