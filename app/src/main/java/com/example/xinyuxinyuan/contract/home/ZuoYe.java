package com.example.xinyuxinyuan.contract.home;

/**
 * Created by 键盘上的手艺人 on 2018/5/5.
 */

public interface ZuoYe {
    interface View{
        void showZuoYeData();
    }

    interface Presenter{
        void loadZuoYeData(int sortord);
    }
}
