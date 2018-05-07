package com.example.xinyuxinyuan.view.fragment.zuoye.fragment;


import android.support.v4.app.Fragment;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class ZuiXinFragment extends BaseFragment implements ZuoYe.View{

    private RecyclerView zuixin_recyclerView;
    public ZuoYePresenter zuoYePresenter;
    private List<ZuoYeBean.DataBean.ListBean> mList = new ArrayList<>();
    private TouTingAdpater touTingAdpater;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zui_xin;
    }

    @Override
    protected void init(View view) {
        //实例化作业页面p层对象
        zuoYePresenter = new ZuoYePresenter(this);
        zuixin_recyclerView = view.findViewById(R.id.zuixin_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        zuixin_recyclerView.setLayoutManager(linearLayoutManager);

        //设置适配器
        touTingAdpater = new TouTingAdpater(getContext(),mList);
        zuixin_recyclerView.setAdapter(touTingAdpater);
    }

    @Override
    protected void loadData() {
        //加载数据
        zuoYePresenter.loadZuoYeData(2, ShareUtils.getLoginUserId(),ShareUtils.getPage(),20);
    }

    @Override
    public void showZuoYeData(ZuoYeBean zuoYeBean) {
        if(touTingAdpater.getItemCount() == 0){
            mList.addAll(zuoYeBean.getData().getList());
        }
        touTingAdpater.notifyDataSetChanged();
    }
}
