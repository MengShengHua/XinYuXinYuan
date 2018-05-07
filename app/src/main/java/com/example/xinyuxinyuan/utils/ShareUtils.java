package com.example.xinyuxinyuan.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.xinyuxinyuan.App;

/**
 * Created by 键盘上的手艺人 on 2018/5/4.
 */

public class ShareUtils {

    public static void setToken(String Token,long time){
        SharedPreferences sharedPreferences = App.context.getSharedPreferences("Token", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("Token", Token+"."+time);
        edit.commit();
    }

    public static String getToken(){
        SharedPreferences sharedPreferences = App.context.getSharedPreferences("Token", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Token",null);
    }

    //保存cookie
    public static void setCookie(String cookie){
        SharedPreferences sharedPreferences = App.context.getApplicationContext().getSharedPreferences("cookie", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("cookie", cookie);
        editor.commit();
    }

    //取cookie
    public static String getCookie(){
        SharedPreferences sharedPreferences = App.context.getApplicationContext().getSharedPreferences("cookie", Context.MODE_PRIVATE);
        return sharedPreferences.getString("cookie","");
    }

    //设置用户登录id
    public static void setLoginUserId(int loginUserId){
        SharedPreferences sharedPreferences = App.context.getSharedPreferences("LoginUserId", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("LoginUserId",loginUserId);
        edit.commit();
    }
    //得到用户登录id
    public static int getLoginUserId(){

        SharedPreferences sharedPreferences = App.context.getSharedPreferences("LoginUserId", Context.MODE_PRIVATE);
        return sharedPreferences.getInt("LoginUserId",0);
    }


}
