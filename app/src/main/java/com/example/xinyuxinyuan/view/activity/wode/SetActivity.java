package com.example.xinyuxinyuan.view.activity.wode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.base.BaseFragment;
import com.example.xinyuxinyuan.presenter.my.SetPresenter;
import com.example.xinyuxinyuan.utils.LoginShareUtils;
import com.example.xinyuxinyuan.view.activity.home.HomeActivity;
import com.example.xinyuxinyuan.view.fragment.wode.MyInformationFragment;

public class SetActivity extends BaseActivity implements View.OnClickListener {

    private ImageView multiplexingTitle_return;
    private TextView multiplexingTitle_title;
    private TextView setActivity_BindingPhoneNumber;
    private LinearLayout setActivity_BindingPhone;
    private TextView setActivity_BindingShejiao;
    private LinearLayout setActivity_SheJiao;
    private TextView setActivity_modifyPassword;
    private LinearLayout setActivity_LoginPassword;
    private TextView setActivity_cacheSize;
    private LinearLayout setActivity_clearCache;
    private LinearLayout setActivity_UnivStar;
    private LinearLayout setActivity_outLogin;
    private SetPresenter presenter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_set;
    }

    @Override
    protected void init() {
        initView();
    }


    @Override
    protected void loadData() {
        multiplexingTitle_title.setText("设置");
        setActivity_BindingPhoneNumber.setText(LoginShareUtils.getUserMessage(SetActivity.this, "phone"));
        presenter = new SetPresenter();
        OnClickListener();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.multiplexingTitle_return:
                startActivity(new Intent(SetActivity.this, HomeActivity.class));
                finish();
                break;
            case R.id.setActivity_BindingPhone:

                break;
            case R.id.setActivity_SheJiao:

                break;
            case R.id.setActivity_LoginPassword:

                break;
            case R.id.setActivity_clearCache:

                break;
            case R.id.setActivity_UnivStar:

                break;
            case R.id.setActivity_outLogin:
//                退出登录清空数据
                SharedPreferences preferences = getSharedPreferences("Login", MODE_PRIVATE);
                presenter.loadClearUserAllData(preferences);
                startActivity(new Intent(SetActivity.this, HomeActivity.class));
                finish();
                break;
        }
    }

    private void initView() {
//        返回上页面图标
        multiplexingTitle_return = (ImageView) findViewById(R.id.multiplexingTitle_return);
//        标题
        multiplexingTitle_title = (TextView) findViewById(R.id.multiplexingTitle_title);
//        绑定的手机号码
        setActivity_BindingPhoneNumber = (TextView) findViewById(R.id.setActivity_BindingPhoneNumber);
//        换绑手机号
        setActivity_BindingPhone = (LinearLayout) findViewById(R.id.setActivity_BindingPhone);
//        是否绑定
        setActivity_BindingShejiao = (TextView) findViewById(R.id.setActivity_BindingShejiao);
//        社交账号绑定
        setActivity_SheJiao = (LinearLayout) findViewById(R.id.setActivity_SheJiao);
//       修改密码
        setActivity_modifyPassword = (TextView) findViewById(R.id.setActivity_modifyPassword);
//        登录密码
        setActivity_LoginPassword = (LinearLayout) findViewById(R.id.setActivity_LoginPassword);
//        缓存大小
        setActivity_cacheSize = (TextView) findViewById(R.id.setActivity_cacheSize);
//        清空缓存
        setActivity_clearCache = (LinearLayout) findViewById(R.id.setActivity_clearCache);
//        关于UnivStar
        setActivity_UnivStar = (LinearLayout) findViewById(R.id.setActivity_UnivStar);
//        退出登录
        setActivity_outLogin = (LinearLayout) findViewById(R.id.setActivity_outLogin);
    }

    private void OnClickListener() {
        multiplexingTitle_return.setOnClickListener(this);
        setActivity_BindingPhone.setOnClickListener(this);
        setActivity_SheJiao.setOnClickListener(this);
        setActivity_LoginPassword.setOnClickListener(this);
        setActivity_clearCache.setOnClickListener(this);
        setActivity_UnivStar.setOnClickListener(this);
        setActivity_outLogin.setOnClickListener(this);
    }
}
