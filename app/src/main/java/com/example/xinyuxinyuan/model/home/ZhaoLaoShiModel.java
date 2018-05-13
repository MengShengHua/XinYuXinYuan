package com.example.xinyuxinyuan.model.home;

import com.example.xinyuxinyuan.contract.bean.ZhaoLaoShiBean;
import com.example.xinyuxinyuan.utils.UrlData;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by 键盘上的手艺人 on 2018/5/8.
 */

public interface ZhaoLaoShiModel {
    @FormUrlEncoded
    @POST(UrlData.ZHAO_LAO_SHI)
    Observable<ZhaoLaoShiBean> getZhaoLaoShiData(@FieldMap Map<String,Object> headers);
}
