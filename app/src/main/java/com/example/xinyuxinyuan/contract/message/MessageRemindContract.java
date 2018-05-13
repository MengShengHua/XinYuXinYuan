package com.example.xinyuxinyuan.contract.message;

import com.example.xinyuxinyuan.contract.bean.FansBean;
import com.example.xinyuxinyuan.contract.bean.MessageRemindBean;

/**
 * Created by asd on 2018/5/7.
 */

public interface MessageRemindContract {
    interface MessageRemindPresenter {
        void loadMessageHome(String token, Integer useId);


    }

    interface MessageRemindView {

        void showMessageHome(MessageRemindBean messageRemindBean);

    }
}
