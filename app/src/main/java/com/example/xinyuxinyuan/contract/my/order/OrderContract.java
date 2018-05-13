package com.example.xinyuxinyuan.contract.my.order;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xinyuxinyuan.contract.bean.OrderAllBean;

import java.util.List;

/**
 * Created by asd on 2018/5/11.
 */

public interface OrderContract {
    interface OrderContractPresenter {
        void loaAlldOrder(String userId, String status);

        boolean loadJudgeView(List<OrderAllBean.DataBean.ListBean> list, ListView listView, ImageView imageView, TextView textView);
    }

    interface OrderContractView {
        void showAlldOrder(OrderAllBean orderBean);
    }
}
