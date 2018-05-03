package com.example.xinyuxinyuan.utils;

import com.example.xinyuxinyuan.contract.Bean.JavaBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by asd on 2018/5/3.
 */

public interface Service {
    @FormUrlEncoded
    @POST(UrlData.YANZHENGMA)
    Observable<JavaBean> loadYanZhengMa(@FieldMap Map<String, String> params);
    @FormUrlEncoded
    @POST(UrlData.REGISTER)
    Observable<JavaBean> loadRegister(@FieldMap Map<String, String> params);
}
