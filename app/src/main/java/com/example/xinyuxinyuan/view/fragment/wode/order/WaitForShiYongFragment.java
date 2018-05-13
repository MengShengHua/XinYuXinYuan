package com.example.xinyuxinyuan.view.fragment.wode.order;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseFragment;
import com.example.xinyuxinyuan.contract.bean.OrderAllBean;
import com.example.xinyuxinyuan.contract.my.order.OrderContract;
import com.example.xinyuxinyuan.presenter.my.order.OrderAllPresenter;
import com.example.xinyuxinyuan.utils.LoginShareUtils;
import com.example.xinyuxinyuan.view.fragment.wode.adapter.OrderAllAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WaitForShiYongFragment extends BaseFragment implements OrderContract.OrderContractView {


    private ListView orderShiYongFragment_listview;
    private ImageView orderShiYongFragment__NoDataImg;
    private TextView orderShiYongFragment__NoDataTv;
    private OrderAllPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wait_for_shi_yong;
    }

    @Override
    protected void init(View view) {
        orderShiYongFragment_listview = view.findViewById(R.id.orderShiYongFragment_listview);
        orderShiYongFragment__NoDataImg = view.findViewById(R.id.orderShiYongFragment__NoDataImg);
        orderShiYongFragment__NoDataTv = view.findViewById(R.id.orderShiYongFragment__NoDataTv);
    }

    @Override
    protected void loadData() {
        presenter = new OrderAllPresenter(this);
        presenter.loaAlldOrder(LoginShareUtils.getUserMessage(getContext(), "id"), "4");
    }

    @Override
    public void showAlldOrder(OrderAllBean orderBean) {
        if (orderBean.getData().getSize() == 0) {
            orderShiYongFragment_listview.setVisibility(View.GONE);
            orderShiYongFragment__NoDataImg.setVisibility(View.VISIBLE);
            orderShiYongFragment__NoDataTv.setVisibility(View.VISIBLE);
        } else {
            orderShiYongFragment__NoDataImg.setVisibility(View.GONE);
            orderShiYongFragment__NoDataTv.setVisibility(View.GONE);
            List<OrderAllBean.DataBean.ListBean> list = orderBean.getData().getList();
            OrderAllAdapter orderAllAdapter = new OrderAllAdapter(list, getContext(), getResources());
            orderShiYongFragment_listview.setAdapter(orderAllAdapter);
        }
    }
}
