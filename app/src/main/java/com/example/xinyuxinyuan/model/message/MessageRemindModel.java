package com.example.xinyuxinyuan.model.message;

import com.example.xinyuxinyuan.contract.bean.FansBean;
import com.example.xinyuxinyuan.contract.bean.MessageRemindBean;
import com.example.xinyuxinyuan.contract.bean.OrderMessageBean;
import com.example.xinyuxinyuan.utils.url.MessageRemindUrl;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by asd on 2018/5/7.
 */

public interface MessageRemindModel {
    //消息提醒列表
    @FormUrlEncoded
    @POST(MessageRemindUrl.MESSAGEREMIND)
    Observable<MessageRemindBean> messageRemindBeanObservable(@Header("apptoken") String apptoken, @FieldMap Map<String, Integer> params);

    //    订单提醒
    @FormUrlEncoded
    @POST(MessageRemindUrl.ORDERREMIND)
    Observable<OrderMessageBean> getOrderRemind(@Header("apptoken") String apptoken,@FieldMap Map<String, String> params);
}
