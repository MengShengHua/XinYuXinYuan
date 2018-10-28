package com.example.xinyuxinyuan.model.my.giftconter;

import com.example.xinyuxinyuan.model.bean.GiftConterBean;
import com.example.xinyuxinyuan.utils.url.MyUrl;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by asd on 2018/5/12.
 */

public interface GiftConterModel {
    //礼物中心
    @FormUrlEncoded
    @POST(MyUrl.GIFTCENTER)
    Observable<GiftConterBean> getGiftConter(@Header("apptoken") String apptoken, @FieldMap Map<String, String> params);
}
