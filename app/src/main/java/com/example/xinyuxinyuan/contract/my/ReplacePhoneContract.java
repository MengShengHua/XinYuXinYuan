package com.example.xinyuxinyuan.contract.my;

import android.widget.Button;
import android.widget.ImageView;

import com.example.xinyuxinyuan.model.bean.LoginBean;

/**
 * Created by asd on 2018/5/8.
 */

public interface ReplacePhoneContract {
    interface ReplacePhoneContractPresenter {
        void loadSenYanZhengMa(String phone, Button button);

        void loadJudegYanZhengMa(String yanZhengMa, Button button);

        void JudegYanZhengMaWrongPair(String phone, String yanZhengMa);

        void loadJudegPhone(String phone, Button button, ImageView imageView);

        void loadReplacePhone(String loginUserId, String ReplaceAfterPhone, String yanZhengMa);
    }

    interface ReplacePhoneContractView {
        void showYanZhengMaMessage(String meassage);

        void showNextStep(LoginBean loginBean);

        void showReplacePhone(LoginBean loginBean);
    }
}
