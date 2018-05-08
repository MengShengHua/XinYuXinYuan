package com.example.xinyuxinyuan.view.activity.anim;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.presenter.api.APIPresenter;
import com.example.xinyuxinyuan.view.activity.home.HomeActivity;

public class AnimActivity extends BaseActivity implements AnimView, Animation.AnimationListener {

    private ImageView anim_image;
    private  APIPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_anim;
    }

    @Override
    protected void init() {
        anim_image = findViewById(R.id.anim_image);
        presenter = new APIPresenter();
        presenter.loadApiToken();
    }

    @Override
    protected void loadData() {
        startAnim();
    }

    @Override
    public void startAnim() {
        //Android7.0动态授权
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        anim_image.setAnimation(animation);
        animation.start();
        animation.setAnimationListener(this);
    }

    @Override
    public void goToActivity() {
        Intent intent = new Intent(AnimActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        goToActivity();
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
