package com.example.xinyuxinyuan.model.home;

import com.example.xinyuxinyuan.contract.bean.YuGaoXiangQingBean;
import com.example.xinyuxinyuan.contract.home.YuGaoXiangQing;
import com.example.xinyuxinyuan.utils.UrlData;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by 键盘上的手艺人 on 2018/5/12.
 */

public interface YuGaoXiangQingModel{
    @FormUrlEncoded
    @POST(UrlData.YUGAO_XIANGQING)
    Observable<YuGaoXiangQingBean> getYuGaoXiangQingBean(@FieldMap Map<String,Object> params, @HeaderMap Map<String,String> headers);
}
