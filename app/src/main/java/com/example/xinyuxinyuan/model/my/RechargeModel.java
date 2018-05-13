package com.example.xinyuxinyuan.model.my;

import com.example.xinyuxinyuan.contract.bean.JinDouPriceItemBean;
import com.example.xinyuxinyuan.contract.bean.LoginBean;
import com.example.xinyuxinyuan.utils.url.MyUrl;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by asd on 2018/5/11.
 */

public interface RechargeModel {
    //    金豆充值列表
    @FormUrlEncoded
    @POST(MyUrl.RECHARGEJINDOU)
    Observable<JinDouPriceItemBean> getJinDouItem(@Header("apptoken") String apptoken, @FieldMap Map<String, String> params);
}
