package com.example.xinyuxinyuan.contract.home;

import com.example.xinyuxinyuan.model.bean.ZhaoLaoShiBean;

/**
 * Created by 键盘上的手艺人 on 2018/5/8.
 */

public interface ZhaoLaoShi {
    interface View{
        void showZhaoLaoShiData(ZhaoLaoShiBean zhaoLaoShiBean);
    }

    interface Presenter{
        void loadZhaoLaoShiData(int loginUserId,String userType,int page);
    }
}
