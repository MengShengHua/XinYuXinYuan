package com.example.xinyuxinyuan.contract.home;

import com.example.xinyuxinyuan.contract.Bean.ZuoYeBean;

/**
 * Created by 键盘上的手艺人 on 2018/5/5.
 */

public interface ZuoYe {
    interface View{
        void showZuoYeData(ZuoYeBean zuoYeBean);
    }

    interface Presenter{
        /**
         *
         * @param sortord     0代表智能筛选  1代表偷听  2代表最新点评
         * @param loginUserId 用户登录成功后返回的id
         * @param page       代表页数
         * @param rows         这个代表一页中的多少条数据
         */
        void loadZuoYeData(int sortord,int loginUserId,int page,int rows);
    }
}
