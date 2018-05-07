package com.example.xinyuxinyuan.view.fragment.wode;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseFragment;
import com.example.xinyuxinyuan.view.activity.login.LoginActivity;
import com.example.xinyuxinyuan.view.activity.messagesetting.MessageSettingActivity;
import com.example.xinyuxinyuan.view.activity.register.RegisterActivity;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class WoDeFragment extends BaseFragment implements View.OnClickListener {


    private ImageView myFragment_Header;
    private ImageView myFragment_Message;
    private ImageView myFragment_Set;
    private Button myFragment_Register;
    private Button myFragment_Login;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wo_de;
    }

    @Override
    protected void init(View view) {
        myFragment_Header = view.findViewById(R.id.myFragment_Header);
        myFragment_Message = view.findViewById(R.id.myFragment_Message);
        myFragment_Set = view.findViewById(R.id.myFragment_Set);
        myFragment_Register = view.findViewById(R.id.myFragment_Register);
        myFragment_Login = view.findViewById(R.id.myFragment_Login);
    }

    @Override
    protected void loadData() {
        myFragment_Header.setOnClickListener(this);
        myFragment_Message.setOnClickListener(this);
        myFragment_Set.setOnClickListener(this);
        myFragment_Register.setOnClickListener(this);
        myFragment_Login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myFragment_Header:
                startActivity(new Intent(getContext(), LoginActivity.class));
                break;
            case R.id.myFragment_Message:
                SharedPreferences loginPreferences = getContext().getSharedPreferences("Login", MODE_PRIVATE);
                String phone = loginPreferences.getString("phone", "用户未登录");
                if ("用户未登录".equals(phone)) {
                    startActivity(new Intent(getContext(), LoginActivity.class));
                } else {
                    ////                用户登录了跳转消息提醒Activity
                    startActivity(new Intent(getContext(), MessageSettingActivity.class));
                }

                break;
            case R.id.myFragment_Set:
                startActivity(new Intent(getContext(), LoginActivity.class));
                break;
            case R.id.myFragment_Register:

                startActivity(new Intent(getContext(), RegisterActivity.class));
                break;
            case R.id.myFragment_Login:
                startActivity(new Intent(getContext(), LoginActivity.class));

                break;


        }
    }
}
