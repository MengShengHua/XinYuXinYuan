package com.example.xinyuxinyuan.model.my;

import com.example.xinyuxinyuan.contract.bean.JavaBean;
import com.example.xinyuxinyuan.contract.bean.LoginBean;
import com.example.xinyuxinyuan.utils.url.MyUrl;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by asd on 2018/5/8.
 */

public interface ReplacePhoneModel {
    //    验证验证码
    @FormUrlEncoded
    @POST(MyUrl.VERIFICATIONYANZHENGMA)
    Observable<LoginBean> getVerificationYanZhengMa(@FieldMap Map<String, String> params);

    //更换手机号
    @FormUrlEncoded
    @POST(MyUrl.REPLACEPHOE)
    Observable<LoginBean> getReplacePhoe(@FieldMap Map<String, String> params);    //更换手机号


}
