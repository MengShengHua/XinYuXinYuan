package com.example.xinyuxinyuan.contract.my;

import com.example.xinyuxinyuan.model.bean.PersonTieZiBean;

/**
 * Created by asd on 2018/5/14.
 */

public interface PersonTieziContract {
    interface PersonTieziContractPresenter {
        void loadTieZi(String id);

    }

    interface PersonTieziContractView {
        void showTieZi(PersonTieZiBean personTieZiBean);
    }
}
