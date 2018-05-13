package com.example.xinyuxinyuan.contract.home;

import com.example.xinyuxinyuan.contract.bean.DianZanBean;

/**
 * Created by 键盘上的手艺人 on 2018/5/9.
 */

public interface DianZan {
    interface View{
        void showDianZanData(DianZanBean dianZanBean);
    }

    interface Presenter{
        void loadDianZanData(int userId, int id, int loginUserId, String type);
    }
}
