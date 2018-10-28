package com.example.xinyuxinyuan.contract.my;

import com.example.xinyuxinyuan.model.bean.HobbyBean;

/**
 * Created by asd on 2018/5/12.
 */

public interface HobbyContract {
    interface HobbyContractPresenter {
        void loadUserHobby(String userId);

        void loadPreservationHooby(String userId, String majorIds, String collegeIds);
    }

    interface HobbyContractView {
        void showUserHobby(HobbyBean hobbyBean);

    }
}
