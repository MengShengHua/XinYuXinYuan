package com.example.xinyuxinyuan.presenter.my;

import com.example.xinyuxinyuan.contract.my.AuthenticationContract;
import com.example.xinyuxinyuan.model.bean.APIBean;
import com.example.xinyuxinyuan.model.my.AuthenticationModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asd on 2018/5/12.
 */

public class AuthenticationPresenter implements AuthenticationContract.AuthenticationContractPresenter {
    private AuthenticationContract.AuthenticationContractView view;
    private final AuthenticationModel service;

    public AuthenticationPresenter(AuthenticationContract.AuthenticationContractView view) {
        this.view = view;
        service = RetrofitUtils.getRetrofitUtils().getService(AuthenticationModel.class);
    }

    @Override
    public void loadAuthentication(String userId, String userName, String realm, String intro, String pic, String authentication) {
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", userId);
        params.put("realname", userName);
        params.put("realm", realm);
        params.put("intro", intro);
        params.put("pic", pic);
        params.put("authentication", authentication);
        service.getAuthentication(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<APIBean>() {
                    @Override
                    public void accept(APIBean apiBean) throws Exception {
                        view.showAuthentication(apiBean);
                    }
                });
    }
}
