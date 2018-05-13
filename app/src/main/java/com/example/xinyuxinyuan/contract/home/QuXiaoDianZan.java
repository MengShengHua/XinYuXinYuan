package com.example.xinyuxinyuan.contract.home;

import com.example.xinyuxinyuan.contract.bean.QuXiaoDianZanBean;

/**
 * Created by 键盘上的手艺人 on 2018/5/10.
 */

public interface QuXiaoDianZan {
    interface View{
        void showQuXiaoDianZanData(QuXiaoDianZanBean quXiaoDianZan);
    }



    interface Presenter{
        void loadQuXiaoDianZan(int userId, int id, int loginUserId, String type);
    }
}
