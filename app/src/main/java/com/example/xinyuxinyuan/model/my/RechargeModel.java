package com.example.xinyuxinyuan.model.my;

import com.example.xinyuxinyuan.contract.bean.ALiPayModel;
import com.example.xinyuxinyuan.model.bean.JinDouPriceItemBean;
import com.example.xinyuxinyuan.model.bean.NoticeDetailOrderBean;
import com.example.xinyuxinyuan.utils.url.MyUrl;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by asd on 2018/5/11.
 */

public interface RechargeModel {
    //    金豆充值列表
    @FormUrlEncoded
    @POST(MyUrl.RECHARGEJINDOU)
    Observable<JinDouPriceItemBean> getJinDouItem(@Header("apptoken") String apptoken, @FieldMap Map<String, String> params);

    //    金豆充值
    @FormUrlEncoded
    @POST(MyUrl.JINDOUCHONGZHI)
    Observable<NoticeDetailOrderBean> getChongZhi(@Header("apptoken") String apptoken,@FieldMap Map<String, Object> params);

    //    金豆充值支付宝回调
    @FormUrlEncoded
    @POST(MyUrl.huidiao)
    Observable<ALiPayModel> getZhiFuBao(@Field("orderNo") String orderNo);
}
