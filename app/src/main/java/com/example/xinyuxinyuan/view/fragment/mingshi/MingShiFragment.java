package com.example.xinyuxinyuan.view.fragment.mingshi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baoyz.widget.PullRefreshLayout;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseFragment;
import com.example.xinyuxinyuan.contract.bean.MingShiBean;
import com.example.xinyuxinyuan.contract.home.MingShi;
import com.example.xinyuxinyuan.presenter.home.MingShiPresenter;
import com.example.xinyuxinyuan.utils.MyScrollView;
import com.example.xinyuxinyuan.utils.zidingyi.CustomDrawable;
import com.example.xinyuxinyuan.view.activity.home.HomeActivity;
import com.example.xinyuxinyuan.view.activity.home.xianshangke.XianShangKeActivity;
import com.example.xinyuxinyuan.view.activity.home.zhaolaoshi.ZhaoLaoShiActivity;
import com.example.xinyuxinyuan.view.activity.login.LoginActivity;
import com.example.xinyuxinyuan.view.activity.messagesetting.MessageSettingActivity;
import com.example.xinyuxinyuan.view.fragment.mingshi.adpater.KeChengTuiJian_Adpater;
import com.example.xinyuxinyuan.view.fragment.mingshi.adpater.MingShiTuiJian_Adpater;
import com.example.xinyuxinyuan.view.fragment.mingshi.adpater.TuiJianZuoYe_Adpater;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;
/**
 * A simple {@link Fragment} subclass.
 */
public class MingShiFragment extends BaseFragment implements MingShi.View, View.OnClickListener {


    private MingShiPresenter mingShiPresenter;
    private FlyBanner mingshi_flyBanner;
    private LinearLayout mingshi_zhaolaoshi;
    private LinearLayout mingshi_xianshangke;
    private LinearLayout mingshi_jiaozuoye;
    private LinearLayout mingshi_xianxiake;
    private LinearLayout mingshi_liaoyikao;
    private RelativeLayout yi_qi_liao_yikao;
    private RecyclerView tuijian_zuoye_recyclerView;
    private RecyclerView kecheng_tuijian_recyclerView;
    private RecyclerView mingshi_tuijian_recyclerView;
    private TextView tuijian_zuoye_gengduo;
    private TextView kecheng_gengduo;
    private TextView mingshi_gengduo;
    private ImageView title_message_image;
    private List<String> lunBoList = new ArrayList<>();
    List<MingShiBean.DataBean.UsersBean> userList = new ArrayList<>();
    List<MingShiBean.DataBean.LiveCoursesBean> kechengList = new ArrayList<>();
    List<MingShiBean.DataBean.HomewoksBean> zuoyeList = new ArrayList<>();
    private MyScrollView mingshi_myScrollView;
    private PullRefreshLayout mingshi_pullRefreshLayout;
    private MingShiTuiJian_Adpater mingShiTuiJian_adpater;
    private KeChengTuiJian_Adpater keChengTuiJian_adpater;
    private TuiJianZuoYe_Adpater tuiJianZuoYe_adpater;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ming_shi;
    }

    @Override
    protected void init(View view) {
        mingShiPresenter = new MingShiPresenter(this);
        mingshi_pullRefreshLayout = view.findViewById(R.id.mingshi_pullRefreshLayout);
        //开启上拉刷新
        mingshi_pullRefreshLayout.setRefreshing(true);

        mingshi_myScrollView = view.findViewById(R.id.mingshi_myScrollView);
        mingshi_flyBanner = view.findViewById(R.id.mingshi_FlyBanner);
        mingshi_zhaolaoshi = view.findViewById(R.id.mingshi_zhaolaoshi);
        mingshi_xianshangke = view.findViewById(R.id.mingshi_xianshangke);
        mingshi_jiaozuoye = view.findViewById(R.id.mingshi_jiaozuoye);
        mingshi_liaoyikao = view.findViewById(R.id.mingshi_liaoyikao);
        mingshi_xianxiake = view.findViewById(R.id.mingshi_xianxiake);
        mingshi_gengduo = view.findViewById(R.id.mingshi_gengduo);
        kecheng_gengduo = view.findViewById(R.id.kecheng_gengduo);
        tuijian_zuoye_gengduo = view.findViewById(R.id.tuijian_zuoye_gengduo);
        mingshi_tuijian_recyclerView = view.findViewById(R.id.mingshi_tuijian_recyclerView);
        kecheng_tuijian_recyclerView = view.findViewById(R.id.kecheng_tuijian_recyclerView);
        tuijian_zuoye_recyclerView = view.findViewById(R.id.tuijian_zuoye_recyclerView);
        yi_qi_liao_yikao = view.findViewById(R.id.yi_qi_liao_yikao);
        title_message_image = view.findViewById(R.id.title_message_image);
        /*
        * 这是设置名师推荐的linearLayoutManager
        * */
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        //设置水平滑动
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mingshi_tuijian_recyclerView.setLayoutManager(linearLayoutManager);



        /*
        * 这是设置课程推荐的linearLayoutManager
        * */
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        //设置水平滑动
        kecheng_tuijian_recyclerView.setLayoutManager(gridLayoutManager);



         /*
        * 这是设置推荐作业的linearLayoutManager
        * */
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        tuijian_zuoye_recyclerView.setLayoutManager(linearLayoutManager2);

        //这是上拉刷新滑动监听
        CustomDrawable cd= new CustomDrawable(getContext(), mingshi_pullRefreshLayout);
        mingshi_pullRefreshLayout.setRefreshDrawable(cd);
        mingshi_pullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                flashLoad();
                mingshi_pullRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mingShiPresenter.loadMingShiData();
                        mingshi_pullRefreshLayout.setRefreshing(false);
                    }
                },1000);
            }
        });

        //设置名师推荐的适配器
        mingShiTuiJian_adpater = new MingShiTuiJian_Adpater(getContext(),userList);
        mingshi_tuijian_recyclerView.setAdapter(mingShiTuiJian_adpater);

        //設置課程推薦的適配器
        keChengTuiJian_adpater = new KeChengTuiJian_Adpater(getContext(),kechengList);
        kecheng_tuijian_recyclerView.setAdapter(keChengTuiJian_adpater);

        //设置推荐作业的适配器
        tuiJianZuoYe_adpater = new TuiJianZuoYe_Adpater(getContext(),zuoyeList);
        tuijian_zuoye_recyclerView.setAdapter(tuiJianZuoYe_adpater);

        mingshi_zhaolaoshi.setOnClickListener(this);
        mingshi_xianshangke.setOnClickListener(this);
        mingshi_jiaozuoye.setOnClickListener(this);
        mingshi_xianxiake.setOnClickListener(this);
        mingshi_liaoyikao.setOnClickListener(this);
        title_message_image.setOnClickListener(this);
    }

    //重新加载数据
    private void flashLoad() {

        //清空轮播图的集合
        lunBoList.clear();
        //清空名师推荐的数据
        userList.clear();
        //清空课程推荐的数据
        kechengList.clear();
        //清空作业推荐的数据
        zuoyeList.clear();
        //再次请求数据
    }

    @Override
    protected void loadData() {
        mingShiPresenter.loadMingShiData();
//

    }


    //这是请求道数据的方法
    @Override
    public void showMingShiData(MingShiBean.DataBean data) {
        //这是设置轮播的数据
        if (lunBoList.size() == 0) {
            for (MingShiBean.DataBean.SystemAdsBean systemAdsBean : data.getSystemAds()) {
                lunBoList.add(systemAdsBean.getMobileImgUrl());
            }
            mingshi_flyBanner.setImagesUrl(lunBoList);
        }


        //这是名师推荐的数据
        if(mingShiTuiJian_adpater != null && mingShiTuiJian_adpater.getItemCount()==0){
            userList.addAll(data.getUsers());
            mingShiTuiJian_adpater.notifyDataSetChanged();
        }

        //这是课程推荐的数据
        if(keChengTuiJian_adpater != null && keChengTuiJian_adpater.getItemCount()==0){
            kechengList.addAll(data.getLiveCourses());
            keChengTuiJian_adpater.notifyDataSetChanged();
        }

        //这是推荐作业的数据
        if(tuiJianZuoYe_adpater != null && tuiJianZuoYe_adpater.getItemCount()==0){
            zuoyeList.addAll(data.getHomewoks());
            tuiJianZuoYe_adpater.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mingshi_zhaolaoshi:
                startActivity(new Intent(getContext(), ZhaoLaoShiActivity.class));
                break;
            case R.id.mingshi_xianshangke:
                startActivity(new Intent(getContext(), XianShangKeActivity.class));
                break;
            case R.id.mingshi_jiaozuoye:
                ((HomeActivity)getActivity()).zuo_ye_btn.setChecked(true);
                break;
            case R.id.mingshi_xianxiake:
                ((HomeActivity)getActivity()).yu_gao_btn.setChecked(true);
                break;
            case R.id.mingshi_liaoyikao:
                ((HomeActivity)getActivity()).bao_dian_btn.setChecked(true);
                ((HomeActivity)getActivity()).baoDianFragment.home_baodian_fragment_viewPager.setCurrentItem(2);
                break;
            case R.id.title_message_image:
                SharedPreferences loginPreferences = getContext().getSharedPreferences("Login", Context.MODE_PRIVATE);
        String phone = loginPreferences.getString("phone", "用户未登录");
        if ("用户未登录".equals(phone)) {
            startActivity(new Intent(getContext(), LoginActivity.class));
//                    getActivity().finish();
        } else {
            ////                用户登录了跳转消息提醒Activity
            startActivity(new Intent(getContext(), MessageSettingActivity.class));
//                    getActivity().finish();
        }
                break;
        }
    }
}
