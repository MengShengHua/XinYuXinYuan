package com.example.xinyuxinyuan.contract.message;

import com.example.xinyuxinyuan.contract.bean.FansBean;
import com.example.xinyuxinyuan.contract.bean.OrderMessageBean;

/**
 * Created by asd on 2018/5/13.
 */

public interface OrderRemindContract {
    interface OrderRemindContractPresenter {
        void loadOrderRemind(String useId);
    }

    interface OrderRemindContractView {
        void showOrderRemind(OrderMessageBean orderMessageBean);
    }
}
