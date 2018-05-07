package com.example.xinyuxinyuan.presenter;

import android.graphics.Color;
import android.widget.Button;

import com.example.xinyuxinyuan.contract.Bean.JavaBean;
import com.example.xinyuxinyuan.contract.RegisterContract;
import com.example.xinyuxinyuan.model.regist.RegistModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asd on 2018/5/3.
 */

public class IpRegisterPersenter implements RegisterContract.RegisterPresenter {
    private RegisterContract.RegisterView view;
    private final RegistModel service;

    public IpRegisterPersenter(RegisterContract.RegisterView view) {
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

    /**
     * 验证手机号是否存在
     *
     * @param phone
     * @return
     */
    @Override
    public void loadVerificationPhone(String phone) {
        HashMap<String, String> params = new HashMap<>();
        params.put("mobile", phone);
        service.loadVverificationPhone(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<JavaBean>() {
                    @Override
                    public void accept(JavaBean javaBean) throws Exception {
                        String message = javaBean.getMessage();
                        view.showYanZhengMaMessage(message);
                    }
                });
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
     * 点击注册时调用
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
