package com.example.xinyuxinyuan.presenter.api;

import android.util.Log;

import com.example.xinyuxinyuan.contract.Bean.APIBean;
import com.example.xinyuxinyuan.model.home.APIModel;
import com.example.xinyuxinyuan.utils.DataUtils;
import com.example.xinyuxinyuan.utils.EncryptUtil;
import com.example.xinyuxinyuan.utils.RetrofitUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 键盘上的手艺人 on 2018/5/4.
 */

public class APIPresenter {

    public void loadApiToken() {
        Map<String, Integer> params = new HashMap<>();
        params.put("loginUserId", 0);
        RetrofitUtils.getRetrofitUtils().getService(APIModel.class)
                .loadApiToken(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<APIBean>() {

                    private String jiemahouToken = null;

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(APIBean apiBean) {
                        String apptoken = apiBean.getData().getApptoken();
                        //先把apptoken进行解码
                        try {
                            jiemahouToken = EncryptUtil.decrypt(apptoken);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //获取到系统当前时间
                        long time = System.currentTimeMillis();
                        //拼接系统时间在加密  移除换行  全部转为大写
                        String newApptoken = EncryptUtil.encrypt(time + jiemahouToken).replaceAll("\\n", "").toUpperCase();

                        ShareUtils.setToken(newApptoken, time);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.getMessage();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
