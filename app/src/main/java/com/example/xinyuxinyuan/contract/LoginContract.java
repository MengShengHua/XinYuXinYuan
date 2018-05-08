package com.example.xinyuxinyuan.contract;

import android.widget.Button;
import android.widget.ImageView;

import com.example.xinyuxinyuan.contract.bean.LoginBean;

/**
 * Created by asd on 2018/5/4.
 */

public interface LoginContract {
    interface LoginPersnter {
        void loadJudgePhone(String phone, Button button, ImageView imageView);

        void loadJudgePassword(String password, Button button, ImageView imageView);

        void loadJudgeLogin(String phone, String password, Button button);


    }

    interface LoginView {
        void showJudgeMessage(String Message);

        void showLoginMessage(LoginBean loginBean);
    }
}
