package com.example.xinyuxinyuan.contract.home;

import com.example.xinyuxinyuan.model.bean.HuiFuBean;

/**
 * Created by 键盘上的手艺人 on 2018/5/12.
 */

public interface HuiFuPinLun {
    interface View{
        void showHuiFuPinLunData(HuiFuBean huiFuBean);
    }


    interface Presenter{
        /**
         *
         * @param pid       (回复才有）评论ID 默认为0
         * @param userId    评论人ID
         * @param content   评论内容
         * @param refType   关联的类型: 作业评论 作业回复 艺考圈评论 艺考圈回复
         * @param status    评论状态 0正常 1删除
         */
        void loadHuiFuPinLunData(int pid,int userId,String content,String refType,int status);
    }

}
