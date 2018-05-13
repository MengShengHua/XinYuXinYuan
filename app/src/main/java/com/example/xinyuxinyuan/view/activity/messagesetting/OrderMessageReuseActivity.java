package com.example.xinyuxinyuan.view.activity.messagesetting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.contract.bean.FansBean;
import com.example.xinyuxinyuan.contract.bean.OrderMessageBean;
import com.example.xinyuxinyuan.contract.message.OrderRemindContract;
import com.example.xinyuxinyuan.presenter.message.OrderRemindPresenter;
import com.example.xinyuxinyuan.utils.LoginShareUtils;
import com.example.xinyuxinyuan.view.activity.messagesetting.adapter.OrderMessageAdapter;

import java.util.List;

public class OrderMessageReuseActivity extends BaseActivity implements View.OnClickListener, OrderRemindContract.OrderRemindContractView {

    private ImageView multiplexingTitle_return;
    private TextView multiplexingTitle_title;
    private TextView orderReuserActivity_NoDataTv;
    private ListView orderReuserActivity_ListView;
    private ImageView orderReuserActivity_NoDataImg;
    private OrderRemindPresenter presenter;

    private void initView() {
        multiplexingTitle_return = (ImageView) findViewById(R.id.multiplexingTitle_return);
        multiplexingTitle_title = (TextView) findViewById(R.id.multiplexingTitle_title);
        multiplexingTitle_title = (TextView) findViewById(R.id.multiplexingTitle_title);
        orderReuserActivity_ListView = (ListView) findViewById(R.id.orderReuserActivity_ListView);
        multiplexingTitle_title.setText("订单提醒");
        orderReuserActivity_NoDataImg = (ImageView) findViewById(R.id.orderReuserActivity_NoDataImg);
        orderReuserActivity_NoDataTv = (TextView) findViewById(R.id.orderReuserActivity_NoDataTv);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message_reuse;
    }

    @Override
    protected void init() {
        presenter = new OrderRemindPresenter(this);
        initView();
        multiplexingTitle_return.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        presenter.loadOrderRemind(LoginShareUtils.getUserMessage(this, "id"));
    }

    @Override
    public void onClick(View v) {
        finish();
    }

    @Override
    public void showOrderRemind(OrderMessageBean orderMessageBean) {
        if (orderMessageBean.getData().getSize() == 0) {
            orderReuserActivity_ListView.setVisibility(View.GONE);
            orderReuserActivity_NoDataTv.setVisibility(View.VISIBLE);
            orderReuserActivity_NoDataImg.setVisibility(View.VISIBLE);
        } else {
            List<?> list = orderMessageBean.getData().getList();
            orderReuserActivity_NoDataTv.setVisibility(View.GONE);
            orderReuserActivity_NoDataImg.setVisibility(View.GONE);
            orderReuserActivity_ListView.setVisibility(View.VISIBLE);
            OrderMessageAdapter adapter = new OrderMessageAdapter(list, OrderMessageReuseActivity.this);
            orderReuserActivity_ListView.setAdapter(adapter);

        }
    }
}
