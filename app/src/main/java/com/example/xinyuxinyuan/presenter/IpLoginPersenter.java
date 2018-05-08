package com.example.xinyuxinyuan.presenter;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.xinyuxinyuan.contract.bean.LoginBean;
import com.example.xinyuxinyuan.contract.LoginContract;
import com.example.xinyuxinyuan.model.regist.RegistModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asd on 2018/5/4.
 */

public class IpLoginPersenter implements LoginContract.LoginPersnter {
    private LoginContract.LoginView view;
    private final RegistModel service;

    public IpLoginPersenter(LoginContract.LoginView view) {
        this.view = view;
        service = RetrofitUtils.getRetrofitUtils().getService(RegistModel.class);
    }

    /**
     * 判断手机号
     *
     * @param phone
     */
    @Override
    public void loadJudgePhone(String phone, Button button, ImageView imageView) {
        String regex = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$";
        if (phone.length() == 11 && phone.matches(regex)) {
            button.setBackgroundColor(Color.parseColor("#142fdf"));
            button.setEnabled(true);
        } else {
            button.setBackgroundColor(Color.parseColor("#e6e3e3"));
            button.setEnabled(false);
        }
        if (phone.equals("")) {
            imageView.setVisibility(View.GONE);
            button.setBackgroundColor(Color.parseColor("#e6e3e3"));
            button.setEnabled(false);
        }
    }

    /**
     * 判断密码
     *
     * @param password
     */
    @Override
    public void loadJudgePassword(String password, Button button, ImageView imageView) {
        if (password.length() >= 6) {
            button.setBackgroundColor(Color.parseColor("#142fdf"));
            button.setEnabled(true);
        } else {
            button.setBackgroundColor(Color.parseColor("#e6e3e3"));
            button.setEnabled(false);
        }
        if (password.equals("")) {
            imageView.setVisibility(View.GONE);
            button.setBackgroundColor(Color.parseColor("#e6e3e3"));
            button.setEnabled(false);
        }
    }

    /**
     * 登录时判断所有
     *
     * @param phone
     * @param password
     * @param button
     */
    @Override
    public void loadJudgeLogin(String phone, String password, Button button) {
        view.showJudgeMessage(null);
        if (TextUtils.isEmpty(phone)) {
            view.showJudgeMessage("邮箱/手机号不能为空");
            return;
        }
        String tEmail = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        if (phone.indexOf("@") == -1) {
            tEmail = "^1[3578]\\d{9}$";
        }
        Pattern pattern = Pattern
                .compile(tEmail);
        Matcher matcher = pattern.matcher(phone);
        if (matcher.matches()) {
            view.showJudgeMessage(null);
        } else {
            view.showJudgeMessage("邮箱/手机格式不正确");
            return;
        }
        button.setBackgroundColor(Color.parseColor("#142fdf"));
        button.setEnabled(true);

        HashMap<String, String> params = new HashMap<>();
        params.put("mobile", phone);
        params.put("password", password);
        service.loadUserLogin(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        view.showLoginMessage(loginBean);
                    }
                });
    }
}
