package com.example.xinyuxinyuan.model.message;

import com.example.xinyuxinyuan.contract.Bean.CheckUserLoginModel;
import com.example.xinyuxinyuan.contract.Bean.MessageRemindBean;
import com.example.xinyuxinyuan.utils.url.LoginAndRegister;
import com.example.xinyuxinyuan.utils.url.MessageRemindUrl;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by asd on 2018/5/7.
 */

public interface MessageRemindModel {

    @FormUrlEncoded
    @POST(MessageRemindUrl.MESSAGEREMIND)
    Observable<MessageRemindBean> messageRemindBeanObservable(@HeaderMap Map<String, String> header, @FieldMap Map<String, Integer> params);
}
