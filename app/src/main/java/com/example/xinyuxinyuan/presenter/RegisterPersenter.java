package com.example.xinyuxinyuan.presenter;

import android.graphics.Color;
import android.widget.Button;

import com.example.xinyuxinyuan.model.bean.JavaBean;
import com.example.xinyuxinyuan.contract.RegisterContract;
import com.example.xinyuxinyuan.utils.RetrofitUtils;
import com.example.xinyuxinyuan.model.regist.RegistModel;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asd on 2018/5/3.
 */

public class RegisterPersenter implements RegisterContract.RegisterPresenter {
    private RegisterContract.RegisterView view;
    private RegistModel service;

    public RegisterPersenter(RegisterContract.RegisterView view) {
        this.view = view;
        service = RetrofitUtils.getRetrofitUtils().getService(RegistModel.class);
    }

    /**
     * 控制手机号输入框的X号显示与不显示
     * true 为显示
     * flase 为不显示
     *
     * @param phone
     * @return
     */
    @Override
    public boolean loadPhone(String phone) {
        if (phone.length() != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void loadVerificationPhone(String phone) {

    }


    /**
     * 获取验证码
     *
     * @param phone
     */
    @Override
    public void loadYanZhengMa(Button button, String phone) {
        if (phone.length() == 11 && phone.startsWith("1")) {
            button.setEnabled(true);
            button.setBackgroundColor(Color.parseColor("#3F51B5"));
            HashMap<String, String> params = new HashMap<>();
            params.put("mobile", phone);
            service.loadYanZhengMa(params)
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
     * 点击登录时调用
     *
     * @param phone      手机号
     * @param yanzhengMa 验证码
     */
    @Override
    public void loadRegister(String phone, String yanzhengMa) {
        HashMap<String, String> params = new HashMap<>();
        params.put("mobile", phone);
        params.put("mobileValidCode", yanzhengMa);
        service.loadRegister(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<JavaBean>() {
                    @Override
                    public void accept(JavaBean javaBean) throws Exception {
                        view.showGoToPerfect(javaBean.getMessage());
                    }
                });

    }
}
