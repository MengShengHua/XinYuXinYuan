package com.example.xinyuxinyuan.contract.my;

import android.content.SharedPreferences;

import com.example.xinyuxinyuan.utils.ShareUtils;

/**
 * Created by asd on 2018/5/8.
 */

public interface SetContract {
    interface SetContractPresenter {
        void loadClearUserAllData(SharedPreferences sharedPreferences);
    }
}
