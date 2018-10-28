package com.example.xinyuxinyuan.model.dianzan;

import com.example.xinyuxinyuan.model.bean.GuanZhuBean;
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

public interface GuanZhuModel {
    @FormUrlEncoded
    @POST(UrlData.GUAN_ZHU)
    Observable<GuanZhuBean> getGuanZhu(@FieldMap Map<String, Object> params, @HeaderMap Map<String, String> headers);

    @FormUrlEncoded
    @POST(UrlData.QU_XIAO_GUAN_ZHU)
    Observable<GuanZhuBean> getQuXiaoGuanZhu(@FieldMap Map<String, Object> params, @HeaderMap Map<String, String> headers);
}
