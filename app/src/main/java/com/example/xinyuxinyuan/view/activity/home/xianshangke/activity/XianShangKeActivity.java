package com.example.xinyuxinyuan.view.activity.home.xianshangke.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.view.activity.home.xianshangke.adpater.XianShangKe_ViewPager_Adpater;
import com.example.xinyuxinyuan.view.activity.home.xianshangke.fragment.XiangShangKeFragment;

import java.util.ArrayList;
import java.util.List;

public class XianShangKeActivity extends BaseActivity implements View.OnClickListener {


    private ImageView title_fuyong_finish;
    private TextView title_fuyong_text;
    private TabLayout xian_shang_ke_tabLayout;
    private ViewPager xian_shang_ke_viewPager;
    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mTitle = new ArrayList<>();
    private XianShangKe_ViewPager_Adpater xianShangKe_viewPager_adpater;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_xian_shang_ke;
    }

    @Override
    protected void init() {
        title_fuyong_finish = findViewById(R.id.title_fuyong_finish);
        title_fuyong_text = findViewById(R.id.title_fuyong_text);
        title_fuyong_text.setText("直播课程");

        xian_shang_ke_tabLayout = findViewById(R.id.xian_shang_ke_tabLayout);
        xian_shang_ke_viewPager = findViewById(R.id.xian_shang_ke_viewPager);

        xianShangKe_viewPager_adpater = new XianShangKe_ViewPager_Adpater(getSupportFragmentManager(), mFragments, mTitle);
        xian_shang_ke_viewPager.setAdapter(xianShangKe_viewPager_adpater);
        xian_shang_ke_tabLayout.setupWithViewPager(xian_shang_ke_viewPager);
        title_fuyong_finish.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

        if (xianShangKe_viewPager_adpater != null && xianShangKe_viewPager_adpater.getCount() == 0) {
            mTitle.add("课程");
            mTitle.add("直播live");
            for (int i = 0; i < mTitle.size(); i++) {
                XiangShangKeFragment xiangShangKeFragment = new XiangShangKeFragment();
                Bundle bundle = new Bundle();

                if (i == 0) {
                    bundle.putString("type", "讲堂");
                } else {
                    bundle.putString("type", "师塾");
                }
                xiangShangKeFragment.setArguments(bundle);
                mFragments.add(xiangShangKeFragment);
            }
        }
        xianShangKe_viewPager_adpater.notifyDataSetChanged();
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
