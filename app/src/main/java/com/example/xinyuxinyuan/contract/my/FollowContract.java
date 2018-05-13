package com.example.xinyuxinyuan.contract.my;

import com.example.xinyuxinyuan.contract.bean.FansBean;
import com.example.xinyuxinyuan.contract.bean.FollowBean;
import com.example.xinyuxinyuan.contract.bean.UserInforBean;

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
