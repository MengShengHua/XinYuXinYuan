package com.example.xinyuxinyuan.model.regist;

import com.example.xinyuxinyuan.contract.Bean.JavaBean;
import com.example.xinyuxinyuan.utils.UrlData;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by asd on 2018/5/3.
 */

public interface RegistModel {
    @FormUrlEncoded
    @POST(UrlData.YANZHENGMA)
    Observable<JavaBean> loadYanZhengMa(@FieldMap Map<String, String> params);
    @FormUrlEncoded
    @POST(UrlData.REGISTER)
    Observable<JavaBean> loadRegister(@FieldMap Map<String, String> params);
}
