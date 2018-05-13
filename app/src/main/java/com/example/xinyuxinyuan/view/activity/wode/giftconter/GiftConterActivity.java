package com.example.xinyuxinyuan.view.activity.wode.giftconter;

import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.view.fragment.wode.detailed.DetailedFragment;
import com.example.xinyuxinyuan.view.fragment.wode.detailed.GiftFragment;

public class GiftConterActivity extends BaseActivity implements View.OnClickListener {

    private ImageView multiplexingTitle_return;
    private TextView multiplexingTitle_title;
    private TextView giftActivity_ReceiveGiftTv;
    private TextView giftActivity_ReceiveGiftColor;
    private LinearLayout giftActivity_ReceiveGift;
    private TextView giftActivity_ReceiveCashTv;
    private TextView giftActivity_ReceiveCashColor;
    private LinearLayout giftActivity_ReceiveCash;
    private FrameLayout giftActivity_Fragment;


    private void initView() {
        multiplexingTitle_return = (ImageView) findViewById(R.id.multiplexingTitle_return);
        multiplexingTitle_title = (TextView) findViewById(R.id.multiplexingTitle_title);
        multiplexingTitle_title.setText("明细");
        giftActivity_ReceiveGiftTv = (TextView) findViewById(R.id.giftActivity_ReceiveGiftTv);
        giftActivity_ReceiveGiftColor = (TextView) findViewById(R.id.giftActivity_ReceiveGiftColor);
//        收到的礼物
        giftActivity_ReceiveGift = (LinearLayout) findViewById(R.id.giftActivity_ReceiveGift);
        giftActivity_ReceiveCashTv = (TextView) findViewById(R.id.giftActivity_ReceiveCashTv);
        giftActivity_ReceiveCashColor = (TextView) findViewById(R.id.giftActivity_ReceiveCashColor);
//        现金收入
        giftActivity_ReceiveCash = (LinearLayout) findViewById(R.id.giftActivity_ReceiveCash);
        giftActivity_Fragment = (FrameLayout) findViewById(R.id.giftActivity_Fragment);
        multiplexingTitle_return.setOnClickListener(this);
        giftActivity_ReceiveGift.setOnClickListener(this);
        giftActivity_ReceiveCash.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gift;
    }

    @Override
    protected void init() {
        initView();

    }

    @Override
    protected void loadData() {
        replacetContenView(R.id.giftActivity_Fragment, GiftFragment.class, null);
        giftActivity_ReceiveGiftColor.setVisibility(View.VISIBLE);
        giftActivity_ReceiveGiftTv.setTextColor(Color.parseColor("#333333"));
        giftActivity_ReceiveCashTv.setTextColor(Color.parseColor("#ededed"));
        giftActivity_ReceiveCashColor.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.multiplexingTitle_return:
                finish();
                break;
            case R.id.giftActivity_ReceiveGift:
                giftActivity_ReceiveGiftColor.setVisibility(View.VISIBLE);
                giftActivity_ReceiveGiftTv.setTextColor(Color.parseColor("#333333"));
                giftActivity_ReceiveCashTv.setTextColor(Color.parseColor("#ededed"));
                giftActivity_ReceiveCashColor.setVisibility(View.GONE);
                replacetContenView(R.id.giftActivity_Fragment, GiftFragment.class, null);
                break;
            case R.id.giftActivity_ReceiveCash:
                giftActivity_ReceiveCashColor.setVisibility(View.VISIBLE);
                giftActivity_ReceiveGiftColor.setVisibility(View.GONE);
                giftActivity_ReceiveCashTv.setTextColor(Color.parseColor("#333333"));
                giftActivity_ReceiveGiftTv.setTextColor(Color.parseColor("#ededed"));
                replacetContenView(R.id.giftActivity_Fragment, DetailedFragment.class, null);
                break;
        }
    }
}
