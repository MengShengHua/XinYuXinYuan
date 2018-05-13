package com.example.xinyuxinyuan.presenter.my;

import android.util.Log;

import com.example.xinyuxinyuan.contract.bean.JinDouPriceItemBean;
import com.example.xinyuxinyuan.contract.my.RechargeContract;
import com.example.xinyuxinyuan.model.my.RechargeModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asd on 2018/5/11.
 */

public class RechargePresenter implements RechargeContract.RechargeContractPresenter {
    private RechargeContract.RechargeContractView view;
    private final RechargeModel service;

    public RechargePresenter(RechargeContract.RechargeContractView view) {
        this.view = view;
        service = RetrofitUtils.getRetrofitUtils().getService(RechargeModel.class);
    }

    @Override
    public void loadJinDouPriceItem(String userId) {
        HashMap<String, String> params = new HashMap<>();
        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("Authorization", ShareUtils.getToken());
        service.getJinDouItem(ShareUtils.getToken(), params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<JinDouPriceItemBean>() {
                    @Override
                    public void accept(JinDouPriceItemBean jinDouPriceItemBean) throws Exception {
                        view.showJinDouPriceItem(jinDouPriceItemBean);
                    }
                });
    }
}
