package com.example.xinyuxinyuan.contract.home;

import com.example.xinyuxinyuan.contract.Bean.MingShiBean;
import com.example.xinyuxinyuan.utils.UrlData;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 键盘上的手艺人 on 2018/5/4.
 */

public interface MingShi {
    interface View {
        void showMingShiData(MingShiBean.DataBean data);
    }

    interface Presenter {
        void loadMingShiData();
    }
}
