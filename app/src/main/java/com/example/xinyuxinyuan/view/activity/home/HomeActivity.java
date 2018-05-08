package com.example.xinyuxinyuan.view.activity.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.example.xinyuxinyuan.App;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.presenter.api.APIPresenter;
import com.example.xinyuxinyuan.utils.LoginShareUtils;
import com.example.xinyuxinyuan.view.activity.login.LoginActivity;
import com.example.xinyuxinyuan.view.activity.messagesetting.MessageSettingActivity;
import com.example.xinyuxinyuan.view.activity.register.RegisterActivity;
import com.example.xinyuxinyuan.view.fragment.baodian.BaoDianFragment;
import com.example.xinyuxinyuan.view.fragment.mingshi.MingShiFragment;
import com.example.xinyuxinyuan.view.fragment.wode.MyInformationFragment;
import com.example.xinyuxinyuan.view.fragment.wode.WoDeFragment;
import com.example.xinyuxinyuan.view.fragment.yugao.YuGaoFragment;
import com.example.xinyuxinyuan.view.fragment.zuoye.ZuoYeFragment;

public class HomeActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {


    private FrameLayout home_frameLayout;
    private RadioGroup home_radioGroup;
    private ImageView title_message_image;
    private APIPresenter presenter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void init() {
        presenter = new APIPresenter();
        presenter.loadApiToken();
        home_frameLayout = findViewById(R.id.home_frameLayout);
        home_radioGroup = findViewById(R.id.home_radioGroup);
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
                break;
            case R.id.zuo_ye_btn:
                replacetContenView(R.id.home_frameLayout, ZuoYeFragment.class, null);
                break;
            case R.id.bao_dian_btn:
                replacetContenView(R.id.home_frameLayout, BaoDianFragment.class, null);
                break;
            case R.id.yu_gao_btn:
                replacetContenView(R.id.home_frameLayout, YuGaoFragment.class, null);
                break;
            case R.id.wo_de_btn:
                SharedPreferences login = getSharedPreferences("Login", MODE_PRIVATE);
                String nickname = login.getString("nickname", null);
                if (nickname == null) {
                    replacetContenView(R.id.home_frameLayout, WoDeFragment.class, null);
                } else {
                    replacetContenView(R.id.home_frameLayout, MyInformationFragment.class, null);
                }
                break;
        }
    }


}
