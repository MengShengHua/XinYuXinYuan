package com.example.xinyuxinyuan.contract.my;

import com.example.xinyuxinyuan.model.bean.UserInforBean;

/**
 * Created by asd on 2018/5/9.
 */

public interface FollowContract {
    interface FollowContractPresenter {
        void loadMyFollow(String userId);

    }

    interface FollowContractView {

        void showMyFollow(UserInforBean userInforBean);
    }
}
