package com.example.xinyuxinyuan.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(),container,false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        loadData();
    }

    //统一加载布局
    protected abstract int getLayoutId();
    //统一做数据初始化
    protected abstract void init(View view);
    //统一加载数据
    protected abstract void loadData();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
