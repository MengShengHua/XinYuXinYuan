package com.example.xinyuxinyuan.base;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.style.BulletSpan;
import android.util.Log;

import com.example.xinyuxinyuan.App;

/**
 * finish 走onStop()方法
 */
public abstract class BaseActivity extends AppCompatActivity {

    private BaseFragment lastFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
        App.context = this;
        init();
        loadData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        App.context = this;
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        App.context = null;
//    }

    protected void onPause() {
        super.onPause();
//        App.context = null;
    }

    //统一加载布局
    protected abstract int getLayoutId();

    //统一做数据初始化
    protected abstract void init();

    //统一加载数据
    protected abstract void loadData();

    //统一管理fragment
    protected void replacetContenView(int containerId, Class<? extends BaseFragment> fragmentClass, Bundle params) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        //获取fragment类名
        String simpleName = fragmentClass.getSimpleName();
        BaseFragment fragment = (BaseFragment) manager.findFragmentByTag(simpleName);
        if (fragment == null) {
            try {
                //根据java的动态代理来创建Fragment对象
                fragment = fragmentClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            transaction.add(containerId, fragment, simpleName);
        }

        if (fragment != null) {
            //只有第一次创建的时候才能通过setArguments来进行参数传递
            fragment.setArguments(params);
        }

        if (lastFragment != null) {
            transaction.hide(lastFragment);
        }
        transaction.show(fragment);
        lastFragment = fragment;
        transaction.commit();
    }
}