package com.example.xinyuxinyuan.model.my.personpage;

import com.example.xinyuxinyuan.contract.bean.FansBean;
import com.example.xinyuxinyuan.contract.bean.FollowBean;
import com.example.xinyuxinyuan.contract.bean.HomePagerBean;
import com.example.xinyuxinyuan.contract.bean.HomePagerTieZiBean;
import com.example.xinyuxinyuan.contract.bean.LoginBean;
import com.example.xinyuxinyuan.contract.bean.UserInforBean;
import com.example.xinyuxinyuan.utils.url.MyUrl;
import com.example.xinyuxinyuan.utils.url.PersonHomePageUrl;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by asd on 2018/5/9.
 */

public interface PersonPageModel {
    //    关注
    @FormUrlEncoded
    @POST(MyUrl.FOLLOW)
    Observable<LoginBean> getFollow(@FieldMap Map<String, String> params);

    //   取消 关注
    @FormUrlEncoded
    @POST(MyUrl.DISMISSFOLLOW)
    Observable<LoginBean> getDismissFollow(@FieldMap Map<String, String> params);


    //    我的界面的关注数量粉丝数量
    @FormUrlEncoded
    @POST(MyUrl.MY)
    Observable<UserInforBean> getMyInformation(@FieldMap Map<String, String> params);

    //    我的关注
    @FormUrlEncoded
    @POST(MyUrl.MYFOLLOW)
    Observable<FollowBean> getMyFollow(@FieldMap Map<String, String> params);

    //    我的粉丝
    @FormUrlEncoded
    @POST(MyUrl.MyFANS)
    Observable<FansBean> getMyFens(@FieldMap Map<String, Object> params);

    //点击其他用户的个人主页
    //    获取用户信息
    @FormUrlEncoded
    @POST(PersonHomePageUrl.HOMEPAGER)
    Observable<HomePagerBean> getUserInfor(@FieldMap Map<String, String> params);

    //用户帖子
    @POST(PersonHomePageUrl.HOMEPAGERTIEZI)
    Observable<HomePagerTieZiBean> getUserTieZi(@FieldMap Map<String, Object> params);
//    用户作作品

}
