package com.example.xinyuxinyuan.contract.home;

import com.example.xinyuxinyuan.model.bean.MingShiBean;

/**
 * Created by 键盘上的手艺人 on 2018/5/4.
 */

public interface MingShi {
    interface View {
        void showMingShiData(MingShiBean.DataBean data);
    }

    interface Presenter {
        void loadMingShiData();
    }
}
