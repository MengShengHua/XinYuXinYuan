package com.example.xinyuxinyuan.view.activity.wode.set;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.xinyuxinyuan.App;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.view.activity.univ.UnivStarActivity;

public class AboutUnivStarActivity extends BaseActivity implements View.OnClickListener {

    private ImageView multiplexingTitle_return;
    private TextView multiplexingTitle_title;
    private LinearLayout aboutUnivActivity_introduce;
    private TextView aboutUnivActivity_VersionNumber;
    private LinearLayout aboutUnivActivity_VersionTest;
    private PopupWindow popupWindow;

    private void initView() {
        multiplexingTitle_return = (ImageView) findViewById(R.id.multiplexingTitle_return);
        multiplexingTitle_title = (TextView) findViewById(R.id.multiplexingTitle_title);
        multiplexingTitle_title.setText("关于UnivStar");
        aboutUnivActivity_introduce = (LinearLayout) findViewById(R.id.aboutUnivActivity_introduce);
        aboutUnivActivity_VersionNumber = (TextView) findViewById(R.id.aboutUnivActivity_VersionNumber);
        aboutUnivActivity_VersionTest = (LinearLayout) findViewById(R.id.aboutUnivActivity_VersionTest);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about_univ_star;
    }

    @Override
    protected void init() {
        initView();
        multiplexingTitle_return.setOnClickListener(this);
        aboutUnivActivity_introduce.setOnClickListener(this);
        aboutUnivActivity_VersionTest.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.multiplexingTitle_return:
                finish();
                break;
            case R.id.aboutUnivActivity_introduce:
//                关于介绍，我们跳转注册时的UnivStar的协议Activity
                Intent intent = new Intent(AboutUnivStarActivity.this, IntroduceActivity.class);
                startActivity(intent);
                break;
            case R.id.aboutUnivActivity_VersionTest:
                View inflate = getLayoutInflater().inflate(R.layout.aboutuniv_popup, null);
                Button aboutUvivPopup_Confirm = inflate.findViewById(R.id.aboutUvivPopup_Confirm);
                aboutUvivPopup_Confirm.setOnClickListener(this);
                popup(inflate);
                break;
            case R.id.aboutUvivPopup_Confirm:
                popupWindow.dismiss();
                break;
        }
    }

    private void popup(View view) {
        popupWindow = new PopupWindow(AboutUnivStarActivity.this);
        popupWindow.setContentView(view);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFCCCCCC")));
        //                参数一：显示在那个控件上
        popupWindow.showAtLocation(aboutUnivActivity_VersionTest, Gravity.CENTER, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

}
