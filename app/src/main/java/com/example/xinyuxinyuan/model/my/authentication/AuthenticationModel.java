package com.example.xinyuxinyuan.model.my.authentication;

import com.example.xinyuxinyuan.model.bean.APIBean;
import com.example.xinyuxinyuan.utils.url.MyUrl;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by asd on 2018/5/12.
 */

public interface AuthenticationModel {
    //    认证
    @FormUrlEncoded
    @POST(MyUrl.AUTHENTICATION)
    Observable<APIBean> getAuthentication(@FieldMap Map<String, String> params);
}
