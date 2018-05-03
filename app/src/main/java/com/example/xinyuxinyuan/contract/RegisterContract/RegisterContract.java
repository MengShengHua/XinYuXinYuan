package com.example.xinyuxinyuan.contract.RegisterContract;

import android.widget.Button;

/**
 * Created by asd on 2018/5/3.
 */

public interface RegisterContract {
    interface RegisterPresenter {
        boolean loadPhone(String phone);


        void loadYanZhengMa(Button button, String phone);

        void loadRegister(String phone, String yanzhengMa);
    }

    interface RegisterView {
        void showYanZhengMaMessage(String message);
    }
}
