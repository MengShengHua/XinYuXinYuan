package com.example.xinyuxinyuan.model.my;

import com.example.xinyuxinyuan.contract.bean.APIBean;
import com.example.xinyuxinyuan.contract.bean.HobbyBean;
import com.example.xinyuxinyuan.utils.url.MyUrl;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by asd on 2018/5/12.
 */

public interface HobbyModel {
    //   偏好
    @FormUrlEncoded
    @POST(MyUrl.HOOBY)
    Observable<HobbyBean> getUserHoby(@FieldMap Map<String, String> params);

    //   偏好
    @FormUrlEncoded
    @POST(MyUrl.PRESERVATIONHOOBY)
    Observable<APIBean> getPreservationHobby(@FieldMap Map<String, String> params);

}
