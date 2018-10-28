package com.example.xinyuxinyuan.view.fragment.zuoye.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseFragment;
import com.example.xinyuxinyuan.model.bean.ZuoYeBean;
import com.example.xinyuxinyuan.contract.home.ZuoYe;
import com.example.xinyuxinyuan.presenter.home.ZuoYePresenter;
import com.example.xinyuxinyuan.utils.ShareUtils;
import com.example.xinyuxinyuan.view.activity.home.zuoyexiangqing.ZuoYeXiangQingActivity;
import com.example.xinyuxinyuan.view.fragment.mingshi.adpater.TuiJianZuoYe_Adpater;
import com.example.xinyuxinyuan.view.fragment.zuoye.adpater.TouTingAdpater;

import java.util.ArrayList;
import java.util.List;


public class ZhiNengFragment extends BaseFragment implements ZuoYe.View{


    private RecyclerView zhineng_recyclerView;
    public  ZuoYePresenter zuoYePresenter;
    private List<ZuoYeBean.DataBean.ListBean> mList = new ArrayList<>();
    private TouTingAdpater touTingAdpater;
    private int sortord;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhi_neng;
    }

    @Override
    protected void init(View view) {

        Bundle arguments = getArguments();
        sortord = arguments.getInt("sortord");
        //实例化作业页面p层对象
        zuoYePresenter = new ZuoYePresenter(this);
        zhineng_recyclerView = view.findViewById(R.id.zhineng_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        zhineng_recyclerView.setLayoutManager(linearLayoutManager);

        //设置适配器
        touTingAdpater = new TouTingAdpater(getContext(),mList);
        zhineng_recyclerView.setAdapter(touTingAdpater);
        touTingAdpater.getItemClick(new TuiJianZuoYe_Adpater.MyFace() {
            @Override
            public void setItemClick(View view, int position) {
                Intent intent = new Intent(getContext(), ZuoYeXiangQingActivity.class);
                intent.putExtra("id",mList.get(position).getId());

                startActivity(intent);
            }
        });
    }

    @Override
    protected void loadData() {
        //加载数据
        zuoYePresenter.loadZuoYeData(sortord, ShareUtils.getLoginUserId(),ShareUtils.getPage(),20);
    }

    //拿到数据
    @Override
    public void showZuoYeData(ZuoYeBean zuoYeBean) {
        if(touTingAdpater.getItemCount() == 0){
            mList.addAll(zuoYeBean.getData().getList());
        }
        touTingAdpater.notifyDataSetChanged();
    }
}
