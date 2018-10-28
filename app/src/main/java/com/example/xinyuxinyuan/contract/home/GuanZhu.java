package com.example.xinyuxinyuan.contract.home;

import com.example.xinyuxinyuan.model.bean.GuanZhuBean;

/**
 * Created by 键盘上的手艺人 on 2018/5/10.
 */

public interface GuanZhu {
    interface View{
        void showGuanZhu(GuanZhuBean guanZhuBean);
        void showQuXiaoGuanZhu(GuanZhuBean guanZhuBean);
    }

    interface Presenter{
        void loadGuanZhu(int attentionId, int loginUserId);
        void loadQuXiaoGuanZhu(int attentionId, int loginUserId);
    }
}
