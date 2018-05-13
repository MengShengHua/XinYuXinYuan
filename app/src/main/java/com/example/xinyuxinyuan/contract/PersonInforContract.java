package com.example.xinyuxinyuan.contract;

import android.widget.Button;

import com.example.xinyuxinyuan.contract.bean.APIBean;
import com.example.xinyuxinyuan.contract.bean.HomePagerBean;
import com.example.xinyuxinyuan.contract.bean.LoginBean;

/**
 * Created by asd on 2018/5/9.
 */

public interface PersonInforContract {
    interface PersonInforPresenter {
        boolean JudgButton(String btData, Button button);

        void loadFollow(String followId, String userId);

        void loadDismissFollow(String followId, String userId);

        void loadUserInfor(String currentUserId, String MyuserId);

    }

    interface PersonInforView {
        void showFollow(LoginBean loginBean);

        void showUserInfor(HomePagerBean homePagerBean);
    }
}
