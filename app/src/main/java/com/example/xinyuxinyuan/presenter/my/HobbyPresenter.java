package com.example.xinyuxinyuan.presenter.my;

import com.example.xinyuxinyuan.model.bean.APIBean;
import com.example.xinyuxinyuan.model.bean.HobbyBean;
import com.example.xinyuxinyuan.contract.my.HobbyContract;
import com.example.xinyuxinyuan.model.my.HobbyModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asd on 2018/5/12.
 */

public class HobbyPresenter implements HobbyContract.HobbyContractPresenter {
    private HobbyContract.HobbyContractView view;
    private final HobbyModel service;

    public HobbyPresenter(HobbyContract.HobbyContractView view) {
        this.view = view;
        service = RetrofitUtils.getRetrofitUtils().getService(HobbyModel.class);
    }

    @Override
    public void loadUserHobby(String userId) {
        HashMap<String, String> parmas = new HashMap<>();
        parmas.put("loginUserId", userId);
        service.getUserHoby(parmas)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<HobbyBean>() {
                    @Override
                    public void accept(HobbyBean hobbyBean) throws Exception {
                        view.showUserHobby(hobbyBean);
                    }
                });
    }

    @Override
    public void loadPreservationHooby(String userId, String majorIds, String collegeIds) {
        HashMap<String, String> params = new HashMap<>();
        params.put("loginUserId", userId);
        params.put("majorIds", majorIds);
        params.put("collegeIds", collegeIds);
        service.getPreservationHobby(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<APIBean>() {
                    @Override
                    public void accept(APIBean apiBean) throws Exception {

                    }
                });
    }
}
