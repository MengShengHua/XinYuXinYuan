package com.example.xinyuxinyuan.contract.home;

import com.example.xinyuxinyuan.model.bean.XiangQingBean;

/**
 * Created by 键盘上的手艺人 on 2018/5/8.
 */

public interface XiangQing {
    interface View{
        void showXiangQingData(XiangQingBean xiangQingBean);
    }

    interface Presenter{
        void loadXiangQingData(int teacherId,int loginUserId);
    }
}
