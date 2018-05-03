package com.example.xinyuxinyuan.view.activity.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.view.activity.register.RegisterActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener {


    private TextView loginActivity_close;
    private TextView loginActivity_register;
    private EditText loginActivity_phone;
    private EditText loginActivity_password;
    private TextView loginActivity_forgetPassword;
    private Button loginActivity_Login;
    private ImageView loginActivity_weixin;
    private ImageView loginActivity_QQ;
    private ImageView loginActivity_weibo;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
//        关闭
        loginActivity_close = findViewById(R.id.loginActivity_close);
//        注册
        loginActivity_register = findViewById(R.id.loginActivity_register);
//        手机号框
        loginActivity_phone = findViewById(R.id.loginActivity_phone);
//        密码框
        loginActivity_password = findViewById(R.id.loginActivity_password);
//        忘记密码
        loginActivity_forgetPassword = findViewById(R.id.loginActivity_forgetPassword);
//        登录
        loginActivity_Login = findViewById(R.id.loginActivity_Login);
//        微信
        loginActivity_weixin = findViewById(R.id.loginActivity_weixin);
//        QQ
        loginActivity_QQ = findViewById(R.id.loginActivity_QQ);
//        微博
        loginActivity_weibo = findViewById(R.id.loginActivity_weibo);

        loginActivity_register.setOnClickListener(this);
        loginActivity_close.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginActivity_close:
                finish();
                break;
            case R.id.loginActivity_register:
//                跳转注册页面
                startActivityForResult(new Intent(LoginActivity.this, RegisterActivity.class), 100);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
