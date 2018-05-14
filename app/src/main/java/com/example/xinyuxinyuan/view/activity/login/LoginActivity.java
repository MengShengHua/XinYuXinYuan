package com.example.xinyuxinyuan.view.activity.login;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xinyuxinyuan.App;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.contract.bean.LoginBean;
import com.example.xinyuxinyuan.contract.LoginContract;
import com.example.xinyuxinyuan.presenter.IpLoginPersenter;
import com.example.xinyuxinyuan.utils.LoginShareUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;
import com.example.xinyuxinyuan.utils.ToastUtils;
import com.example.xinyuxinyuan.view.activity.forgetpassword.ForGetPasswordActivity;
import com.example.xinyuxinyuan.view.activity.home.HomeActivity;
import com.example.xinyuxinyuan.view.activity.register.RegisterActivity;

import java.util.ArrayList;

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginContract.LoginView {


    private TextView loginActivity_close;
    private TextView loginActivity_register;
    private EditText loginActivity_phone;
    private EditText loginActivity_password;
    private TextView loginActivity_forgetPassword;
    private Button loginActivity_Login;
    private ImageView loginActivity_weixin;
    private ImageView loginActivity_QQ;
    private ImageView loginActivity_weibo;
    private ImageView loginActivity_clearPhone;
    private ImageView loginActivity_clearPassword;
    private IpLoginPersenter persenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        String phone = intent.getStringExtra("phone");
        String password = intent.getStringExtra("password");
//        关闭
        loginActivity_close = findViewById(R.id.loginActivity_close);
//        注册
        loginActivity_register = findViewById(R.id.loginActivity_register);
//        手机号框
        loginActivity_phone = findViewById(R.id.loginActivity_phone);
//        清空账号
        loginActivity_clearPhone = findViewById(R.id.loginActivity_clearPhone);
//        密码框
        loginActivity_password = findViewById(R.id.loginActivity_password);
//        清空密码
        loginActivity_clearPassword = findViewById(R.id.loginActivity_clearPassword);
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
        loginActivity_phone.setText(phone);
        loginActivity_password.setText(password);

    }

    @Override
    protected void loadData() {

        persenter = new IpLoginPersenter(this);
        loginActivity_clearPhone.setOnClickListener(this);
        loginActivity_clearPassword.setOnClickListener(this);
        loginActivity_register.setOnClickListener(this);
        loginActivity_close.setOnClickListener(this);
        loginActivity_weixin.setOnClickListener(this);
        loginActivity_QQ.setOnClickListener(this);
        loginActivity_weibo.setOnClickListener(this);
        loginActivity_forgetPassword.setOnClickListener(this);
        loginActivity_Login.setOnClickListener(this);
//        文本框的状态监听
        loginActivity_phone.addTextChangedListener(new TextWatcher() {
            @Override
//            变化时
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                loginActivity_clearPhone.setVisibility(View.VISIBLE);
            }

            @Override
//            变化前
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
//            变化后
            public void afterTextChanged(Editable s) {

                persenter.loadJudgePhone(loginActivity_phone.getText().toString().trim(), loginActivity_Login, loginActivity_clearPhone);
            }
        });
        loginActivity_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                loginActivity_clearPassword.setVisibility(View.VISIBLE);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                persenter.loadJudgePassword(loginActivity_password.getText().toString().trim(), loginActivity_Login, loginActivity_clearPassword);

            }
        });
    }

    @Override
    public void onClick(View v) {
        String phone = loginActivity_phone.getText().toString().trim();
        String password = loginActivity_password.getText().toString().trim();
        switch (v.getId()) {
            case R.id.loginActivity_close:
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                break;
            case R.id.loginActivity_register:
//                跳转注册页面
                startActivityForResult(new Intent(LoginActivity.this, RegisterActivity.class), 100);
                break;
            case R.id.loginActivity_Login:
                persenter.loadJudgeLogin(phone, password, loginActivity_Login);
                break;
            case R.id.loginActivity_weixin:
                ToastUtils.mainThread("微信登陆开发中", 0);
                break;
            case R.id.loginActivity_QQ:
                ToastUtils.mainThread("QQ登陆开发中", 0);
                break;
            case R.id.loginActivity_weibo:
                ToastUtils.mainThread("微博登陆开发中", 0);
                break;
            case R.id.loginActivity_forgetPassword:
                startActivity(new Intent(LoginActivity.this, ForGetPasswordActivity.class));
                finish();
                break;
            case R.id.loginActivity_clearPhone:
                loginActivity_phone.setText("");
                loginActivity_clearPhone.setVisibility(View.GONE);
                break;
            case R.id.loginActivity_clearPassword:
                loginActivity_password.setText("");
                loginActivity_clearPassword.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void showJudgeMessage(String Message) {
        if (Message != null) {
            ToastUtils.mainThread(Message, 0);

        }
    }

    @Override
    public void showLoginMessage(LoginBean loginBean) {
        if (loginBean.getMessage().contains("错误")) {
            ToastUtils.mainThread(loginBean.getMessage(), 0);
            return;
        }
        if (loginBean.getData() != null) {
//            登录成功，保存所返回的数据
            LoginShareUtils.UserMessage(App.context, loginBean.getData().getNickname(),
                    loginBean.getData().getMobile(),
                    loginBean.getData().getPhoto(),
                    loginBean.getData().getId(),
                    loginBean.getData().getToken());
            Log.e("昵称", loginBean.getData().getNickname());
            Log.e("手机号", loginBean.getData().getMobile());
            ToastUtils.mainThread("登录成功", 0);
            ShareUtils.setLoginUserId(Integer.parseInt(LoginShareUtils.getUserMessage(this,"id")));
            ArrayList<String> userAllMessage = LoginShareUtils.getUserAllMessage(LoginActivity.this);
            if (userAllMessage.size() == 5) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                intent.putExtra("fragment", "200");
                startActivity(intent);
                finish();
            }

        }
    }
}
