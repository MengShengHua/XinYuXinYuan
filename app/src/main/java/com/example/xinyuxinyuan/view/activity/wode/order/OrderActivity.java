package com.example.xinyuxinyuan.view.activity.wode.order;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.view.fragment.wode.order.AllOrderFragment;
import com.example.xinyuxinyuan.view.fragment.wode.order.WaitForMoneyFragment;
import com.example.xinyuxinyuan.view.fragment.wode.order.WaitForReturnGoodsFragment;
import com.example.xinyuxinyuan.view.fragment.wode.order.WaitForShiYongFragment;

public class OrderActivity extends BaseActivity implements View.OnClickListener {

    private ImageView multiplexingTitle_return;
    private TextView multiplexingTitle_title;
    private TextView orderActivity_All;
    private TextView orderActivity_AllColor;
    private TextView orderActivity_daifukuang;
    private TextView orderActivity_daifukuangColor;
    private TextView orderActivity_daishiyong;
    private TextView orderActivity_daishiyongColor;
    private TextView orderActivity_tuihuo;
    private TextView orderActivity_tuihuoColor;
    private FrameLayout orderActivity_FrameLayout;

    private void initView() {
        multiplexingTitle_return = (ImageView) findViewById(R.id.multiplexingTitle_return);
        multiplexingTitle_title = (TextView) findViewById(R.id.multiplexingTitle_title);
        multiplexingTitle_title.setText("我的订单");
        orderActivity_All = (TextView) findViewById(R.id.orderActivity_All);
        orderActivity_AllColor = (TextView) findViewById(R.id.orderActivity_AllColor);
        orderActivity_daifukuang = (TextView) findViewById(R.id.orderActivity_daifukuang);
        orderActivity_daifukuangColor = (TextView) findViewById(R.id.orderActivity_daifukuangColor);
        orderActivity_daishiyong = (TextView) findViewById(R.id.orderActivity_daishiyong);
        orderActivity_daishiyongColor = (TextView) findViewById(R.id.orderActivity_daishiyongColor);
        orderActivity_tuihuo = (TextView) findViewById(R.id.orderActivity_tuihuo);
        orderActivity_tuihuoColor = (TextView) findViewById(R.id.orderActivity_tuihuoColor);
        orderActivity_FrameLayout = (FrameLayout) findViewById(R.id.orderActivity_FrameLayout);
        multiplexingTitle_return.setOnClickListener(this);
        orderActivity_All.setOnClickListener(this);
        orderActivity_daifukuang.setOnClickListener(this);
        orderActivity_daishiyong.setOnClickListener(this);
        orderActivity_tuihuo.setOnClickListener(this);
    }

    public final String ALLORDER = "我的订单";
    public final String WAITFORMONEY = "待付款";
    public final String WAITFORSHIYONG = "待使用";
    public final String WAITFORRETURNGOODS = "待退货";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    protected void init() {
        initView();
        Intent intent = getIntent();
//        判断在上个界面点击是哪个控件，需要跳转到哪个fragment
        String order = intent.getStringExtra("order");
        switch (order) {
            case ALLORDER:
                replacetContenView(R.id.orderActivity_FrameLayout, AllOrderFragment.class, null);
                orderActivity_AllColor.setVisibility(View.VISIBLE);
                orderActivity_All.setTextColor(Color.parseColor("#333333"));
                break;
            case WAITFORMONEY:
                replacetContenView(R.id.orderActivity_FrameLayout, WaitForMoneyFragment.class, null);
                orderActivity_daifukuangColor.setVisibility(View.VISIBLE);
                orderActivity_daifukuang.setTextColor(Color.parseColor("#333333"));
                break;
            case WAITFORSHIYONG:
                replacetContenView(R.id.orderActivity_FrameLayout, WaitForShiYongFragment.class, null);
                orderActivity_daishiyongColor.setVisibility(View.VISIBLE);
                orderActivity_daishiyong.setTextColor(Color.parseColor("#333333"));
                break;
            case WAITFORRETURNGOODS:
                replacetContenView(R.id.orderActivity_FrameLayout, WaitForReturnGoodsFragment.class, null);
                orderActivity_tuihuoColor.setVisibility(View.VISIBLE);
                orderActivity_tuihuo.setTextColor(Color.parseColor("#333333"));
                break;
        }
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.multiplexingTitle_return:
                finish();
                break;
            case R.id.orderActivity_All:
                replacetContenView(R.id.orderActivity_FrameLayout, AllOrderFragment.class, null);
                orderActivity_AllColor.setVisibility(View.VISIBLE);
                orderActivity_All.setTextColor(Color.parseColor("#333333"));
                orderActivity_daifukuang.setTextColor(Color.parseColor("#ededed"));
                orderActivity_daishiyong.setTextColor(Color.parseColor("#ededed"));
                orderActivity_tuihuo.setTextColor(Color.parseColor("#ededed"));
                orderActivity_daifukuangColor.setVisibility(View.GONE);
                orderActivity_daishiyongColor.setVisibility(View.GONE);
                orderActivity_tuihuoColor.setVisibility(View.GONE);
                break;
            case R.id.orderActivity_daifukuang:
                replacetContenView(R.id.orderActivity_FrameLayout, WaitForMoneyFragment.class, null);
                orderActivity_daifukuangColor.setVisibility(View.VISIBLE);
                orderActivity_daifukuang.setTextColor(Color.parseColor("#333333"));
                orderActivity_All.setTextColor(Color.parseColor("#ededed"));
                orderActivity_daishiyong.setTextColor(Color.parseColor("#ededed"));
                orderActivity_tuihuo.setTextColor(Color.parseColor("#ededed"));
                orderActivity_AllColor.setVisibility(View.GONE);
                orderActivity_daishiyongColor.setVisibility(View.GONE);
                orderActivity_tuihuoColor.setVisibility(View.GONE);
                break;
            case R.id.orderActivity_daishiyong:
                replacetContenView(R.id.orderActivity_FrameLayout, WaitForShiYongFragment.class, null);
                orderActivity_daishiyongColor.setVisibility(View.VISIBLE);
                orderActivity_daishiyong.setTextColor(Color.parseColor("#333333"));
                orderActivity_All.setTextColor(Color.parseColor("#ededed"));
                orderActivity_tuihuo.setTextColor(Color.parseColor("#ededed"));
                orderActivity_daifukuang.setTextColor(Color.parseColor("#ededed"));
                orderActivity_AllColor.setVisibility(View.GONE);
                orderActivity_tuihuoColor.setVisibility(View.GONE);
                orderActivity_daifukuangColor.setVisibility(View.GONE);
                break;
            case R.id.orderActivity_tuihuo:
                replacetContenView(R.id.orderActivity_FrameLayout, WaitForReturnGoodsFragment.class, null);
                orderActivity_tuihuoColor.setVisibility(View.VISIBLE);
                orderActivity_tuihuo.setTextColor(Color.parseColor("#333333"));
                orderActivity_All.setTextColor(Color.parseColor("#ededed"));
                orderActivity_daifukuang.setTextColor(Color.parseColor("#ededed"));
                orderActivity_daishiyong.setTextColor(Color.parseColor("#ededed"));
                orderActivity_daishiyongColor.setVisibility(View.GONE);
                orderActivity_AllColor.setVisibility(View.GONE);
                orderActivity_daifukuangColor.setVisibility(View.GONE);
                break;
        }
    }
}
