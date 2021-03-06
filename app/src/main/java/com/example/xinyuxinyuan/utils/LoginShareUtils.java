package com.example.xinyuxinyuan.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Created by asd on 2018/5/7.
 */

public class LoginShareUtils {
    /**
     * 登录成功返回的用户数据
     *
     * @param context
     * @param userNickname
     * @param userPhone
     * @param userHeader
     * @param userId
     * @param userToken
     */
    public static void UserMessage(Context context, String userNickname, String userPhone, String userHeader, int userId, String userToken) {
        SharedPreferences loginPreferences = context.getSharedPreferences("Login", context.MODE_PRIVATE);
        SharedPreferences.Editor edit = loginPreferences.edit();
//            如果成功，将用户返回的所有信息进行保存
        edit.putString("nickname", userNickname);
        edit.putString("phone", userPhone);
        edit.putString("photo", userHeader);
        edit.putString("id", userId + "");
        edit.putString("token", userToken);
        edit.commit();
    }

    public static String getUserMessage(Context context, String key) {
        SharedPreferences loginPreferences = context.getSharedPreferences("Login", context.MODE_PRIVATE);
        return loginPreferences.getString(key, "未获取到值");
    }

    /**
     * 用户储存数据，
     *
     * @param context
     * @param params    单个数据添加给null
     * @param key       多个数据添加给null
     * @param userValue 多个数据添加给null
     */
    public static void userAddDataSharedPreferences(Context context, Map<String, String> params, String key, String userValue) {
        SharedPreferences loginPreferences = context.getSharedPreferences("Login", context.MODE_PRIVATE);
        SharedPreferences.Editor edit = loginPreferences.edit();
        if (params != null) {
            Set<String> keySet = params.keySet();
            for (String value : keySet) {
                edit.putString(value, params.get(value));
            }
        } else if (key != null && userValue != null) {
            edit.putString(key, userValue);
        }
        edit.commit();
    }

    public static ArrayList<String> getUserAllMessage(Context context) {
        ArrayList<String> UserMassage = new ArrayList<>();
        SharedPreferences loginPreferences = context.getSharedPreferences("Login", context.MODE_PRIVATE);
        UserMassage.add(loginPreferences.getString("nickname", "未获取昵称"));
        UserMassage.add(loginPreferences.getString("phone", "未获取到手机号"));
        UserMassage.add(loginPreferences.getString("photo", "未获取到头像地址"));
        UserMassage.add(loginPreferences.getString("id", "未获取到Id"));
        UserMassage.add(loginPreferences.getString("token", "未获取到Token"));
        return UserMassage;
    }

    /**
     * 删除SharedPreferences里的数据
     *
     * @param context
     * @param key     要删除SharedPreferences的key
     */
    public static void deleteUserData(Context context, String key) {
        SharedPreferences loginPreferences = context.getSharedPreferences("Login", context.MODE_PRIVATE);
        SharedPreferences.Editor edit = loginPreferences.edit();
        edit.remove(key);
        edit.commit();
    }
}
