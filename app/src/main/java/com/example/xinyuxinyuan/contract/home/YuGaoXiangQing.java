package com.example.xinyuxinyuan.contract.home;

import com.example.xinyuxinyuan.model.bean.YuGaoXiangQingBean;

/**
 * Created by 键盘上的手艺人 on 2018/5/12.
 */

public interface YuGaoXiangQing {
    interface View{
        void showYuGaoXiangQing(YuGaoXiangQingBean yuGaoXiangQingBean);
    }


    interface Presenter{
        void loadYuGaoXiangQing(int loginUserId,int courseId);
    }
}
