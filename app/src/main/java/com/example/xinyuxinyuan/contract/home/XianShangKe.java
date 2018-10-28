package com.example.xinyuxinyuan.contract.home;

import com.example.xinyuxinyuan.model.bean.XianShangKeBean;

/**
 * Created by 键盘上的手艺人 on 2018/5/9.
 */

public interface XianShangKe {
    interface View{
        void showXianShangKeData(XianShangKeBean xianShangKeBean);
    }

    interface Presenter{
        void loadXianShangKeData(int loginUserId, String type, int page);
    }
}
