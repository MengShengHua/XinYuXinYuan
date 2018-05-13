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
public class WaitForMoneyFragment extends BaseFragment implements OrderContract.OrderContractView {


    private ListView orderMoneyFragment_listview;
    private ImageView orderMoneyFragment_NoDataImg;
    private TextView orderMoneyFragment_NoDataTv;
    private OrderAllPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wait_for_money;
    }

    @Override
    protected void init(View view) {
        orderMoneyFragment_listview = view.findViewById(R.id.orderMoneyFragment_Recy);
        orderMoneyFragment_NoDataImg = view.findViewById(R.id.orderMoneyFragment_NoDataImg);
        orderMoneyFragment_NoDataTv = view.findViewById(R.id.orderMoneyFragment_NoDataTv);
    }

    @Override
    protected void loadData() {
        presenter = new OrderAllPresenter(this);
        presenter.loaAlldOrder(LoginShareUtils.getUserMessage(getContext(), "id"), "0");

    }

    @Override
    public void showAlldOrder(OrderAllBean orderBean) {

        if (orderBean.getData().getSize() == 0) {
            orderMoneyFragment_listview.setVisibility(View.GONE);
            orderMoneyFragment_NoDataImg.setVisibility(View.VISIBLE);
            orderMoneyFragment_NoDataTv.setVisibility(View.VISIBLE);
        } else {
            orderMoneyFragment_NoDataImg.setVisibility(View.GONE);
            orderMoneyFragment_NoDataTv.setVisibility(View.GONE);
            List<OrderAllBean.DataBean.ListBean> list = orderBean.getData().getList();
            OrderAllAdapter orderAllAdapter = new OrderAllAdapter(list, getContext(), getResources());
            orderMoneyFragment_listview.setAdapter(orderAllAdapter);
        }
    }
}
