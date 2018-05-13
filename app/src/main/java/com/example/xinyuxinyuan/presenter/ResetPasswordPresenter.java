package com.example.xinyuxinyuan.presenter;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.xinyuxinyuan.contract.bean.ResetBean;
import com.example.xinyuxinyuan.contract.ResetPasswordContract;
import com.example.xinyuxinyuan.model.regist.RegistModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asd on 2018/5/5.
 */

public class ResetPasswordPresenter implements ResetPasswordContract.ResetPasswordPresenter {
    private ResetPasswordContract.ResetPasswordView view;
    private final RegistModel service;

    public ResetPasswordPresenter(ResetPasswordContract.ResetPasswordView view) {
        this.view = view;
        service = RetrofitUtils.getRetrofitUtils().getService(RegistModel.class);
    }

    /**
     * 根据密码框的输入状态，判断按钮和X号的状态
     *
     * @param password
     * @param button
     * @param imageView
     */
    @Override
    public void loadJudgePassword(String password, Button button, ImageView imageView) {
        if (password.length() < 6 || password.length() > 16) {
            imageView.setVisibility(View.VISIBLE);
            button.setBackgroundColor(Color.parseColor("#e6e3e3"));
            button.setEnabled(false);
        } else {
            button.setBackgroundColor(Color.parseColor("#142fdf"));
            button.setEnabled(true);
        }
        if (password.length() == 0) {
            imageView.setVisibility(View.GONE);
            button.setBackgroundColor(Color.parseColor("#e6e3e3"));
            button.setEnabled(false);
        }
    }

    /**
     * 根据新密码框的输入状态，判断按钮和X号的状态
     *
     * @param password
     * @param button
     * @param imageView
     */
    @Override
    public void loadJudgeNewPassword(String password, Button button, ImageView imageView) {

    }

    /**
     * 点击登录时调用
     *
     * @param phone
     * @param newPassword
     */
    @Override
    public void loadOver(String phone, String password,String newPassword) {
        if (password.equals(newPassword)) {
//        网路请求
            HashMap<String, String> params = new HashMap<>();
            params.put("mobile", phone);
            params.put("password", newPassword);
            service.loadUserReset(params)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.newThread())
                    .subscribe(new Consumer<ResetBean>() {
                        @Override
                        public void accept(ResetBean resetBean) throws Exception {
                            view.showResetOver(resetBean);
                        }
                    });
        } else {
            view.showMessage("俩次密码不一致");
        }
    }

    /**
     * 修改密码界面调用此方法
     * @param phone
     * @param password
     * @param newPassword
     */
    @Override
    public void loadModifyPassword(String phone, String password, String newPassword) {

    }
}
