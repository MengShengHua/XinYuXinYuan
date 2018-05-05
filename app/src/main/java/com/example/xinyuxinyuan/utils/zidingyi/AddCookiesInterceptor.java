package com.example.xinyuxinyuan.utils.zidingyi;
import android.content.Context;

import com.example.xinyuxinyuan.utils.ShareUtils;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by vicoltree on 17/10/26.
 */

public class AddCookiesInterceptor implements Interceptor {


    private Context context;

    public AddCookiesInterceptor(Context context) {
        super();
        this.context = context;

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request.Builder builder = chain.request().newBuilder();
        if(ShareUtils.getToken() != null){
            builder.addHeader("apptoken", ShareUtils.getToken());
        }
        return chain.proceed(builder.build());
    }
}
