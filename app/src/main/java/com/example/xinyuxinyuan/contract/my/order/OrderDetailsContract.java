package com.example.xinyuxinyuan.contract.my.order;

import com.example.xinyuxinyuan.contract.bean.LoginBean;
import com.example.xinyuxinyuan.contract.bean.OrderDetailsBean;

/**
 * Created by asd on 2018/5/11.
 */

public interface OrderDetailsContract {
    interface OrderDetailsContractPresenter {
        void loadOrderDetails(String oid, String courseType);

        void loadDeletetOrder(String oid);
    }

    interface OrderDetailsContractView {
        void showOrderDetails(OrderDetailsBean detailsBean);

        void showDeletetOrder(LoginBean detailsBean);
    }
}
