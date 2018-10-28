package com.example.xinyuxinyuan.contract.my.giftconter;

import com.example.xinyuxinyuan.model.bean.GiftConterBean;

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
