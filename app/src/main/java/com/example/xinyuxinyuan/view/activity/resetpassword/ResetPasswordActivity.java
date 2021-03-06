package com.example.xinyuxinyuan.view.activity.resetpassword;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.model.bean.ResetBean;
import com.example.xinyuxinyuan.contract.ResetPasswordContract;
import com.example.xinyuxinyuan.presenter.ResetPasswordPresenter;
import com.example.xinyuxinyuan.utils.LoginShareUtils;
import com.example.xinyuxinyuan.utils.ToastUtils;
import com.example.xinyuxinyuan.view.activity.login.LoginActivity;

public class ResetPasswordActivity extends BaseActivity implements View.OnClickListener, ResetPasswordContract.ResetPasswordView {


    private ImageView resetpassword_return;
    private TextView multiplexingTitle_title;
    private TextView resetpassword_Tv_newPassword;
    private EditText resetpassword_password;
    private ImageView resetpassword_clearpassword;
    private EditText resetpassword_newPassword;
    private ImageView resetpassword_clearnewPassword;
    private Button resetpaswword_nextStep;
    private ResetPasswordPresenter presenter;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;
    private String key;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_reset_password;
    }

    @Override
    protected void init() {
        resetpassword_return = (ImageView) findViewById(R.id.multiplexingTitle_return);
        multiplexingTitle_title = (TextView) findViewById(R.id.multiplexingTitle_title);
        resetpassword_Tv_newPassword = (TextView) findViewById(R.id.resetpassword_Tv_newPassword);
        resetpassword_password = (EditText) findViewById(R.id.resetpassword_password);
        resetpassword_clearpassword = (ImageView) findViewById(R.id.resetpassword_clearpassword);
        resetpassword_newPassword = (EditText) findViewById(R.id.resetpassword_newPassword);
        resetpassword_clearnewPassword = (ImageView) findViewById(R.id.resetpassword_clearnewPassword);
        resetpaswword_nextStep = (Button) findViewById(R.id.resetpaswword_nextStep);

    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        key = intent.getStringExtra("key");
        if (key != null) {
            if (key.equals("更换密码")) {
                multiplexingTitle_title.setText("修改密码");
                multiplexingTitle_title.setTextColor(Color.parseColor("#142fdf"));
                resetpassword_Tv_newPassword.setVisibility(View.VISIBLE);
                resetpassword_Tv_newPassword.setVisibility(View.VISIBLE);
            }
        } else {
            multiplexingTitle_title.setText("重置密码");
            multiplexingTitle_title.setTextColor(Color.parseColor("#142fdf"));
            resetpassword_Tv_newPassword.setVisibility(View.GONE);
        }
        sharedPreferences = getSharedPreferences("Register", MODE_PRIVATE);
        presenter = new ResetPasswordPresenter(this);
        OnClickListener();
        resetpassword_password.addTextChangedListener(new TextWatcher() {
            @Override
//            时
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                resetpassword_clearpassword.setVisibility(View.VISIBLE);
            }

            @Override
//            前
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
//            后
            public void afterTextChanged(Editable s) {
                presenter.loadJudgePassword(resetpassword_password.getText().toString().trim(), resetpaswword_nextStep, resetpassword_clearnewPassword);
            }
        });
        resetpassword_newPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                resetpassword_clearnewPassword.setVisibility(View.VISIBLE);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.loadJudgePassword(resetpassword_newPassword.getText().toString().trim(), resetpaswword_nextStep, resetpassword_clearpassword);

            }
        });
    }

    private void OnClickListener() {
        resetpassword_clearpassword.setOnClickListener(this);
        resetpassword_clearnewPassword.setOnClickListener(this);
        resetpaswword_nextStep.setOnClickListener(this);
        resetpassword_return.setOnClickListener(this);
        resetpaswword_nextStep.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String phone = sharedPreferences.getString("forPhone", "未获取到数据");
        edit = sharedPreferences.edit();
        switch (v.getId()) {
            case R.id.multiplexingTitle_return:
                finish();
                break;
            case R.id.resetpassword_clearpassword:
                resetpassword_password.setText("");
                resetpassword_clearpassword.setVisibility(View.GONE);
                break;
            case R.id.resetpassword_clearnewPassword:
                resetpassword_newPassword.setText("");
                resetpassword_clearnewPassword.setVisibility(View.GONE);
                break;
            case R.id.resetpaswword_nextStep:
//                重置密码返回为空
                if (key == null) {
                    presenter.loadOver(phone, resetpassword_password.getText().toString().trim(), resetpassword_newPassword.getText().toString().trim());
                } else {
                    presenter.loadOver(LoginShareUtils.getUserMessage(ResetPasswordActivity.this, "phone"), resetpassword_password.getText().toString().trim(), resetpassword_newPassword.getText().toString().trim());
                }
                break;
        }
    }

    @Override
    public void showMessage(String message) {
        ToastUtils.mainThread(message, 0);
    }

    @Override
    public void showResetOver(ResetBean resetBean) {
        int code = resetBean.getCode();
        if (code == 0) {
            //      将值传回登录页面
            ToastUtils.mainThread(resetBean.getMessage(), 0);
            Intent intent = new Intent(ResetPasswordActivity.this, LoginActivity.class);
            intent.putExtra("phone", resetBean.getData().getMobile());
            intent.putExtra("password", resetpassword_newPassword.getText().toString().trim());
            finish();
        } else {
            ToastUtils.mainThread(resetBean.getMessage(), 0);
        }

    }
}
