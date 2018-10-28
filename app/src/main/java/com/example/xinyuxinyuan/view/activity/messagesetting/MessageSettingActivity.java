package com.example.xinyuxinyuan.view.activity.messagesetting;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xinyuxinyuan.App;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.model.bean.MessageRemindBean;
import com.example.xinyuxinyuan.contract.message.MessageRemindContract;
import com.example.xinyuxinyuan.presenter.message.MessageRemindPresenter;
import com.example.xinyuxinyuan.utils.LoginShareUtils;
import com.example.xinyuxinyuan.view.activity.messagesetting.adapter.MessageAdapter;

import java.util.List;

public class MessageSettingActivity extends BaseActivity implements View.OnClickListener, MessageRemindContract.MessageRemindView {

    private ImageView multiplexingTitle_return;
    private TextView multiplexingTitle_title;
    private RecyclerView messageActivity_recy;
    private MessageRemindPresenter presenter;
    private MessageAdapter messageAdapter;
    private Intent intent;
    private String countFans;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message_setting;
    }

    @Override
    protected void init() {
        presenter = new MessageRemindPresenter(this);
        multiplexingTitle_return = (ImageView) findViewById(R.id.multiplexingTitle_return);
        multiplexingTitle_title = (TextView) findViewById(R.id.multiplexingTitle_title);
        multiplexingTitle_title.setText("消息设置");
        messageActivity_recy = (RecyclerView) findViewById(R.id.messageActivity_recy);
        messageActivity_recy.setLayoutManager(new LinearLayoutManager(App.context));
        intent = new Intent(MessageSettingActivity.this, OrderMessageReuseActivity.class);


    }

    @Override
    protected void loadData() {
        multiplexingTitle_return.setOnClickListener(this);
        multiplexingTitle_title.setOnClickListener(this);
        Intent intent = getIntent();
        countFans = intent.getStringExtra("countFans");
//        请求数据，接口问题放弃请求
        presenter.loadMessageHome(LoginShareUtils.getUserMessage(App.context, "token"), Integer.parseInt(LoginShareUtils.getUserMessage(App.context, "id")));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.multiplexingTitle_return:
                finish();
                break;
        }
    }

    @Override
    public void showMessageHome(MessageRemindBean messageRemindBean) {
        List<MessageRemindBean.DataBean> dataBeanList = messageRemindBean.getData();
        messageAdapter = new MessageAdapter(dataBeanList);
        messageActivity_recy.setAdapter(messageAdapter);
        messageAdapter.setOnClickListener(new MessageAdapter.OnClickListener() {
            @Override
            public void onClick(View v, int location) {
                startActivity(intent);
            }
        });
    }
}
