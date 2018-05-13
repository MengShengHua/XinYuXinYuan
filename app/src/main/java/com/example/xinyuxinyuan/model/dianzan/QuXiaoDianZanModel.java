package com.example.xinyuxinyuan.model.dianzan;

import com.example.xinyuxinyuan.contract.bean.QuXiaoDianZanBean;
import com.example.xinyuxinyuan.contract.home.QuXiaoDianZan;
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

public interface QuXiaoDianZanModel {
    @FormUrlEncoded
    @POST(UrlData.QU_XIAO_DIAN_ZAN)
    Observable<QuXiaoDianZanBean> getQuXiaoDianZanData(@FieldMap Map<String, Object> params, @HeaderMap Map<String, String> headers);
}
