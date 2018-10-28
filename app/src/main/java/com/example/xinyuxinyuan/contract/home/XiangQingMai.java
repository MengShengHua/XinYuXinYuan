package com.example.xinyuxinyuan.contract.home;

import com.example.xinyuxinyuan.model.bean.XiangQingMaiBean;

/**
 * Created by 键盘上的手艺人 on 2018/5/9.
 */

public interface XiangQingMai{
    interface View{
        void showXiangQingMaiData(XiangQingMaiBean xiangQingMaiBean);
    }

    interface Presenter{
        void loadXiangQingMaiData(int loginUserId, int id);
    }
}
