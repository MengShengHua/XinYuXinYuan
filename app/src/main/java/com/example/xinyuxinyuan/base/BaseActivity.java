package com.example.xinyuxinyuan.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.xinyuxinyuan.App;

public abstract class BaseActivity extends AppCompatActivity {

    private BaseFragment lastFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        App.context = this;
        init();
        loadData();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    //统一加载布局
    protected abstract int getLayoutId();

    //统一做数据初始化
    protected abstract void init();

    //统一加载数据
    protected abstract void loadData();

    //统一管理fragment
    protected void replacetContenView(int containerId,Class<? extends BaseFragment> fragmentClass,Bundle params){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        //获取fragment类名
        String simpleName = fragmentClass.getSimpleName();
        BaseFragment fragment = (BaseFragment) manager.findFragmentByTag(simpleName);
        if(fragment == null){
            try {
                //根据java的动态代理来创建Fragment对象
                fragment = fragmentClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            transaction.add(containerId,fragment,simpleName);
        }

        if(fragment != null){
            //只有第一次创建的时候才能通过setArguments来进行参数传递
            fragment.setArguments(params);
        }

        if(lastFragment != null){
            transaction.hide(lastFragment);
        }
        transaction.show(fragment);
        lastFragment = fragment;
        transaction.commit();
    }
}