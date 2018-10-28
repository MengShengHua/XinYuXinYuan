package com.example.xinyuxinyuan.view.fragment.wode.order;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseFragment;
import com.example.xinyuxinyuan.model.bean.OrderAllBean;
import com.example.xinyuxinyuan.contract.my.order.OrderContract;
import com.example.xinyuxinyuan.presenter.my.order.OrderAllPresenter;
import com.example.xinyuxinyuan.utils.LoginShareUtils;
import com.example.xinyuxinyuan.view.activity.wode.order.OrderActivity;
import com.example.xinyuxinyuan.view.fragment.wode.adapter.OrderAllAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllOrderFragment extends BaseFragment implements OrderContract.OrderContractView {


    private ListView orderAllragment_ListView;
    private ImageView orderAllragment_NoDataImg;
    private TextView orderAllragment_NoDataTv;
    private OrderAllPresenter presenter;
    private OrderActivity orderActivity;
    public final String ALLORDER = "我的订单";
    public final String WAITFORMONEY = "待付款";
    public final String WAITFORSHIYONG = "待使用";
    public final String WAITFORRETURNGOODS = "待退货";

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_all_order;
    }

    @Override
    protected void init(View view) {
        orderAllragment_ListView = view.findViewById(R.id.orderAllragment_Recy);
        orderAllragment_NoDataImg = view.findViewById(R.id.orderAllragment_NoDataImg);
        orderAllragment_NoDataTv = view.findViewById(R.id.orderAllragment_NoDataTv);
    }

    @Override
    public void onResume() {
        super.onResume();
//        presenter.loaAlldOrder(LoginShareUtils.getUserMessage(getContext(), "id"), "-1");
    }

    @Override
    protected void loadData() {
        presenter = new OrderAllPresenter(this);
        presenter.loaAlldOrder(LoginShareUtils.getUserMessage(getContext(), "id"), "-1");


    }

    @Override
    public void showAlldOrder(OrderAllBean orderBean) {
        if (orderBean.getData().getSize() == 0) {
            orderAllragment_ListView.setVisibility(View.GONE);
            orderAllragment_NoDataImg.setVisibility(View.VISIBLE);
            orderAllragment_NoDataTv.setVisibility(View.VISIBLE);
        } else {
            orderAllragment_NoDataImg.setVisibility(View.GONE);
            orderAllragment_NoDataTv.setVisibility(View.GONE);
            List<OrderAllBean.DataBean.ListBean> list = orderBean.getData().getList();
            OrderAllAdapter orderAllAdapter = new OrderAllAdapter(list, getContext(), getResources());
            orderAllragment_ListView.setAdapter(orderAllAdapter);
        }
    }
}

