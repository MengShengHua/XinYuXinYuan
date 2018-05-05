package com.example.xinyuxinyuan.utils.zidingyi;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.xinyuxinyuan.utils.ShareUtils;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by vicoltree on 17/10/26.
 */

public class ReceivedCookiesInterceptor implements Interceptor {


    private Context context;

    public ReceivedCookiesInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Response originalResponse = chain.proceed(chain.request());

        //这里获取请求返回的cookie
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            final StringBuffer cookieBuffer = new StringBuffer();
            Observable.fromIterable(originalResponse.headers("Set-Cookie"))
                    .concatMap(new Function<String, ObservableSource<String>>() {
                        @Override
                        public ObservableSource<String> apply(String s) throws Exception {
                            String[] cookieArray = s.split(";");
                            return Observable.fromArray(cookieArray[0]);
                        }
                    }).subscribe(new Consumer<String>() {
                @Override
                public void accept(String s) throws Exception {
                    cookieBuffer.append(s).append(";");
                }});


            String cookie = "";
            if(!TextUtils.isEmpty(cookieBuffer)){
                String[] cookieBuffers = cookieBuffer.toString().split("=");

                cookie = cookieBuffers[1].replace(";", "");
            }
            //将cookie保存起来
            ShareUtils.setCookie(cookie);
        }

        return originalResponse;
    }
}
