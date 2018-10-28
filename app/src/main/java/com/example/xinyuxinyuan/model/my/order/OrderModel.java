package com.example.xinyuxinyuan.model.my.order;

import com.example.xinyuxinyuan.model.bean.LoginBean;
import com.example.xinyuxinyuan.model.bean.OrderAllBean;
import com.example.xinyuxinyuan.model.bean.OrderDetailsBean;
import com.example.xinyuxinyuan.utils.url.MyUrl;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by asd on 2018/5/11.
 */

public interface OrderModel {
    //    全部订单
    @FormUrlEncoded
    @POST(MyUrl.ORDERALL)
    Observable<OrderAllBean> getOrderAll(@FieldMap Map<String, String> params);

    //订单详情
    @FormUrlEncoded
    @POST(MyUrl.ORDERDETAILS)
    Observable<OrderDetailsBean> getOrderDetails(@FieldMap Map<String, String> params);

    //删除订单
    @FormUrlEncoded
    @POST(MyUrl.DELETEORDER)
    Observable<LoginBean> getDeleteOrder(@FieldMap Map<String, String> params);
}
