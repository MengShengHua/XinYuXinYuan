package com.example.xinyuxinyuan.model.home;

import com.example.xinyuxinyuan.model.bean.BaoDianBean;
import com.example.xinyuxinyuan.model.bean.BaoDian_LunBo_Bean;
import com.example.xinyuxinyuan.utils.UrlData;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by 键盘上的手艺人 on 2018/5/4.
 */

public interface BaoDianModel {
    @FormUrlEncoded
    @POST(UrlData.BAO_DIAN)
    Observable<BaoDianBean> getBaoDianData(@FieldMap Map<String,Integer> params, @HeaderMap Map<String,String> headers);

    @FormUrlEncoded
    @POST(UrlData.BAO_DIAN_LUN_BO_UEL)
    Observable<BaoDian_LunBo_Bean> getBaoDianLunBoData(@FieldMap Map<String,Integer> params,@HeaderMap Map<String,String> headers);
}
