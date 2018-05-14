package com.example.xinyuxinyuan.view.activity.home.xianshangke.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseFragment;
import com.example.xinyuxinyuan.contract.bean.XianShangKeBean;
import com.example.xinyuxinyuan.contract.home.XianShangKe;
import com.example.xinyuxinyuan.presenter.home.XianShangKePresenter;
import com.example.xinyuxinyuan.utils.ShareUtils;
import com.example.xinyuxinyuan.view.activity.home.xianshangke.activity.XiangQing_Mai_Activity;
import com.example.xinyuxinyuan.view.activity.home.xianshangke.adpater.XianShangKeAdpater;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class XiangShangKeFragment extends BaseFragment implements XianShangKe.View {


    private TextView xian_shangke_fragment_text;
    private ImageView xian_shangke_fragment_image;
    private RecyclerView xian_shangke_fragment_recyclerView;
    private String type;
    private XianShangKePresenter xianShangKePresenter;
    List<XianShangKeBean.DataBean.ListBean> mList = new ArrayList<>();
    private XianShangKeAdpater xianShangKeAdpater;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_xiang_shang_ke;
    }

    @Override
    protected void init(View view) {
        Bundle arguments = getArguments();
        type = arguments.getString("type");
        xian_shangke_fragment_text = view.findViewById(R.id.xian_shangke_fragment_text);
        xian_shangke_fragment_image = view.findViewById(R.id.xian_shangke_fragment_image);
        xian_shangke_fragment_recyclerView = view.findViewById(R.id.xian_shangke_fragment_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        xian_shangke_fragment_recyclerView.setLayoutManager(linearLayoutManager);

        if(type.equals("讲堂")){
            xian_shangke_fragment_recyclerView.setVisibility(View.VISIBLE);
            xian_shangke_fragment_text.setVisibility(View.GONE);
            xian_shangke_fragment_image.setVisibility(View.GONE);
        }else{
            xian_shangke_fragment_recyclerView.setVisibility(View.GONE);
            xian_shangke_fragment_text.setVisibility(View.VISIBLE);
            xian_shangke_fragment_image.setVisibility(View.VISIBLE);
        }
        //设置适配器
        xianShangKeAdpater = new XianShangKeAdpater(getContext(),mList);
        xian_shangke_fragment_recyclerView.setAdapter(xianShangKeAdpater);

        //实例化P层对象
        xianShangKePresenter = new XianShangKePresenter(this);

        //点击事件
        xianShangKeAdpater.getItemClick(new XianShangKeAdpater.MyFace() {
            @Override
            public void setItemClick(View view, int position) {
                Intent intent = new Intent(getContext(), XiangQing_Mai_Activity.class);
                intent.putExtra("id",mList.get(position).getId());
                intent.putExtra("type",0);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void loadData() {
        //加载数据
        xianShangKePresenter.loadXianShangKeData(ShareUtils.getLoginUserId(),type,1);
    }

    //拿到数据
    @Override
    public void showXianShangKeData(XianShangKeBean xianShangKeBean) {
        if(xianShangKeAdpater.getItemCount() == 0){
            mList.addAll(xianShangKeBean.getData().getList());
        }
        xianShangKeAdpater.notifyDataSetChanged();
    }
}
