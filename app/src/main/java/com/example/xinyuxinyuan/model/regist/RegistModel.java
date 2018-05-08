package com.example.xinyuxinyuan.model.regist;

import com.example.xinyuxinyuan.contract.bean.CheckUserLoginModel;
import com.example.xinyuxinyuan.contract.bean.JavaBean;
import com.example.xinyuxinyuan.contract.bean.LoginBean;
import com.example.xinyuxinyuan.contract.bean.ResetBean;
import com.example.xinyuxinyuan.contract.bean.UpLoadImgModel;
import com.example.xinyuxinyuan.utils.url.LoginAndRegister;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by asd on 2018/5/3.
 */

public interface RegistModel {
    //    发送验证码
    @FormUrlEncoded
    @POST(LoginAndRegister.YANZHENGMA)
    Observable<JavaBean> loadYanZhengMa(@FieldMap Map<String, String> params);


    //  验证手机号是否唯一
    @FormUrlEncoded
    @POST(LoginAndRegister.VERIFICATIONPHONE)
    Observable<JavaBean> loadVverificationPhone(@FieldMap Map<String, String> params);


    //注册
    @FormUrlEncoded
    @POST(LoginAndRegister.REGISTER)
    Observable<JavaBean> loadRegister(@FieldMap Map<String, String> params);

    //头像上传
    @FormUrlEncoded
    @POST(LoginAndRegister.HEADER)
    Observable<UpLoadImgModel> loadHeaderImg(@Part List<MultipartBody.Part> file, @HeaderMap Map<String, String> header);

    //用户完善信息完成
    @FormUrlEncoded
    @POST(LoginAndRegister.USERINFORMATIONLOGIN)
    Observable<CheckUserLoginModel> loadUserInformationLogin(@FieldMap Map<String, Object> params);

    //用户登录
    @FormUrlEncoded
    @POST(LoginAndRegister.USERLOGIN)
    Observable<LoginBean> loadUserLogin(@FieldMap Map<String, String> params);

    //重置密码
    @FormUrlEncoded
    @POST(LoginAndRegister.RESETPASSWORD)
    Observable<ResetBean> loadUserReset(@FieldMap Map<String, String> params);
}
