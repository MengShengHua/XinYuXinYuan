package com.example.xinyuxinyuan.contract;

import android.widget.Button;
import android.widget.ImageView;


/**
 * Created by asd on 2018/5/5.
 */

public interface ForPasswordContract {
    interface ForPasswordPresenter {
        void loadJudgePhone(String phone, Button button, ImageView imageView);

        void loadSenYanZhengMa(String phone, Button button);

        void loadJudgeYanzhengma(String yanzhengma, Button button, ImageView imageView);

        void loadJudgeAll(String pgone, String yanzhengma);

    }

    interface ForPasswordView {
        void showYanZhengMaMessage(String message);

        void showNextStep(com.example.xinyuxinyuan.model.bean.JavaBean javaBean);
    }
}
