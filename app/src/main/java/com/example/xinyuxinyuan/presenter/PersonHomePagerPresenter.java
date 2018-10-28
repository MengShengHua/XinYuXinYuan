package com.example.xinyuxinyuan.presenter;

import android.graphics.Color;
import android.widget.Button;

import com.example.xinyuxinyuan.contract.PersonInforContract;
import com.example.xinyuxinyuan.model.bean.HomePagerBean;
import com.example.xinyuxinyuan.model.bean.LoginBean;
import com.example.xinyuxinyuan.model.my.personpage.PersonPageModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asd on 2018/5/9.
 */

public class PersonHomePagerPresenter implements PersonInforContract.PersonInforPresenter {
    private PersonInforContract.PersonInforView view;
    private PersonPageModel service;

    public PersonHomePagerPresenter(PersonInforContract.PersonInforView view) {
        this.view = view;
        service = RetrofitUtils.getRetrofitUtils().getService(PersonPageModel.class);
    }

    /**
     * 判斷按钮的显示文字
     *
     * @param btData
     */
    @Override
    public boolean JudgButton(String btData, Button button) {
        if ("关注".equals(btData)) {
            button.setText("已关注");
            button.setBackgroundColor(Color.parseColor("#ffffff"));
            button.setTextColor(Color.parseColor("#dfdddd"));
            return true;
        } else {
            button.setText("关注");
            button.setBackgroundColor(Color.parseColor("#142fdf"));
            button.setTextColor(Color.parseColor("#ffffff"));
            return false;
        }
    }

    /**
     * 关注
     *
     * @param followId
     * @param userId
     */
    @Override
    public void loadFollow(String followId, String userId) {
        HashMap<String, String> params = new HashMap<>();
        params.put("attentionId", followId);
        params.put("loginUserId", userId);
        service.getFollow(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        view.showFollow(loginBean);
                    }
                });
    }

    /**
     * 取消关注
     *
     * @param followId
     * @param userId
     */
    @Override
    public void loadDismissFollow(String followId, String userId) {
        HashMap<String, String> params = new HashMap<>();
        params.put("attentionId", followId);
        params.put("loginUserId", userId);
        service.getDismissFollow(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        view.showFollow(loginBean);
                    }
                });
    }

    /**
     * 根据点击的用户的ID，和我们自己的用户ID获取
     *
     * @param currentUserId 点击的用户ID
     * @param MyuserId      我的ID
     */
    @Override
    public void loadUserInfor(String currentUserId, String MyuserId) {
        HashMap<String, String> params = new HashMap<>();
        params.put("studentId", currentUserId);
        params.put("loginUserId", MyuserId);
        service.getUserInfor(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<HomePagerBean>() {
                    @Override
                    public void accept(HomePagerBean homePagerBean) throws Exception {
                        view.showUserInfor(homePagerBean);
                    }
                });
    }

}
