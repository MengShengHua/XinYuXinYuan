package com.example.xinyuxinyuan.model.home;

import com.example.xinyuxinyuan.contract.bean.XiangQingBean;
import com.example.xinyuxinyuan.contract.bean.XiangQingMaiBean;
import com.example.xinyuxinyuan.utils.UrlData;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by 键盘上的手艺人 on 2018/5/9.
 */

public interface XiangQingMaiModel {
    @FormUrlEncoded
    @POST(UrlData.XIAN_DIAN_JI)
    Observable<XiangQingMaiBean> getXiangQingMaiData(@FieldMap Map<String, Object> params, @HeaderMap Map<String, String> headers);
}
