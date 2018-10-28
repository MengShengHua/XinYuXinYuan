package com.example.xinyuxinyuan.model.home;

import com.example.xinyuxinyuan.model.bean.XiangQingBean;
import com.example.xinyuxinyuan.utils.UrlData;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 键盘上的手艺人 on 2018/5/8.
 */

public interface XiangQingModel {
    @FormUrlEncoded
    @POST(UrlData.ZHAO_DIAN_JI)
    Observable<XiangQingBean> getXiangQingData(@FieldMap Map<String,Integer> params);
}
