package com.example.xinyuxinyuan.contract.my;

import com.example.xinyuxinyuan.contract.bean.JinDouPriceItemBean;

/**
 * Created by asd on 2018/5/11.
 */

public interface RechargeContract {
    interface RechargeContractPresenter {
        void loadJinDouPriceItem(String userId);
    }

    interface RechargeContractView {
        void showJinDouPriceItem(JinDouPriceItemBean jinDouPriceItemBean);
    }
}
