package com.example.xinyuxinyuan.view.activity.register;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.contract.RegisterContract;
import com.example.xinyuxinyuan.presenter.RegisterPersenter;
import com.example.xinyuxinyuan.utils.ToastUtils;
import com.example.xinyuxinyuan.view.activity.perfectinformation.PerfectinActivity;
import com.example.xinyuxinyuan.view.activity.univ.UnivStarActivity;

public class RegisterActivity extends BaseActivity implements View.OnClickListener, RegisterContract.RegisterView {
    //    返回按钮
    private ImageView register_retuenLogin;
    //    清空按钮
    private ImageView register_ivClear;
    //    手机号
    private EditText register_etPhone;
    private EditText register_etYanzhengma;
    //    验证码
    private TextView register_tvGetYanzhengma;
    //    协议
    private TextView register_tvAgreement;
    //    注册
    private Button register_btRegister;
    //    private MyContract contract;
    private int mTime = 60;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int time = msg.arg1;
            switch (msg.what) {
                case 0:
                    if (time == 0) {
                        mTime = 60;
                        register_tvGetYanzhengma.setText("获取验证码");
                        return;
                    }
                    register_tvGetYanzhengma.setText("" + time);
                    handler.postDelayed(runnable, 1000);

                    break;
            }
        }
    };
    private RegisterPersenter contract;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void init() {
        register_retuenLogin = (ImageView) findViewById(R.id.register_retuenLogin);
        register_ivClear = (ImageView) findViewById(R.id.register_ivClear);
        register_etPhone = (EditText) findViewById(R.id.register_etPhone);
        register_etYanzhengma = (EditText) findViewById(R.id.register_etYanzhengma);
        register_tvGetYanzhengma = (TextView) findViewById(R.id.register_tvGetYanzhengma);
        register_tvAgreement = (TextView) findViewById(R.id.register_tvAgreement);
        register_btRegister = (Button) findViewById(R.id.register_btRegister);
//        获取验证码
        register_tvGetYanzhengma.setOnClickListener(this);
//        清空图标
        register_ivClear.setOnClickListener(this);
//        登录
        register_btRegister.setOnClickListener(this);
//        使用协议
        register_tvAgreement.setOnClickListener(this);
//        创建P层对象
        contract = new RegisterPersenter(this);
    }

    @Override
    protected void loadData() {
//        监听EditText变化
        register_etPhone.addTextChangedListener(new TextWatcher() {
            @Override
//            变化时触发
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (contract.loadPhone(register_etPhone.getText().toString().trim())) {
                    register_ivClear.setVisibility(View.VISIBLE);
                } else {
                    register_ivClear.setVisibility(View.GONE);
                }
            }

            @Override
            //            变化前触发
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (contract.loadPhone(register_etPhone.getText().toString().trim())) {
                    register_ivClear.setVisibility(View.VISIBLE);
                } else {
                    register_ivClear.setVisibility(View.GONE);
                }
            }

            @Override
            //            变化结束后触发
            public void afterTextChanged(Editable s) {
                if (contract.loadPhone(register_etPhone.getText().toString().trim())) {
                    register_ivClear.setVisibility(View.VISIBLE);
                } else {
                    register_ivClear.setVisibility(View.GONE);
                }
                if (register_etPhone.getText().toString().trim().length() == 11 && register_etPhone.getText().toString().trim().startsWith("1")) {
//            符合
                    register_btRegister.setEnabled(true);
                    register_btRegister.setBackgroundColor(Color.parseColor("#3F51B5"));
                } else {
//            不符合
                    register_btRegister.setEnabled(false);
                    register_btRegister.setBackgroundColor(Color.parseColor("#979494"));
                }
            }
        });
        register_etYanzhengma.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (register_etYanzhengma.getText().toString().trim().length() == 6) {
//            符合
                    register_btRegister.setEnabled(true);
                    register_btRegister.setBackgroundColor(Color.parseColor("#3F51B5"));
                } else {
//            不符合
                    register_btRegister.setEnabled(false);
                    register_btRegister.setBackgroundColor(Color.parseColor("#979494"));
                }
            }

        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            注册按钮
            case R.id.register_btRegister:
                contract.loadRegister(register_etPhone.getText().toString().trim(),
                        register_etYanzhengma.getText().toString().trim());
                break;
//                手机号框
            case R.id.register_ivClear:
//                清空手机号框
                register_etPhone.setText("");
                register_ivClear.setVisibility(View.GONE);
                break;
//                获取验证码
            case R.id.register_tvGetYanzhengma:
//                开启延迟线程
                handler.post(runnable);
//                发送验证码
                contract.loadYanZhengMa(register_btRegister, register_etPhone.getText().toString().trim());

                break;
//                使用协议
            case R.id.register_tvAgreement:
                startActivity(new Intent(RegisterActivity.this, UnivStarActivity.class));
                break;

        }
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mTime--;
            Message message = handler.obtainMessage();
            message.arg1 = mTime;
            message.what = 0;
            handler.sendMessage(message);
        }
    };

    /**
     * 发送验证码是否成功的吐丝
     *
     * @param message
     */
    @Override
    public void showYanZhengMaMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
//        ToastUtils.childThread(message, 0);
    }

    @Override
    public void showGoToPerfect(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        if (message.contains("成功")) {
            startActivity(new Intent(RegisterActivity.this, PerfectinActivity.class));
            finish();
        }
    }


}
