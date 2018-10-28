package com.example.xinyuxinyuan.contract.home;

import com.example.xinyuxinyuan.model.bean.ZuoYeXiangQingBean;

/**
 * Created by 键盘上的手艺人 on 2018/5/9.
 */

public interface ZuoYeXiangQing {
    interface View{
        void showZuoYeXiangQingData(ZuoYeXiangQingBean zuoYeXiangQingBean);
    }

    interface Presenter{
        void loadZuoYeXiangQingData(int loginUserId, int homewokId);
    }
}
