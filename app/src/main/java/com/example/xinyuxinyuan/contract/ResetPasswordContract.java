package com.example.xinyuxinyuan.contract;

import android.widget.Button;
import android.widget.ImageView;

import com.example.xinyuxinyuan.contract.bean.ResetBean;

/**
 * Created by asd on 2018/5/5.
 */

public interface ResetPasswordContract {
    interface ResetPasswordPresenter {
        void loadJudgePassword(String password, Button button, ImageView imageView);

        void loadJudgeNewPassword(String password, Button button, ImageView imageView);

        void loadOver(String phone, String password, String newPassword);
    }

    interface ResetPasswordView {
        void showMessage(String message);

        void showResetOver(ResetBean resetBean);
    }

}
