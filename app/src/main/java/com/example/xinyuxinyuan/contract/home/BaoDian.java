package com.example.xinyuxinyuan.contract.home;

import com.example.xinyuxinyuan.contract.Bean.BaoDianBean;
import com.example.xinyuxinyuan.contract.Bean.BaoDian_LunBo_Bean;

/**
 * Created by 键盘上的手艺人 on 2018/5/7.
 */

public interface BaoDian {
    interface View{
        void showBaoDianData(BaoDianBean baoDianBean);
        void showLunBoData(BaoDian_LunBo_Bean baoDian_lunBo_bean);
    }

    interface Presenter{
        /**
         *
         * @param sortord   0:智能 1:赞数 2：最新评论
         * @param loginUserId  用户id
         * @param page          页数
         * @param rows       数据条目
         */
        void loadBaoDianData(int sortord, int loginUserId, int page, int rows);

        void loadLunBoData();
    }
}
