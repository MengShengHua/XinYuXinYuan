package com.example.xinyuxinyuan.view.activity.home.zhaolaoshi.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.contract.bean.ZhaoLaoShiBean;
import com.example.xinyuxinyuan.contract.home.ZhaoLaoShi;
import com.example.xinyuxinyuan.presenter.home.ZhaoLaoShiPresenter;
import com.example.xinyuxinyuan.utils.ShareUtils;
import com.example.xinyuxinyuan.utils.zidingyi.MyViewPager;
import com.example.xinyuxinyuan.view.activity.home.zhaolaoshi.adpater.ZhaoViewPagerAdpater;
import com.example.xinyuxinyuan.view.activity.home.zhaolaoshi.fragment.ZhaoLaoShiFragment;

import java.util.ArrayList;
import java.util.List;

public class ZhaoLaoShiActivity extends BaseActivity implements View.OnClickListener {


    private ImageView title_fuyong_finish;
    private TextView title_fuyong_text;
    private TabLayout zhao_laoshi_tablayout;
    private MyViewPager zhao_laoshi_viewPager;
    private int userType = 5;
    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mTitle = new ArrayList<>();
    private ZhaoViewPagerAdpater zhaoViewPagerAdpater;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_zhao_lao_shi;
    }

    @Override
    protected void init() {
        title_fuyong_finish = findViewById(R.id.title_fuyong_finish);
        title_fuyong_text = findViewById(R.id.title_fuyong_text);
        zhao_laoshi_tablayout = findViewById(R.id.zhao_laoshi_tablayout);
        zhao_laoshi_viewPager = findViewById(R.id.zhao_laoshi_viewPager);

        zhaoViewPagerAdpater = new ZhaoViewPagerAdpater(getSupportFragmentManager(), mFragments, mTitle);
        zhao_laoshi_viewPager.setAdapter(zhaoViewPagerAdpater);
        zhao_laoshi_tablayout.setupWithViewPager(zhao_laoshi_viewPager);
        title_fuyong_finish.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        if (zhaoViewPagerAdpater.getCount() == 0) {
            mTitle.add("大师");
            mTitle.add("名师");
            mTitle.add("达人");
            for (int i = 0; i < mTitle.size(); i++) {
                --userType;
                ZhaoLaoShiFragment zhaoLaoShiFragment = new ZhaoLaoShiFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("userType", userType);
                zhaoLaoShiFragment.setArguments(bundle);
                mFragments.add(zhaoLaoShiFragment);
            }
        }
        zhaoViewPagerAdpater.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_fuyong_finish:
                finish();
                break;
        }
    }
}
