package com.example.xinyuxinyuan.contract.my;

import com.example.xinyuxinyuan.contract.bean.ALiPayModel;
import com.example.xinyuxinyuan.model.bean.JinDouPriceItemBean;
import com.example.xinyuxinyuan.model.bean.NoticeDetailOrderBean;

/**
 * Created by asd on 2018/5/11.
 */

public interface RechargeContract {
    interface RechargeContractPresenter {
        void loadJinDouPriceItem(String userId);

        void loadRechargeJinDou(String userId, double price, String count);

        void loadRechargeZhiFuBaoHuiDiao(String orderNo);
    }

    interface RechargeContractView {
        void showJinDouPriceItem(JinDouPriceItemBean jinDouPriceItemBean);

        void showRechargeJinDou(NoticeDetailOrderBean noticeDetailOrderBean);

        void showRechargeHuiDiao(ALiPayModel aLiPayModel);
    }
}
