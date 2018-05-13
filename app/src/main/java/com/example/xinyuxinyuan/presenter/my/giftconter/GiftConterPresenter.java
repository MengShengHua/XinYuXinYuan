package com.example.xinyuxinyuan.presenter.my.giftconter;

import android.util.Log;

import com.example.xinyuxinyuan.contract.bean.GiftConterBean;
import com.example.xinyuxinyuan.contract.my.giftconter.GiftConterContract;
import com.example.xinyuxinyuan.model.my.giftconter.GiftConterModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asd on 2018/5/12.
 */

public class GiftConterPresenter implements GiftConterContract.DetailedContractPresenter {
    private GiftConterContract.DetailedContractView view;
    private GiftConterModel service;

    public GiftConterPresenter(GiftConterContract.DetailedContractView view) {
        this.view = view;
        service = RetrofitUtils.getRetrofitUtils().getService(GiftConterModel.class);
    }

    /**
     * 礼物中心的明细
     *
     * @param loginUserId
     * @param type
     */
    @Override
    public void loadGift(String loginUserId, String type) {
        HashMap<String, String> params = new HashMap<>();
        params.put("loginUserId", loginUserId);
        params.put("type", type);
        service.getGiftConter(ShareUtils.getToken(), params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<GiftConterBean>() {
                    @Override
                    public void accept(GiftConterBean giftConterBean) throws Exception {
                        view.showGiftDetailed(giftConterBean);
                    }
                });
    }
}
