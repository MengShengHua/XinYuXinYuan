package com.example.xinyuxinyuan.presenter.message;

import android.util.Log;

import com.example.xinyuxinyuan.App;
import com.example.xinyuxinyuan.contract.Bean.MessageRemindBean;
import com.example.xinyuxinyuan.contract.message.MessageRemindContract;
import com.example.xinyuxinyuan.model.message.MessageRemindModel;
import com.example.xinyuxinyuan.utils.LoginShareUtils;
import com.example.xinyuxinyuan.utils.RetrofitUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asd on 2018/5/7.
 */

public class MessageRemindPresenter implements MessageRemindContract.MessageRemindPresenter {
    private MessageRemindContract.MessageRemindView view;
    private MessageRemindModel service;

    public MessageRemindPresenter(MessageRemindContract.MessageRemindView view) {
        this.view = view;
        service = RetrofitUtils.getRetrofitUtils().getService(MessageRemindModel.class);
    }

    /**
     * 请求消息提醒页面的数据
     *  自我感觉接口有问题
     *  放弃请求
     * @param useId
     */
    @Override
    public void loadMessageHome(String token, Integer useId) {

        HashMap<String, Integer> params = new HashMap<>();
        HashMap<String, String> headerMap = new HashMap<>();

        headerMap.put("Authorization", token);
        params.put("loginUserId", useId);
        service.messageRemindBeanObservable(headerMap, params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<MessageRemindBean>() {
                    @Override
                    public void accept(MessageRemindBean messageRemindBean) throws Exception {
                        Log.e("===", messageRemindBean.toString());
                        view.showMessageHome(messageRemindBean);
                    }
                });
    }
}
