package com.example.xinyuxinyuan.view.fragment.zuoye.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseFragment;
import com.example.xinyuxinyuan.model.bean.ZuoYeBean;
import com.example.xinyuxinyuan.contract.home.ZuoYe;
import com.example.xinyuxinyuan.presenter.home.ZuoYePresenter;
import com.example.xinyuxinyuan.utils.ShareUtils;
import com.example.xinyuxinyuan.view.fragment.zuoye.adpater.TouTingAdpater;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TouTingFragment extends BaseFragment implements ZuoYe.View{


    public ZuoYePresenter zuoYePresenter;
    private RecyclerView touting_recyclerView;
    private List<ZuoYeBean.DataBean.ListBean> mList = new ArrayList<>();
    private TouTingAdpater touTingAdpater;

    public TouTingFragment() {

    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tou_ting;
    }

    @Override
    protected void init(View view) {
        //实例化作业页面p层对象
        zuoYePresenter = new ZuoYePresenter(this);

        touting_recyclerView = view.findViewById(R.id.touting_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        touting_recyclerView.setLayoutManager(linearLayoutManager);

        //设置适配器
        touTingAdpater = new TouTingAdpater(getContext(),mList);
        touting_recyclerView.setAdapter(touTingAdpater);
    }

    @Override
    protected void loadData() {
        //加载数据
        zuoYePresenter.loadZuoYeData(1, ShareUtils.getLoginUserId(),ShareUtils.getPage(),20);
    }

    //拿到请求到的数据
    @Override
    public void showZuoYeData(ZuoYeBean zuoYeBean) {
        if(touTingAdpater.getItemCount() == 0){
            mList.addAll(zuoYeBean.getData().getList());
        }
        touTingAdpater.notifyDataSetChanged();
    }
}
