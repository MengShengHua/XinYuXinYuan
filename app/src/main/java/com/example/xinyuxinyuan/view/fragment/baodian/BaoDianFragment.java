package com.example.xinyuxinyuan.view.fragment.baodian;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.baoyz.widget.PullRefreshLayout;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseFragment;
import com.example.xinyuxinyuan.contract.bean.BaoDianBean;
import com.example.xinyuxinyuan.contract.bean.BaoDian_LunBo_Bean;
import com.example.xinyuxinyuan.contract.home.BaoDian;
import com.example.xinyuxinyuan.presenter.home.BaoDianPresenter;
import com.example.xinyuxinyuan.utils.ShareUtils;
import com.example.xinyuxinyuan.utils.zidingyi.MyViewPager;
import com.example.xinyuxinyuan.view.activity.login.LoginActivity;
import com.example.xinyuxinyuan.view.activity.messagesetting.MessageSettingActivity;
import com.example.xinyuxinyuan.view.fragment.baodian.adpater.BaoDianViewPagerAdpater;
import com.example.xinyuxinyuan.view.fragment.baodian.fragment.FuYongFragment;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaoDianFragment extends BaseFragment implements BaoDian.View, View.OnClickListener {


    private FlyBanner home_baodian_fragment_flyBanner;
    private PullRefreshLayout home_baodian_fragment_pullRefreshLayout;
    public TabLayout home_baodian_fragment_tablayout;
    public MyViewPager home_baodian_fragment_viewPager;
    private BaoDianPresenter baoDianPresenter;
    private List<String> lunboList = new ArrayList<>();
    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mTitle = new ArrayList<>();
    private BaoDianViewPagerAdpater baoDianViewPagerAdpater;
    private ImageView title_message_image;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bao_dian;
    }

    @Override
    protected void init(View view) {
        home_baodian_fragment_flyBanner = view.findViewById(R.id.home_baodian_fragment_flyBanner);
        home_baodian_fragment_pullRefreshLayout = view.findViewById(R.id.home_baodian_fragment_pullRefreshLayout);
        home_baodian_fragment_tablayout = view.findViewById(R.id.home_baodian_fragment_tablayout);
        home_baodian_fragment_viewPager = view.findViewById(R.id.home_baodian_fragment_viewPager);
        title_message_image = view.findViewById(R.id.title_message_image);

        //实例化P层对象
        baoDianPresenter = new BaoDianPresenter(this);
        //设置viewPager的适配器
        baoDianViewPagerAdpater = new BaoDianViewPagerAdpater(getChildFragmentManager(),mTitle,mFragments);
        home_baodian_fragment_viewPager.setAdapter(baoDianViewPagerAdpater);
        home_baodian_fragment_tablayout.setupWithViewPager(home_baodian_fragment_viewPager);

        if(mTitle.size() == 0){
            mTitle.add("智能筛选");
            mTitle.add("赞数最多");
            mTitle.add("最新评论");
        }

        //设置上拉刷新
        home_baodian_fragment_pullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                home_baodian_fragment_pullRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        home_baodian_fragment_pullRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
        title_message_image.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        //加载轮播图的数据
        baoDianPresenter.loadLunBoData();
        baoDianPresenter.loadBaoDianData(1,ShareUtils.getLoginUserId(),1,20);
    }


    @Override
    public void showBaoDianData(BaoDianBean baoDianBean) {
            if(baoDianViewPagerAdpater.getCount() == 0){
                List<BaoDianBean.DataBean.ArtcircleCategoriesBean> artcircleCategories = baoDianBean.getData().getArtcircleCategories();
                for (BaoDianBean.DataBean.ArtcircleCategoriesBean artcircleCategory : artcircleCategories) {
                    artcircleCategory.getName();
                    mTitle.add(artcircleCategory.getName());
                }
                for (int i = 0; i < mTitle.size(); i++) {
                    FuYongFragment fuYongFragment = new FuYongFragment();
                    mFragments.add(fuYongFragment);
                    Bundle bundle = new Bundle();
                    bundle.putInt("sortord", i);
                    bundle.putInt("loginUserId", ShareUtils.getLoginUserId());
                    bundle.putInt("page", 1);
                    bundle.putInt("rows", 20);
                    fuYongFragment.setArguments(bundle);
                }
                baoDianViewPagerAdpater.notifyDataSetChanged();
            }
    }

    //展示轮播的数据
    @Override
    public void showLunBoData(BaoDian_LunBo_Bean baoDian_lunBo_bean) {
        //这是设置轮播图的数据
        if (lunboList.size() == 0) {
            for (BaoDian_LunBo_Bean.DataBean.ListBean listBean : baoDian_lunBo_bean.getData().getList()) {
                lunboList.add(listBean.getMobileImgUrl());
            }
            home_baodian_fragment_flyBanner.setImagesUrl(lunboList);
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_message_image:
                SharedPreferences loginPreferences = getContext().getSharedPreferences("Login", Context.MODE_PRIVATE);
                String phone = loginPreferences.getString("phone", "用户未登录");
                if ("用户未登录".equals(phone)) {
                    startActivity(new Intent(getContext(), LoginActivity.class));
                    //getActivity().finish();
                }else {
                    //用户登录了跳转消息提醒Activity
                    startActivity(new Intent(getContext(), MessageSettingActivity.class));
                    //getActivity().finish();
                }
                break;
        }
    }
}
