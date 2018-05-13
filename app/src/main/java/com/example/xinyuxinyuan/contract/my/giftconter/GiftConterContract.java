package com.example.xinyuxinyuan.contract.my.giftconter;

import com.example.xinyuxinyuan.contract.bean.GiftConterBean;
import com.example.xinyuxinyuan.contract.bean.OrderAllBean;

/**
 * Created by asd on 2018/5/12.
 */

public interface GiftConterContract {
    interface DetailedContractPresenter {
        void loadGift(String loginUserId, String type);
    }

    interface DetailedContractView {
        void showGiftDetailed(GiftConterBean giftConterBean);
    }
}
