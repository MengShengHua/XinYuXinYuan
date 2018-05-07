package com.example.xinyuxinyuan.presenter.home;

import com.example.xinyuxinyuan.contract.home.ZuoYe;

/**
 * Created by 键盘上的手艺人 on 2018/5/5.
 */

public class ZuoYePresenter implements ZuoYe.Presenter{

    ZuoYe.View view;
    public ZuoYePresenter(ZuoYe.View view){
        this.view = view;

    }

    @Override
    public void loadZuoYeData(int sortord) {

    }
}
