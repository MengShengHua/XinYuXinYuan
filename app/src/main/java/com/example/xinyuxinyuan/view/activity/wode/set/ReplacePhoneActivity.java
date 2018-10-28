package com.example.xinyuxinyuan.view.activity.wode.set;

import android.content.Intent;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.model.bean.LoginBean;
import com.example.xinyuxinyuan.contract.my.ReplacePhoneContract;
import com.example.xinyuxinyuan.presenter.my.ReplacePhonePresenter;
import com.example.xinyuxinyuan.utils.LoginShareUtils;
import com.example.xinyuxinyuan.utils.ToastUtils;
import com.example.xinyuxinyuan.view.activity.home.HomeActivity;
import com.example.xinyuxinyuan.view.activity.resetpassword.ResetPasswordActivity;

public class ReplacePhoneActivity extends BaseActivity implements View.OnClickListener, ReplacePhoneContract.ReplacePhoneContractView {

    private ImageView multiplexingTitle_return;
    private TextView multiplexingTitle_title;
    private EditText replaceActivity_YanZhengMa;
    private TextView replaceActivity_GetYanZhengMa;
    private ImageView replaceActivity_clearYanZhengMa;
    private Button replaceActivity_NextStep;
    private TextView replaceActivity_phone;
    private ReplacePhonePresenter presenter;
    private String phone;
    //    实现倒计时
    private int Time = 60;
    private String key;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_replace_password;
    }

    @Override
    protected void init() {
        multiplexingTitle_return = (ImageView) findViewById(R.id.multiplexingTitle_return);
        multiplexingTitle_title = (TextView) findViewById(R.id.multiplexingTitle_title);
        multiplexingTitle_title.setText("更换密码");
        multiplexingTitle_title.setTextColor(Color.parseColor("#142fdf"));
        replaceActivity_YanZhengMa = (EditText) findViewById(R.id.replaceActivity_YanZhengMa);
        replaceActivity_GetYanZhengMa = (TextView) findViewById(R.id.replaceActivity_GetYanZhengMa);
        replaceActivity_clearYanZhengMa = (ImageView) findViewById(R.id.replaceActivity_clearYanZhengMa);
        replaceActivity_NextStep = (Button) findViewById(R.id.replaceActivity_NextStep);
        replaceActivity_phone = (TextView) findViewById(R.id.replaceActivity_phone);
        multiplexingTitle_return.setOnClickListener(this);
        replaceActivity_GetYanZhengMa.setOnClickListener(this);
        replaceActivity_clearYanZhengMa.setOnClickListener(this);
        replaceActivity_NextStep.setOnClickListener(this);
        replaceActivity_YanZhengMa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                replaceActivity_clearYanZhengMa.setVisibility(View.VISIBLE);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                presenter.loadJudegYanZhengMa(replaceActivity_YanZhengMa.getText().toString().trim(), replaceActivity_NextStep);
            }
        });
        replaceActivity_GetYanZhengMa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (replaceActivity_GetYanZhengMa.getText().toString().trim().equals("获取验证码")) {
                    replaceActivity_GetYanZhengMa.setEnabled(true);
                } else {
                    replaceActivity_GetYanZhengMa.setEnabled(false);
                }
            }
        });

    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        key = intent.getStringExtra("key");
        presenter = new ReplacePhonePresenter(this);
        replaceActivity_phone.setText("手机号：" + LoginShareUtils.getUserMessage(ReplacePhoneActivity.this, "phone"));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.multiplexingTitle_return:
                startActivity(new Intent(ReplacePhoneActivity.this, HomeActivity.class));
                finish();
                break;
            case R.id.replaceActivity_GetYanZhengMa:
                presenter.loadSenYanZhengMa(LoginShareUtils.getUserMessage(ReplacePhoneActivity.this, "phone"), replaceActivity_NextStep);
                break;
            case R.id.replaceActivity_clearYanZhengMa:
                replaceActivity_YanZhengMa.setText("");
                replaceActivity_clearYanZhengMa.setVisibility(View.GONE);
                break;
            case R.id.replaceActivity_NextStep:
                presenter.JudegYanZhengMaWrongPair(LoginShareUtils.getUserMessage(ReplacePhoneActivity.this, "phone"), replaceActivity_YanZhengMa.getText().toString().trim());
                break;
        }
    }

    private void timer() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 60; i++) {
                        Time--;
                        Thread.sleep(1000);
                        ReplacePhoneActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                replaceActivity_GetYanZhengMa.setText(Time + "");
                            }
                        });
                        if (Time == 0) {
                            Time = 60;
                            ReplacePhoneActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    replaceActivity_GetYanZhengMa.setText("获取验证码");
                                }
                            });
                            return;
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        new Thread(runnable).start();
    }

    @Override
    public void showYanZhengMaMessage(String meassage) {
        if (meassage.contains("有误")) {
            ToastUtils.mainThread(meassage, 0);
            return;
        } else {
            //                倒计时
            ToastUtils.mainThread(meassage, 0);
            timer();
        }
    }

    @Override
    public void showNextStep(LoginBean loginBean) {
        String phone = LoginShareUtils.getUserMessage(ReplacePhoneActivity.this, "phone");
        Log.e("账号==", phone);
        int code = loginBean.getCode();
        String message = loginBean.getMessage();
        if (code == 0) {
            if (key.equals("修改")) {
                Intent intent = new Intent(ReplacePhoneActivity.this, ResetPasswordActivity.class);
                intent.putExtra("key", multiplexingTitle_title.getText().toString().trim());
                startActivity(intent);
                finish();
            } else {
                startActivity(new Intent(ReplacePhoneActivity.this, ReplaceNewPhoneActivity.class));
                finish();
            }
        } else {
            ToastUtils.mainThread(message, 0);
        }
    }

    /**
     * 忽略大法已开启
     *
     * @param loginBean
     */
    @Override
    public void showReplacePhone(LoginBean loginBean) {

    }
}
