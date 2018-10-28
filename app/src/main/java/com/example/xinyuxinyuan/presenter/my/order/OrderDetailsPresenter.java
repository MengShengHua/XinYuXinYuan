package com.example.xinyuxinyuan.presenter.my.order;

import com.example.xinyuxinyuan.model.bean.LoginBean;
import com.example.xinyuxinyuan.model.bean.OrderDetailsBean;
import com.example.xinyuxinyuan.contract.my.order.OrderDetailsContract;
import com.example.xinyuxinyuan.model.my.order.OrderModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asd on 2018/5/11.
 */


public class OrderDetailsPresenter implements OrderDetailsContract.OrderDetailsContractPresenter {
    private OrderDetailsContract.OrderDetailsContractView view;
    private final OrderModel service;

    public OrderDetailsPresenter(OrderDetailsContract.OrderDetailsContractView view) {
        this.view = view;
        service = RetrofitUtils.getRetrofitUtils().getService(OrderModel.class);
    }

    /**
     * 获取用户订单的详情信息
     *
     * @param oid
     * @param courseType
     */
    @Override
    public void loadOrderDetails(String oid, String courseType) {
        HashMap<String, String> params = new HashMap<>();
        params.put("oid", oid);
        params.put("courseType", courseType);
        service.getOrderDetails(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<OrderDetailsBean>() {
                    @Override
                    public void accept(OrderDetailsBean detailsBean) throws Exception {
                        view.showOrderDetails(detailsBean);
                    }
                });
    }

    /**
     * 根据订单ID删除订单
     *
     * @param oid
     */
    @Override
    public void loadDeletetOrder(String oid) {
        HashMap<String, String> params = new HashMap<>();
        params.put("oid", oid);
        service.getDeleteOrder(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        view.showDeletetOrder(loginBean);
                    }
                });
    }
}
