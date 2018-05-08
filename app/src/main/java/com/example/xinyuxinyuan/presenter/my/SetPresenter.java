package com.example.xinyuxinyuan.presenter.my;

import android.content.SharedPreferences;

import com.example.xinyuxinyuan.contract.my.SetContract;

/**
 * Created by asd on 2018/5/8.
 */

public class SetPresenter implements SetContract.SetContractPresenter {
    /**
     * 退出登录，清空用户所有信息
     *
     * @param sharedPreferences
     */
    @Override
    public void loadClearUserAllData(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();
        edit.commit();
    }
}
