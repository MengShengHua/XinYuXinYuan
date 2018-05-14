package com.example.xinyuxinyuan.view.activity.wode;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.xinyuxinyuan.App;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.contract.bean.JinDouPriceItemBean;
import com.example.xinyuxinyuan.contract.my.RechargeContract;
import com.example.xinyuxinyuan.presenter.my.RechargePresenter;
import com.example.xinyuxinyuan.utils.LoginShareUtils;
import com.example.xinyuxinyuan.utils.ToastUtils;
import com.example.xinyuxinyuan.view.activity.wode.adapter.RechargeAdapter;

import java.util.ArrayList;
import java.util.List;

public class RechargeActivity extends BaseActivity implements View.OnClickListener, RechargeContract.RechargeContractView {

    private ImageView multiplexingTitle_return;
    private TextView multiplexingTitle_title;
    private TextView rechareActivity_table;
    private TextView rechareActivity_phoneTest;
    private LinearLayout rechareActivity_phone;
    private TextView rechareActivity_balanceCount;
    private LinearLayout rechareActivity_balance;
    private ListView rechareActivity_listview;
    private PopupWindow popupWindow;
    private RechargePresenter presenter;
    private RechargeAdapter rechargeAdapter;
    private TextView asd;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_recharge;
    }

    @Override
    protected void init() {
        initView();
        View view = getLayoutInflater().inflate(R.layout.jindou_popup, null);
        TextView jindou_zhifubao = view.findViewById(R.id.jindou_zhifubao);
        jindou_zhifubao.setOnClickListener(this);
        TextView jindou_weixin = view.findViewById(R.id.jindou_weixin);
        jindou_weixin.setOnClickListener(this);
        Button jindou_dismiss = view.findViewById(R.id.jindou_dismiss);
        jindou_dismiss.setOnClickListener(this);

        popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
            }
        });


    }

    @Override
    protected void loadData() {
        presenter = new RechargePresenter(this);
        presenter.loadJinDouPriceItem(LoginShareUtils.getUserMessage(this, "id"));

    }


    private void initView() {
        asd = findViewById(R.id.asd);
//        返回上页面
        multiplexingTitle_return = (ImageView) findViewById(R.id.multiplexingTitle_return);
        multiplexingTitle_title = (TextView) findViewById(R.id.multiplexingTitle_title);
        multiplexingTitle_title.setText("充值中心");
        rechareActivity_table = (TextView) findViewById(R.id.rechareActivity_table);
//        手机号码
        rechareActivity_phoneTest = (TextView) findViewById(R.id.rechareActivity_phoneTest);
        rechareActivity_phoneTest.setText(LoginShareUtils.getUserMessage(this, "phone"));
        rechareActivity_phone = (LinearLayout) findViewById(R.id.rechareActivity_phone);
//        金豆数量
        rechareActivity_balanceCount = (TextView) findViewById(R.id.rechareActivity_balanceCount);
        rechareActivity_balance = (LinearLayout) findViewById(R.id.rechareActivity_balance);
        rechareActivity_listview = (ListView) findViewById(R.id.rechareActivity_listview);
        multiplexingTitle_return.setOnClickListener(this);
        rechareActivity_table.setOnClickListener(this);
        rechareActivity_phone.setOnClickListener(this);
        rechareActivity_balance.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.multiplexingTitle_return:
                finish();
                break;
            case R.id.rechareActivity_table:
//                跳转账单页面
                break;
            case R.id.jindou_zhifubao:
                ToastUtils.mainThread("支付宝功能开发中", 0);
                break;
            case R.id.jindou_weixin:
                ToastUtils.mainThread("微信功能开发中", 0);
                break;
            case R.id.jindou_dismiss:
                popupWindow.dismiss();
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        // popupWindow隐藏时恢复屏幕正常透明度
                        setBackgroundAlpha(1.0f);
                    }
                });

                break;
        }
    }

    @Override
    public void showJinDouPriceItem(JinDouPriceItemBean jinDouPriceItemBean) {
        List<JinDouPriceItemBean.DataBean> data = jinDouPriceItemBean.getData();
        rechargeAdapter = new RechargeAdapter(data, this);
        rechareActivity_listview.setAdapter(rechargeAdapter);
        rechargeAdapter.setOnClickListener(new RechargeAdapter.OnClickListener() {
            @Override
            public void onClick(View v, int location) {
                popupWindow.showAtLocation(rechareActivity_balanceCount, Gravity.BOTTOM, 0, 0);
                setBackgroundAlpha(0.5f);//设置屏幕透明度
                popupWindow.setAnimationStyle(R.style.PopupAnimation);
                popupWindow.setClippingEnabled(true);
            }
        });
    }
    public void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = (RechargeActivity.this).getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
        (RechargeActivity.this).getWindow().setAttributes(lp);
    }

}
