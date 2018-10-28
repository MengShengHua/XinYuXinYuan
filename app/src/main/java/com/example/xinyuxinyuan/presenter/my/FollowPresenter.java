package com.example.xinyuxinyuan.presenter.my;

import com.example.xinyuxinyuan.model.bean.UserInforBean;
import com.example.xinyuxinyuan.contract.my.FollowContract;
import com.example.xinyuxinyuan.model.my.personpage.PersonPageModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asd on 2018/5/9.
 */

public class FollowPresenter implements FollowContract.FollowContractPresenter {
    private FollowContract.FollowContractView view;
    private final PersonPageModel service;

    public FollowPresenter(FollowContract.FollowContractView view) {
        this.view = view;
        service = RetrofitUtils.getRetrofitUtils().getService(PersonPageModel.class);
    }

    /**
     * 请求我的关注页面的关注
     *
     * @param userId
     */
    @Override
    public void loadMyFollow(String userId) {
        HashMap<String, String> parmas = new HashMap<>();
        parmas.put("loginUserId", userId);
        service.getMyInformation(parmas)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<UserInforBean>() {
                    @Override
                    public void accept(UserInforBean userInforBean) throws Exception {
                        view.showMyFollow(userInforBean);
                    }
                });
    }
}
