package com.example.xinyuxinyuan.contract.home;

import com.example.xinyuxinyuan.contract.bean.HuiBean;

/**
 * Created by 键盘上的手艺人 on 2018/5/14.
 */

public interface Hui {
    interface Presenter{
        void showHuiData(int loginUserId,int artcircleId,int commentsId);
    }


    interface View{
        void loadHuiData(HuiBean huiBean);
    }
}
