package com.example.xinyuxinyuan.presenter;

import com.example.xinyuxinyuan.App;
import com.example.xinyuxinyuan.contract.AnimContract;
import com.example.xinyuxinyuan.utils.zidingyi.AddCookiesInterceptor;
import com.example.xinyuxinyuan.utils.zidingyi.ReceivedCookiesInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by asd on 2018/5/7.
 */

public class AnimPersenter implements AnimContract.AnimPersenter {

    private OkHttpClient okHttpClient;

    /**
     * 请求token
     * @param token
     */
    @Override
    public void NetWorkToken(String token) {
        //关闭重复的请求
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(8000, TimeUnit.SECONDS)
                .readTimeout(120000, TimeUnit.SECONDS)
                .writeTimeout(20000, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)//关闭重复的请求
                .addInterceptor(new ReceivedCookiesInterceptor(App.context))
                .addInterceptor(new AddCookiesInterceptor(App.context))
                .build();
//        new Request.Builder().
    }
}
