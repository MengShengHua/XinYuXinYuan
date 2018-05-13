package com.example.xinyuxinyuan.view.activity.home.zhaolaoshi.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseFragment;
import com.example.xinyuxinyuan.contract.bean.ZhaoLaoShiBean;
import com.example.xinyuxinyuan.contract.home.ZhaoLaoShi;
import com.example.xinyuxinyuan.presenter.home.ZhaoLaoShiPresenter;
import com.example.xinyuxinyuan.utils.ShareUtils;
import com.example.xinyuxinyuan.view.activity.home.zhaolaoshi.activity.XiangQingActivity;
import com.example.xinyuxinyuan.view.activity.home.zhaolaoshi.adpater.ZhaoLaoShiAdpater;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhaoLaoShiFragment extends BaseFragment implements ZhaoLaoShi.View {

    private RecyclerView zhao_laoshi_fragment_recyclerView;
    private int userType;
    private ZhaoLaoShiPresenter zhaoLaoShiPresenter;
    List<ZhaoLaoShiBean.DataBean.ListBean> mList = new ArrayList<>();
    private ZhaoLaoShiAdpater zhaoLaoShiAdpater;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhao_lao_shi;
    }

    @Override
    protected void init(View view) {
        Bundle arguments = getArguments();
        userType = arguments.getInt("userType");
        zhao_laoshi_fragment_recyclerView = view.findViewById(R.id.zhao_laoshi_fragment_recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        zhao_laoshi_fragment_recyclerView.setLayoutManager(gridLayoutManager);
        zhaoLaoShiAdpater = new ZhaoLaoShiAdpater(getContext(), mList, userType);
        zhao_laoshi_fragment_recyclerView.setAdapter(zhaoLaoShiAdpater);
        //实例化P层对象
        zhaoLaoShiPresenter = new ZhaoLaoShiPresenter(this);
        //点击事件
        zhaoLaoShiAdpater.getItemClick(new ZhaoLaoShiAdpater.MyFace() {
            @Override
            public void setItemClick(View view, int position) {
                ZhaoLaoShiBean.DataBean.ListBean listBean = mList.get(position);
                Intent intent = new Intent(getContext(), XiangQingActivity.class);
                intent.putExtra("teacherId",listBean.get_$Id231());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void loadData() {
        zhaoLaoShiPresenter.loadZhaoLaoShiData(ShareUtils.getLoginUserId(), "" + userType, 1);
    }

    @Override
    public void showZhaoLaoShiData(ZhaoLaoShiBean zhaoLaoShiBean) {
        if (zhaoLaoShiAdpater.getItemCount() == 0) {
            mList.addAll(zhaoLaoShiBean.getData().getList());
        }
        zhaoLaoShiAdpater.notifyDataSetChanged();
    }
}
