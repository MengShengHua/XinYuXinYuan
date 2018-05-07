package com.example.xinyuxinyuan.view.fragment.zuoye.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseFragment;
import com.example.xinyuxinyuan.contract.Bean.ZuoYeBean;
import com.example.xinyuxinyuan.contract.home.ZuoYe;
import com.example.xinyuxinyuan.presenter.home.ZuoYePresenter;
import com.example.xinyuxinyuan.utils.ShareUtils;
import com.example.xinyuxinyuan.view.fragment.zuoye.adpater.TouTingAdpater;

import java.util.ArrayList;
import java.util.List;


public class ZhiNengFragment extends BaseFragment implements ZuoYe.View{


    private RecyclerView zhineng_recyclerView;
    public  ZuoYePresenter zuoYePresenter;
    private List<ZuoYeBean.DataBean.ListBean> mList = new ArrayList<>();
    private TouTingAdpater touTingAdpater;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhi_neng;
    }

    @Override
    protected void init(View view) {
        //实例化作业页面p层对象
        zuoYePresenter = new ZuoYePresenter(this);

        zhineng_recyclerView = view.findViewById(R.id.zhineng_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        zhineng_recyclerView.setLayoutManager(linearLayoutManager);

        //设置适配器
        touTingAdpater = new TouTingAdpater(getContext(),mList);
        zhineng_recyclerView.setAdapter(touTingAdpater);
    }

    @Override
    protected void loadData() {
        //加载数据
        zuoYePresenter.loadZuoYeData(0, ShareUtils.getLoginUserId(),ShareUtils.getPage(),20);
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
