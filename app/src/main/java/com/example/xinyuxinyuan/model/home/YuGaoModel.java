package com.example.xinyuxinyuan.model.home;

import com.example.xinyuxinyuan.contract.bean.YuGaoBean;
import com.example.xinyuxinyuan.utils.UrlData;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by 键盘上的手艺人 on 2018/5/7.
 */

public interface YuGaoModel {
    @FormUrlEncoded
    @POST(UrlData.YU_GAO)
    Observable<YuGaoBean> getYuGaoData(@FieldMap Map<String,Object> params, @HeaderMap Map<String,String> headers);
}
