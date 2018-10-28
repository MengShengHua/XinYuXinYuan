package com.example.xinyuxinyuan.presenter.my.order;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xinyuxinyuan.model.bean.OrderAllBean;
import com.example.xinyuxinyuan.contract.my.order.OrderContract;
import com.example.xinyuxinyuan.model.my.order.OrderModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asd on 2018/5/11.
 */

public class OrderAllPresenter implements OrderContract.OrderContractPresenter {
    private OrderContract.OrderContractView view;
    private OrderModel service;

    public OrderAllPresenter(OrderContract.OrderContractView view) {
        this.view = view;
        service = RetrofitUtils.getRetrofitUtils().getService(OrderModel.class);
    }

    @Override
    public void loaAlldOrder(String userId, String status) {
        HashMap<String, String> params = new HashMap<>();
        params.put("loginUserId", userId);
        params.put("status", status);
        service.getOrderAll(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<OrderAllBean>() {
                    @Override
                    public void accept(OrderAllBean orderAllBean) throws Exception {
                        view.showAlldOrder(orderAllBean);
                    }
                });
    }

    /**
     * 有误数据的显示的视图
     * 返回true为有数据
     * @param listView
     * @param imageView
     * @param textView
     */
    @Override
    public boolean loadJudgeView(List<OrderAllBean.DataBean.ListBean> list, ListView listView, ImageView imageView, TextView textView) {
        if (list == null) {
            listView.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.VISIBLE);
            return false;
        } else {
            listView.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);
            return true;
        }
    }
}
