package com.example.xinyuxinyuan.view.fragment.baodian.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseFragment;
import com.example.xinyuxinyuan.contract.bean.BaoDianBean;
import com.example.xinyuxinyuan.contract.bean.BaoDian_LunBo_Bean;
import com.example.xinyuxinyuan.contract.home.BaoDian;
import com.example.xinyuxinyuan.presenter.home.BaoDianPresenter;
import com.example.xinyuxinyuan.view.fragment.baodian.adpater.FuYongAdpater;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FuYongFragment extends BaseFragment implements BaoDian.View{

    private RecyclerView fu_yong_recyclerView;
    private BaoDianPresenter baoDianPresenter;
    private int sortord;
    private int loginUserId;
    private int page;
    private int rows;
    private List<BaoDianBean.DataBean.ArtcircleListBean.ListBean> mList = new ArrayList<>();
    private FuYongAdpater fuYongAdpater;
    private ImageView fu_yong_image;
    private TextView fu_yong_text;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fu_yong;
    }

    @Override
    protected void init(View view) {
        Bundle arguments = getArguments();
        sortord = arguments.getInt("sortord");
        loginUserId = arguments.getInt("loginUserId");
        page = arguments.getInt("page");
        rows = arguments.getInt("rows");
        fu_yong_image = view.findViewById(R.id.fu_yong_image);
        fu_yong_text = view.findViewById(R.id.fu_yong_text);

        fu_yong_recyclerView = view.findViewById(R.id.fu_yong_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        fu_yong_recyclerView.setLayoutManager(linearLayoutManager);

        //实例化P层对象
        baoDianPresenter = new BaoDianPresenter(this);

        //设置适配器
        fuYongAdpater = new FuYongAdpater(getContext(),mList);
        fu_yong_recyclerView.setAdapter(fuYongAdpater);
    }

    @Override
    protected void loadData() {
        //加载数据
        baoDianPresenter.loadBaoDianData(sortord,loginUserId,page,rows);
    }

    @Override
    public void showBaoDianData(BaoDianBean baoDianBean) {
        if(baoDianBean.getData().getArtcircleCategories() == null){
            fu_yong_recyclerView.setVisibility(View.GONE);
            fu_yong_image.setVisibility(View.VISIBLE);
            fu_yong_text.setVisibility(View.VISIBLE);
        }else{
            fu_yong_recyclerView.setVisibility(View.VISIBLE);
            fu_yong_image.setVisibility(View.GONE);
            fu_yong_text.setVisibility(View.GONE);
            if(fuYongAdpater.getItemCount() == 0){
                mList.addAll(baoDianBean.getData().getArtcircleList().getList());
            }
            fuYongAdpater.notifyDataSetChanged();
        }
    }

    @Override
    public void showLunBoData(BaoDian_LunBo_Bean baoDian_lunBo_bean) {

    }

}
