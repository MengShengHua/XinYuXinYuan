package com.example.xinyuxinyuan.view.activity.wode.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.utils.ToastUtils;


public class PaymentActivity extends BaseActivity implements View.OnClickListener {

    private ImageView multiplexingTitle_return;
    private TextView multiplexingTitle_title;
    private ImageView paymentActivity_Img;
    private TextView paymentActivity_time;
    private TextView paymentActivity_price;
    private RadioButton paymentActivity_weixin;
    private RadioButton paymentActivity_zhifubao;
    private RadioGroup paymentActivity_Rg;
    private Button paymentActivity_Bt_zhifu;

    private void initView() {
        multiplexingTitle_return = (ImageView) findViewById(R.id.multiplexingTitle_return);
        multiplexingTitle_title = (TextView) findViewById(R.id.multiplexingTitle_title);
        multiplexingTitle_title.setText("支付订单");
        paymentActivity_Img = (ImageView) findViewById(R.id.paymentActivity_Img);
        paymentActivity_time = (TextView) findViewById(R.id.paymentActivity_time);
        paymentActivity_price = (TextView) findViewById(R.id.paymentActivity_price);
        paymentActivity_weixin = (RadioButton) findViewById(R.id.paymentActivity_weixin);
        paymentActivity_zhifubao = (RadioButton) findViewById(R.id.paymentActivity_zhifubao);
        paymentActivity_Bt_zhifu = (Button) findViewById(R.id.paymentActivity_Bt_zhifu);
        paymentActivity_Rg = (RadioGroup) findViewById(R.id.paymentActivity_Rg);
        multiplexingTitle_return.setOnClickListener(this);
        paymentActivity_Bt_zhifu.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_payment;
    }

    @Override
    protected void init() {
        initView();

    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        String img = intent.getStringExtra("img");
        String price = intent.getStringExtra("price");
        Glide.with(this).load(img).into(paymentActivity_Img);
        paymentActivity_price.setText("$" + price);
        paymentActivity_Bt_zhifu.setText("确认支付$" + price);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.multiplexingTitle_return:
                finish();
                break;
            case R.id.paymentActivity_Bt_zhifu:
                if (paymentActivity_weixin.isChecked()) {
                    ToastUtils.mainThread("微信开发中", 0);
                } else if (paymentActivity_zhifubao.isChecked()) {
                    ToastUtils.mainThread("支付宝开发中", 0);

                }
                break;
        }
    }

}
