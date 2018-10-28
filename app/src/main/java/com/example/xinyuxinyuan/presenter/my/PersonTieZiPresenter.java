package com.example.xinyuxinyuan.presenter.my;

import com.example.xinyuxinyuan.contract.my.PersonTieziContract;
import com.example.xinyuxinyuan.model.my.personpage.PersonPageModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asd on 2018/5/14.
 */

public class PersonTieZiPresenter implements PersonTieziContract.PersonTieziContractPresenter {
    private PersonTieziContract.PersonTieziContractView view;
    private PersonPageModel service;

    public PersonTieZiPresenter(PersonTieziContract.PersonTieziContractView view) {
        this.view = view;
        service = RetrofitUtils.getRetrofitUtils().getService(PersonPageModel.class);
    }

    @Override
    public void loadTieZi(String id) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("studentId", id);
        service.getUserTieZi(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe();

    }
}
