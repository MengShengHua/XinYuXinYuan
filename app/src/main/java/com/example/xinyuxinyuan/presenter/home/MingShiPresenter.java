package com.example.xinyuxinyuan.presenter.home;


import android.util.Log;

import com.example.xinyuxinyuan.contract.Bean.MingShiBean;
import com.example.xinyuxinyuan.contract.home.MingShi;
import com.example.xinyuxinyuan.model.home.MingShiModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 键盘上的手艺人 on 2018/5/4.
 */

public class MingShiPresenter implements MingShi.Presenter {
    MingShi.View view;
    private MingShiModel mingShiModel;

    public MingShiPresenter(MingShi.View view) {
        this.view = view;
        mingShiModel = RetrofitUtils.getRetrofitUtils().getService(MingShiModel.class);
    }

    @Override
    public void loadMingShiData() {
        Map<String, Integer> params = new HashMap<>();
        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("apptoken", ShareUtils.getToken());
        mingShiModel.getMingShiData(params, headerMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MingShiBean>() {
                    @Override
                    public void accept(MingShiBean mingShiBean) throws Exception {
                        MingShiBean.DataBean data = mingShiBean.getData();
                        Log.e("13132", data.toString());
                        view.showMingShiData(data);
                    }
                });
    }
}
