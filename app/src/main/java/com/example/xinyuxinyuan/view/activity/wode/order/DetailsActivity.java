package com.example.xinyuxinyuan.view.activity.wode.order;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.contract.bean.LoginBean;
import com.example.xinyuxinyuan.contract.bean.OrderDetailsBean;
import com.example.xinyuxinyuan.contract.my.order.OrderDetailsContract;
import com.example.xinyuxinyuan.presenter.my.order.OrderDetailsPresenter;
import com.example.xinyuxinyuan.utils.ToastUtils;

public class DetailsActivity extends BaseActivity implements View.OnClickListener, OrderDetailsContract.OrderDetailsContractView {

    private ImageView multiplexingTitle_return;
    private TextView multiplexingTitle_title;
    private TextView detailsActivity_time;
    private TextView detailsActivity_startTime;
    private TextView detailsActivity_title;
    private ImageView detailsActivity_orderImg;
    private TextView detailsActivity_price;
    private TextView detailsActivity_orderNumber;
    private Button detailsActivity_CopyOrderNumber;
    private Button detailsActivity_orderPayment;
    private TextView detailsActivity_orderTime;
    private OrderDetailsPresenter presenter;
    private int mTimer = 180;
    private String oid;
    private String courseType;
    private OrderDetailsBean.DataBean.OrderInfoBean orderInfo;

    private void initView() {
        multiplexingTitle_return = (ImageView) findViewById(R.id.multiplexingTitle_return);
        multiplexingTitle_title = (TextView) findViewById(R.id.multiplexingTitle_title);
        multiplexingTitle_title.setText("订单详情");
//        倒计时
        detailsActivity_time = (TextView) findViewById(R.id.detailsActivity_time);
//        体验开播时间
        detailsActivity_startTime = (TextView) findViewById(R.id.detailsActivity_startTime);
//        课程标题
        detailsActivity_title = (TextView) findViewById(R.id.detailsActivity_title);
//        课程图片
        detailsActivity_orderImg = (ImageView) findViewById(R.id.detailsActivity_orderImg);
//        课程价格
        detailsActivity_price = (TextView) findViewById(R.id.detailsActivity_price);
//        订单号
        detailsActivity_orderNumber = (TextView) findViewById(R.id.detailsActivity_orderNumber);
//        复制按钮
        detailsActivity_CopyOrderNumber = (Button) findViewById(R.id.detailsActivity_CopyOrderNumber);
//        付款
        detailsActivity_orderPayment = (Button) findViewById(R.id.detailsActivity_orderPayment);
//        下单时间
        detailsActivity_orderTime = (TextView) findViewById(R.id.detailsActivity_orderTime);

        detailsActivity_CopyOrderNumber.setOnClickListener(this);
        multiplexingTitle_return.setOnClickListener(this);
        detailsActivity_orderPayment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String btData = detailsActivity_orderPayment.getText().toString().trim();
        switch (v.getId()) {
            case R.id.multiplexingTitle_return:
                finish();
                break;
            case R.id.detailsActivity_CopyOrderNumber:
//            跳转到讲师详情页面
                ClipboardManager copy = (ClipboardManager) DetailsActivity.this.getSystemService(Context.CLIPBOARD_SERVICE);
//                剪切到剪切板
//                调用方法，返回剪辑数据的类，如果文本为空返回 Item is null ，
                copy.setText(orderInfo.getOrderNo() + "");
                break;
            case R.id.detailsActivity_orderPayment:
                if (btData.equals("付款")) {
                    Intent intent = new Intent(this, PaymentActivity.class);
                    intent.putExtra("img", orderInfo.getCoverImg());
                    intent.putExtra("price", orderInfo.getPrice() + "");
                    startActivity(intent);
                } else {
//                    执行删除订单的操作
                    presenter.loadDeletetOrder(oid);
                }

                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    protected void init() {
        initView();
        Intent intent = getIntent();
        oid = intent.getStringExtra("oid");
        courseType = intent.getStringExtra("courseType");
        presenter = new OrderDetailsPresenter(this);
        presenter.loadOrderDetails(oid, courseType + "课");

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void showOrderDetails(OrderDetailsBean detailsBean) {
        orderInfo = detailsBean.getData().getOrderInfo();
        detailsActivity_title.setText(orderInfo.getTitle());
        Glide.with(DetailsActivity.this).load(orderInfo.getCoverImg()).into(detailsActivity_orderImg);
        detailsActivity_price.setText(orderInfo.getPrice() + "");
        detailsActivity_orderNumber.setText("订单编号：" + orderInfo.getOrderNo() + "");
        detailsActivity_orderTime.setText("下单时间：" + orderInfo.getCreateDate() + "");
        detailsActivity_startTime.setText("体验开播：" + orderInfo.getStartDate());
    }

    @Override
    public void showDeletetOrder(LoginBean detailsBean) {
        ToastUtils.mainThread(detailsBean.getMessage(), 0);
    }
}
