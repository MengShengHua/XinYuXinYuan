package com.example.xinyuxinyuan.view.activity.wode.set;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;

public class IntroduceActivity extends BaseActivity {

    private ImageView multiplexingTitle_return;
    private TextView multiplexingTitle_title;
    private TextView univActivity_introduce1;
    private TextView univActivity_introduce2;

    private void initView() {
        multiplexingTitle_return = (ImageView) findViewById(R.id.multiplexingTitle_return);
        multiplexingTitle_title = (TextView) findViewById(R.id.multiplexingTitle_title);
        multiplexingTitle_title.setText("关于UvinStar");
        univActivity_introduce1 = (TextView) findViewById(R.id.univActivity_introduce1);
        univActivity_introduce2 = (TextView) findViewById(R.id.univActivity_introduce2);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_introduce;
    }

    @Override
    protected void init() {
        initView();
        multiplexingTitle_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
