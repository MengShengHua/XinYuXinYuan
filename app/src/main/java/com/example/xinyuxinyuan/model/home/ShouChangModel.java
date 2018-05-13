package com.example.xinyuxinyuan.model.home;

import com.example.xinyuxinyuan.contract.bean.ShouChangBean;
import com.example.xinyuxinyuan.utils.UrlData;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by 键盘上的手艺人 on 2018/5/10.
 */

public interface ShouChangModel {
    @FormUrlEncoded
    @POST(UrlData.SHOU_CHANG)
    Observable<ShouChangBean> getShouChangData(@FieldMap Map<String, Object> params, @HeaderMap Map<String, String> headers);


    @FormUrlEncoded
    @POST(UrlData.QU_XIAO_SHOU_CHANG)
    Observable<ShouChangBean> getQuXiaoShouChangData(@FieldMap Map<String, Object> params, @HeaderMap Map<String, String> headers);
}
