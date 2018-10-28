package com.example.xinyuxinyuan.view.activity.wode.set;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
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

public class ReplaceNewPhoneActivity extends BaseActivity implements View.OnClickListener, ReplacePhoneContract.ReplacePhoneContractView {

    private ImageView multiplexingTitle_return;
    private TextView multiplexingTitle_title;
    private EditText newActivity_newPhone;
    private ImageView newActivity_clearNewPhone;
    private EditText newActivity_YanZhengMa;
    private TextView newActivity_GetYanZhengMa;
    private ImageView newActivity_clearYanZhengMa;
    private Button newActivity_Over;
    private ReplacePhonePresenter presenter;
    private int Time = 60;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_new_phone;
    }

    @Override
    protected void init() {
        multiplexingTitle_return = (ImageView) findViewById(R.id.multiplexingTitle_return);
        multiplexingTitle_title = (TextView) findViewById(R.id.multiplexingTitle_title);
        multiplexingTitle_title.setText("更换手机号");
        newActivity_newPhone = (EditText) findViewById(R.id.newActivity_newPhone);
        newActivity_clearNewPhone = (ImageView) findViewById(R.id.newActivity_clearNewPhone);
        newActivity_YanZhengMa = (EditText) findViewById(R.id.newActivity_YanZhengMa);
        newActivity_GetYanZhengMa = (TextView) findViewById(R.id.newActivity_GetYanZhengMa);
        newActivity_clearYanZhengMa = (ImageView) findViewById(R.id.newActivity_clearYanZhengMa);
        newActivity_Over = (Button) findViewById(R.id.newActivity_Over);
        newActivity_Over.setOnClickListener(this);
        newActivity_clearYanZhengMa.setOnClickListener(this);
        newActivity_GetYanZhengMa.setOnClickListener(this);
        newActivity_clearNewPhone.setOnClickListener(this);
        multiplexingTitle_return.setOnClickListener(this);
        newActivity_newPhone.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                newActivity_clearNewPhone.setVisibility(View.VISIBLE);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                presenter.loadJudegPhone(newActivity_newPhone.getText().toString().trim(), newActivity_Over, newActivity_clearNewPhone);
            }
        });
        newActivity_YanZhengMa.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                newActivity_clearYanZhengMa.setVisibility(View.VISIBLE);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                presenter.loadJudegYanZhengMa(newActivity_YanZhengMa.getText().toString().trim(), newActivity_Over);
            }
        });
        newActivity_GetYanZhengMa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (newActivity_GetYanZhengMa.getText().toString().trim().equals("获取验证码")) {
                    newActivity_GetYanZhengMa.setEnabled(true);
                } else {
                    newActivity_GetYanZhengMa.setEnabled(false);
                }
            }
        });
    }

    @Override
    protected void loadData() {
        presenter = new ReplacePhonePresenter(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.newActivity_Over:
                presenter.loadReplacePhone(LoginShareUtils.getUserMessage(ReplaceNewPhoneActivity.this, "id"),
                        newActivity_newPhone.getText().toString().trim(),
                        newActivity_YanZhengMa.getText().toString().trim());
                break;
            case R.id.newActivity_clearYanZhengMa:
                newActivity_YanZhengMa.setText("");
                newActivity_clearYanZhengMa.setVisibility(View.GONE);
                break;
            case R.id.newActivity_GetYanZhengMa:
                presenter.loadSenYanZhengMa(newActivity_newPhone.getText().toString().trim(), newActivity_Over);
                break;
            case R.id.newActivity_clearNewPhone:
                newActivity_newPhone.setText("");
                newActivity_clearNewPhone.setVisibility(View.GONE);
                break;
            case R.id.multiplexingTitle_return:
                startActivity(new Intent(ReplaceNewPhoneActivity.this, ReplacePhoneActivity.class));
                finish();
                break;
        }
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

    /**
     * 忽略大法开启
     *
     * @param loginBean
     */
    @Override
    public void showNextStep(LoginBean loginBean) {

    }

    @Override
    public void showReplacePhone(LoginBean loginBean) {
        int code = loginBean.getCode();
        String message = loginBean.getMessage();
        if (code == 0) {
            SharedPreferences preferences = getSharedPreferences("Login", MODE_PRIVATE);
            SharedPreferences.Editor edit = preferences.edit();
//        删除之前的数据，在保存现在的新数据
            edit.remove("phone");
            edit.putString("phone", newActivity_newPhone.getText().toString().trim());
            edit.commit();
            startActivity(new Intent(ReplaceNewPhoneActivity.this, HomeActivity.class));
            finish();
        } else {
            ToastUtils.mainThread(message, 0);
        }
    }

    //倒计时方法
    private void timer() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 60; i++) {
                        Thread.sleep(1000);
                        Time--;
                        ReplaceNewPhoneActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                newActivity_GetYanZhengMa.setText(Time + "");

                            }
                        });
                        if (Time == 0) {
                            Time = 60;
                            ReplaceNewPhoneActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    newActivity_GetYanZhengMa.setText("获取验证码");
                                    return;
                                }
                            });
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        new Thread(runnable).start();
    }
}
