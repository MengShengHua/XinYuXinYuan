package com.example.xinyuxinyuan.contract.home;

import com.example.xinyuxinyuan.model.bean.ShouChangBean;

/**
 * Created by 键盘上的手艺人 on 2018/5/10.
 */

public interface ShouChang {
    interface View{
        void showShouChangData(ShouChangBean shouChangBean);
        void showQuXiaoShouChangData(ShouChangBean shouChangBean);
    }

    interface Presenter{
        void loadShouChangData(int id, int loginUserId, String type);
        void loadQuXiaoShouChangData(int id, int loginUserId, String type);
    }
}
