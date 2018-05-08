package com.example.xinyuxinyuan.view.activity.home;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.view.fragment.baodian.BaoDianFragment;
import com.example.xinyuxinyuan.view.fragment.mingshi.MingShiFragment;
import com.example.xinyuxinyuan.view.fragment.wode.MyInformationFragment;
import com.example.xinyuxinyuan.view.fragment.wode.WoDeFragment;
import com.example.xinyuxinyuan.view.fragment.yugao.YuGaoFragment;
import com.example.xinyuxinyuan.view.fragment.zuoye.ZuoYeFragment;

public class HomeActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {


    private RadioGroup home_radioGroup;

    public RadioButton ming_shi_btn;
    public RadioButton zuo_ye_btn;
    public RadioButton bao_dian_btn;
    public RadioButton yu_gao_btn;
    public RadioButton wo_de_btn;
    public BaoDianFragment baoDianFragment;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void init() {
        baoDianFragment = new BaoDianFragment();
        home_radioGroup = findViewById(R.id.home_radioGroup);

        ming_shi_btn = findViewById(R.id.ming_shi_btn);
        zuo_ye_btn = findViewById(R.id.zuo_ye_btn);
        bao_dian_btn = findViewById(R.id.bao_dian_btn);
        yu_gao_btn = findViewById(R.id.yu_gao_btn);
        wo_de_btn = findViewById(R.id.wo_de_btn);

        home_radioGroup.setOnCheckedChangeListener(this);
        ming_shi_btn = findViewById(R.id.ming_shi_btn);
        ming_shi_btn.setChecked(true);
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
