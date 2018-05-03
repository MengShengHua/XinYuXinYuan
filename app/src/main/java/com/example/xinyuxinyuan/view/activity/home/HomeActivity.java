package com.example.xinyuxinyuan.view.activity.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.view.activity.login.LoginActivity;
import com.example.xinyuxinyuan.view.activity.register.RegisterActivity;
import com.example.xinyuxinyuan.view.fragment.baodian.BaoDianFragment;
import com.example.xinyuxinyuan.view.fragment.mingshi.MingShiFragment;
import com.example.xinyuxinyuan.view.fragment.wode.WoDeFragment;
import com.example.xinyuxinyuan.view.fragment.yugao.YuGaoFragment;
import com.example.xinyuxinyuan.view.fragment.zuoye.ZuoYeFragment;

public class HomeActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {


    private FrameLayout home_frameLayout;
    private RadioGroup home_radioGroup;
    private ImageView title_message_image;
    private ImageView title_qianbi_image;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void init() {
        title_qianbi_image = findViewById(R.id.title_qianbi_image);
        home_frameLayout = findViewById(R.id.home_frameLayout);
        home_radioGroup = findViewById(R.id.home_radioGroup);
        title_message_image = findViewById(R.id.title_message_image);
        title_message_image.setOnClickListener(this);
        home_radioGroup.setOnCheckedChangeListener(this);
        replacetContenView(R.id.home_frameLayout, MingShiFragment.class, null);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.ming_shi_btn:
                replacetContenView(R.id.home_frameLayout, MingShiFragment.class, null);
                title_qianbi_image.setVisibility(View.INVISIBLE);
                break;
            case R.id.zuo_ye_btn:
                replacetContenView(R.id.home_frameLayout, ZuoYeFragment.class, null);
                title_qianbi_image.setVisibility(View.INVISIBLE);
                break;
            case R.id.bao_dian_btn:
                replacetContenView(R.id.home_frameLayout, BaoDianFragment.class, null);
                title_qianbi_image.setVisibility(View.VISIBLE);
                break;
            case R.id.yu_gao_btn:
                replacetContenView(R.id.home_frameLayout, YuGaoFragment.class, null);
                title_qianbi_image.setVisibility(View.INVISIBLE);
                break;
            case R.id.wo_de_btn:
                replacetContenView(R.id.home_frameLayout, WoDeFragment.class, null);
                title_qianbi_image.setVisibility(View.INVISIBLE);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_message_image:
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                break;
            case R.id.title_qianbi_image:
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                break;
        }
    }
}
