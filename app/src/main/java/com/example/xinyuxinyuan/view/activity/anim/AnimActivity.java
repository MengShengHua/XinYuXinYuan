package com.example.xinyuxinyuan.view.activity.anim;

import android.content.Intent;
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
