package com.example.xinyuxinyuan.presenter.message;

import com.example.xinyuxinyuan.contract.bean.FansBean;
import com.example.xinyuxinyuan.contract.bean.OrderMessageBean;
import com.example.xinyuxinyuan.contract.message.OrderRemindContract;
import com.example.xinyuxinyuan.model.message.MessageRemindModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asd on 2018/5/13.
 */

public class OrderRemindPresenter implements OrderRemindContract.OrderRemindContractPresenter {
    private OrderRemindContract.OrderRemindContractView view;
    private final MessageRemindModel service;

    public OrderRemindPresenter(OrderRemindContract.OrderRemindContractView view) {
        this.view = view;
        service = RetrofitUtils.getRetrofitUtils().getService(MessageRemindModel.class);
    }

    /**
     * 订单提醒
     *
     * @param useId
     */
    @Override
    public void loadOrderRemind(String useId) {
        HashMap<String, String> params = new HashMap<>();
        params.put("loginUserId", useId);
        service.getOrderRemind(ShareUtils.getToken(), params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<OrderMessageBean>() {
                    @Override
                    public void accept(OrderMessageBean orderMessageBean) throws Exception {
                        view.showOrderRemind(orderMessageBean);
                    }
                });
    }
}
