package com.example.xinyuxinyuan.view.fragment.wode.order;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
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
public class WaitForReturnGoodsFragment extends BaseFragment implements OrderContract.OrderContractView {


    private ListView orderReturnFragment_listview;
    private ImageView orderReturnFragment_NoDataImg;
    private TextView orderReturnFragment_NoDataTv;
    private OrderAllPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wait_for_return_goods;
    }

    @Override
    protected void init(View view) {
        orderReturnFragment_listview = view.findViewById(R.id.orderReturnFragment_listview);
        orderReturnFragment_NoDataImg = view.findViewById(R.id.orderReturnFragment_NoDataImg);
        orderReturnFragment_NoDataTv = view.findViewById(R.id.orderReturnFragment_NoDataTv);
    }

    @Override
    protected void loadData() {
        presenter = new OrderAllPresenter(this);
        presenter.loaAlldOrder(LoginShareUtils.getUserMessage(getContext(), "id"), "1");
    }

    @Override
    public void showAlldOrder(OrderAllBean orderBean) {
        if (orderBean.getData().getSize() == 0) {
            orderReturnFragment_listview.setVisibility(View.GONE);
            orderReturnFragment_NoDataImg.setVisibility(View.VISIBLE);
            orderReturnFragment_NoDataTv.setVisibility(View.VISIBLE);
        } else {
            orderReturnFragment_NoDataImg.setVisibility(View.GONE);
            orderReturnFragment_NoDataTv.setVisibility(View.GONE);
            List<OrderAllBean.DataBean.ListBean> list = orderBean.getData().getList();
            OrderAllAdapter orderAllAdapter = new OrderAllAdapter(list, getContext(), getResources());
            orderReturnFragment_listview.setAdapter(orderAllAdapter);
        }
    }
}
