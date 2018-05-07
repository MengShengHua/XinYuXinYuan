package com.example.xinyuxinyuan.model.home;

import com.example.xinyuxinyuan.contract.Bean.APIBean;
import com.example.xinyuxinyuan.utils.url.LoginAndRegister;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 键盘上的手艺人 on 2018/5/4.
 */

public interface APIModel {
    @FormUrlEncoded
    @POST(LoginAndRegister.API)
    Observable<APIBean> loadApiToken(@FieldMap Map<String,Integer> params);
}