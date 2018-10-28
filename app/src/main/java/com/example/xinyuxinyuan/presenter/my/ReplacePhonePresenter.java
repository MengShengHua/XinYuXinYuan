package com.example.xinyuxinyuan.presenter.my;

import android.graphics.Color;
import android.widget.Button;
import android.widget.ImageView;

import com.example.xinyuxinyuan.model.bean.JavaBean;
import com.example.xinyuxinyuan.model.bean.LoginBean;
import com.example.xinyuxinyuan.contract.my.ReplacePhoneContract;
import com.example.xinyuxinyuan.model.my.ReplacePhoneModel;
import com.example.xinyuxinyuan.model.regist.RegistModel;
import com.example.xinyuxinyuan.utils.JudgeUtils;
import com.example.xinyuxinyuan.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asd on 2018/5/8.
 */

public class ReplacePhonePresenter implements ReplacePhoneContract.ReplacePhoneContractPresenter {
    private ReplacePhoneContract.ReplacePhoneContractView view;
    private final ReplacePhoneModel service;
    private final RegistModel serviceRegist;

    public ReplacePhonePresenter(ReplacePhoneContract.ReplacePhoneContractView view) {
        this.view = view;

        service = RetrofitUtils.getRetrofitUtils().getService(ReplacePhoneModel.class);
        serviceRegist = RetrofitUtils.getRetrofitUtils().getService(RegistModel.class);
    }

    /**
     * 发送验证码
     *
     * @param phone
     * @param button
     */
    @Override
    public void loadSenYanZhengMa(String phone, Button button) {
        if (phone.length() == 11 && phone.startsWith("1")) {
            button.setEnabled(true);
            button.setBackgroundColor(Color.parseColor("#3F51B5"));
            HashMap<String, String> params = new HashMap<>();
            params.put("mobile", phone);
            serviceRegist.loadYanZhengMa(params)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.newThread())
                    .subscribe(new Consumer<JavaBean>() {
                        @Override
                        public void accept(JavaBean javaBean) throws Exception {
                            String message = javaBean.getMessage();
                            view.showYanZhengMaMessage(message);
                        }
                    });
        } else {
//            不符合
            button.setEnabled(false);
            button.setBackgroundColor(Color.parseColor("#979494"));
            view.showYanZhengMaMessage("手机格式有误");
        }
    }

    /**
     * 判断验证码位数
     *
     * @param yanZhengMa
     * @param button
     */
    @Override
    public void loadJudegYanZhengMa(String yanZhengMa, Button button) {
        if (yanZhengMa.length() == 6) {
//            符合
            button.setEnabled(true);
            button.setBackgroundColor(Color.parseColor("#3F51B5"));
        } else {
//            不符合
            button.setEnabled(false);
            button.setBackgroundColor(Color.parseColor("#979494"));
        }
    }

    /**
     * 判断输入的验证码是否正确
     *
     * @param yanZhengMa
     */
    @Override
    public void JudegYanZhengMaWrongPair(String phone, String yanZhengMa) {
        HashMap<String, String> params = new HashMap<>();
        params.put("mobile", phone);
        params.put("authCode", yanZhengMa);
        service.getVerificationYanZhengMa(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        view.showNextStep(loginBean);
                    }
                });
    }

    /**
     * 判断手机号
     *
     * @param phone
     * @param button
     * @param imageView
     */
    @Override
    public void loadJudegPhone(String phone, Button button, ImageView imageView) {
        JudgeUtils.judgePhone(phone, button, imageView);
    }

    @Override
    public void loadReplacePhone(String loginUserId, String ReplaceAfterPhone, String yanZhengMa) {
        HashMap<String, String> params = new HashMap<>();
        params.put("loginUserId", loginUserId);
        params.put("mobile", ReplaceAfterPhone);
        params.put("code", yanZhengMa);
        service.getReplacePhoe(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        view.showReplacePhone(loginBean);
                    }
                });
    }
}
