package com.example.xinyuxinyuan.presenter;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.xinyuxinyuan.contract.bean.JavaBean;
import com.example.xinyuxinyuan.contract.ForPasswordContract;
import com.example.xinyuxinyuan.model.regist.RegistModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asd on 2018/5/5.
 */

public class ForPasswordPersenter implements ForPasswordContract.ForPasswordPresenter {
    private ForPasswordContract.ForPasswordView view;
    private  RegistModel service;

    public ForPasswordPersenter(ForPasswordContract.ForPasswordView view) {
        this.view = view;
         service = RetrofitUtils.getRetrofitUtils().getService(RegistModel.class);
    }

    /**
     * 判断手机号框，控制清空图片的显示
     *
     * @param phone
     */
    @Override
    public void loadJudgePhone(String phone, Button button, ImageView imageView) {
        if (phone.length() != 11 || !(phone.startsWith("1"))) {
            button.setBackgroundColor(Color.parseColor("#e6e3e3"));
            button.setEnabled(false);
            return;
        } else if (phone.equals("")) {
            imageView.setVisibility(View.GONE);
            button.setBackgroundColor(Color.parseColor("#e6e3e3"));
            button.setEnabled(false);
            return;
        }
        button.setBackgroundColor(Color.parseColor("#142fdf"));
        button.setEnabled(true);
    }

    /**
     * 根据手机号发送验证码
     *
     * @param phone
     */
    @Override
    public void loadSenYanZhengMa(String phone, Button button) {
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
     * 判断验证码框，控制清空图片的显示
     *
     * @param yanzhengma
     */
    @Override
    public void loadJudgeYanzhengma(String yanzhengma, Button button, ImageView imageView) {
        if (yanzhengma.length() < 6) {
            button.setBackgroundColor(Color.parseColor("#e6e3e3"));
            button.setEnabled(false);
            return;
        } else if (yanzhengma.equals("")) {
            imageView.setVisibility(View.GONE);
            button.setBackgroundColor(Color.parseColor("#e6e3e3"));
            button.setEnabled(false);
            return;
        }
        button.setBackgroundColor(Color.parseColor("#142fdf"));
        button.setEnabled(true);
    }


    /**
     * 点击下一步调用
     * 判断手机号验证码
     *
     * @param pgone
     * @param yanzhengma
     */
    @Override
    public void loadJudgeAll(String pgone, String yanzhengma) {
        if (pgone.length() != 11 && yanzhengma.length() != 6) {
            view.showYanZhengMaMessage("账号或验证码不正确");
            return;
        }
        HashMap<String, String> params = new HashMap<>();
        params.put("mobile", pgone);
        params.put("mobileValidCode", yanzhengma);
        service.loadRegister(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<JavaBean>() {
                    @Override
                    public void accept(JavaBean javaBean) throws Exception {
                        view.showNextStep(javaBean);
                    }
                });

    }
}
