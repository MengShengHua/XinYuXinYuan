package com.example.xinyuxinyuan.contract.my.authentication;

import com.example.xinyuxinyuan.model.bean.APIBean;

/**
 * Created by asd on 2018/5/12.
 */

public interface AuthenticationContract {
    interface AuthenticationContractPresenter {
        void loadAuthentication(String userId, String userName, String realm, String intro, String pic, String authentication);
    }

    interface AuthenticationContractView {
        void showAuthentication(APIBean apiBean);
    }
}
