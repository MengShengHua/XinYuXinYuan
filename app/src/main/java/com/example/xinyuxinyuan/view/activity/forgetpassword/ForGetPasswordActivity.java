package com.example.xinyuxinyuan.view.activity.forgetpassword;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.contract.Bean.JavaBean;
import com.example.xinyuxinyuan.contract.ForPasswordContract;
import com.example.xinyuxinyuan.presenter.ForPasswordPersenter;
import com.example.xinyuxinyuan.utils.ToastUtils;
import com.example.xinyuxinyuan.view.activity.login.LoginActivity;
import com.example.xinyuxinyuan.view.activity.resetpassword.ResetPasswordActivity;

public class ForGetPasswordActivity extends BaseActivity implements View.OnClickListener, ForPasswordContract.ForPasswordView {

    private ImageView forgetpassword_return;
    private EditText forgetpassword_phone;
    private ImageView forgetpassword_clearPhone;
    private EditText forgetpassword_Yanzhengma;
    private ImageView forgetpassword_clearPassword;
    private TextView forgetpassword_getYanZhengMa;
    private Button forgetpassword_nextStep;
    private ForPasswordPersenter persenter;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_for_get_password;
    }

    @Override
    protected void init() {
//        返回上一页
        forgetpassword_return = (ImageView) findViewById(R.id.forgetpassword_return);
//        手机号
        forgetpassword_phone = (EditText) findViewById(R.id.forgetpassword_phone);
//        清空手机号
        forgetpassword_clearPhone = (ImageView) findViewById(R.id.forgetpassword_clearPhone);
//        密码
        forgetpassword_Yanzhengma = (EditText) findViewById(R.id.forgetpassword_Yanzhengma);
//        清空密码
        forgetpassword_clearPassword = (ImageView) findViewById(R.id.forgetpassword_clearPassword);
//        发送验证码
        forgetpassword_getYanZhengMa = (TextView) findViewById(R.id.forgetpassword_getYanZhengMa);
//        下一步
        forgetpassword_nextStep = (Button) findViewById(R.id.forgetpassword_nextStep);


    }

    @Override
    protected void loadData() {
        persenter = new ForPasswordPersenter(this);
//        监听
        OnClickListener();
        forgetpassword_phone.addTextChangedListener(new TextWatcher() {
            @Override
//            变化时
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                forgetpassword_clearPhone.setVisibility(View.VISIBLE);
            }

            @Override
//            变化前
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
//            变化后
            public void afterTextChanged(Editable s) {
                persenter.loadJudgePhone(forgetpassword_phone.getText().toString().trim(), forgetpassword_nextStep, forgetpassword_clearPhone);
            }
        });
        forgetpassword_Yanzhengma.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                forgetpassword_clearPassword.setVisibility(View.VISIBLE);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                persenter.loadJudgeYanzhengma(forgetpassword_Yanzhengma.getText().toString().trim(), forgetpassword_nextStep, forgetpassword_clearPassword);
            }
        });
    }


    @Override
    public void onClick(View v) {
        sharedPreferences = getSharedPreferences("Register", MODE_PRIVATE);
        edit = sharedPreferences.edit();

        String password = forgetpassword_Yanzhengma.getText().toString().trim();
        String phone = forgetpassword_phone.getText().toString().trim();
        switch (v.getId()) {
            case R.id.forgetpassword_return:
                startActivity(new Intent(ForGetPasswordActivity.this, LoginActivity.class));
                finish();
                break;
            case R.id.forgetpassword_getYanZhengMa:
                persenter.loadSenYanZhengMa(phone, forgetpassword_nextStep);
                break;
            case R.id.forgetpassword_clearPassword:
                forgetpassword_Yanzhengma.setText("");
                forgetpassword_clearPassword.setVisibility(View.GONE);
                break;
            case R.id.forgetpassword_clearPhone:
                forgetpassword_phone.setText("");
                forgetpassword_clearPhone.setVisibility(View.GONE);
                break;
            case R.id.forgetpassword_nextStep:
                edit.putString("forPhone", phone);
                edit.commit();
                persenter.loadJudgeAll(phone, password);
                break;
        }
    }

    //    监听
    private void OnClickListener() {
        forgetpassword_nextStep.setOnClickListener(this);
        forgetpassword_return.setOnClickListener(this);
        forgetpassword_getYanZhengMa.setOnClickListener(this);
        forgetpassword_clearPassword.setOnClickListener(this);
        forgetpassword_clearPhone.setOnClickListener(this);
    }

    @Override
    public void showYanZhengMaMessage(String message) {
        ToastUtils.mainThread(message, 0);
    }

    @Override
    public void showNextStep(JavaBean javaBean) {

        if (!javaBean.getMessage().contains("错误")) {
            startActivity(new Intent(ForGetPasswordActivity.this, ResetPasswordActivity.class));
            finish();
        } else {
            ToastUtils.mainThread(javaBean.getMessage(), 0);
        }
    }
}
