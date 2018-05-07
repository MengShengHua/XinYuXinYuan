package com.example.xinyuxinyuan.utils.url;

/**
 * Created by asd on 2018/5/3.
 */

public class LoginAndRegister {

    /*
      获取短信
       */
    public static final String YANZHENGMA = "v1/m/user/authcode";
    //   注册
    public static final String REGISTER = "v1/m/user/register/mobile";
    //    验证手机号是否唯一
    public static final String VERIFICATIONPHONE = "v1/m/user/verify/mobile";
    // 头像上传
    public static final String HEADER = "v1/m/qiniu/qiniuUpload";
    //    用户信息完善
    public static final String USERINFORMATIONLOGIN = "v1/m/user/saveCompleteUser";
    //    用户登录
    public static final String USERLOGIN = "v1/m/user/login/mobile";
    //    重置密码
    public static final String RESETPASSWORD = "v1/m/user/save/password";




    /*
    * api接口验证token
    * */
    public static final String API = "v1/m/security/apptoken";


    /*
    * 名师页面
    * */
    public static final String MINGSHI = "v1/m/home/alliance/list";

    /*
    * 作业页面
    * */
    public static final String ZUO_YE = "v1/m/homewok/home";
}
