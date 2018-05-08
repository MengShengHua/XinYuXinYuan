package com.example.xinyuxinyuan.contract.home;

import com.example.xinyuxinyuan.contract.bean.YuGaoBean;

/**
 * Created by 键盘上的手艺人 on 2018/5/7.
 */

public interface YuGao {
    interface View {
        void showYuGaoData(YuGaoBean yuGaoBean);
    }

    interface Presenter {
        void loadYuGaoData(int page,int rows,int loginUserId,String startDate,String endDate);
    }
}

