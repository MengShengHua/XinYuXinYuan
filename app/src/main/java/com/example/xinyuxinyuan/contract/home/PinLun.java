package com.example.xinyuxinyuan.contract.home;

import com.example.xinyuxinyuan.model.bean.ZuoYeXiangQingBean;

/**
 * Created by 键盘上的手艺人 on 2018/5/11.
 */

public interface PinLun {
    interface View{
        void showPinLunData(ZuoYeXiangQingBean.DataBean.CommentsBean.ListBean listBean);
    }

    interface Presenter{
        /**
         *
         * @param userId    评论人ID
         * @param content   评论内容
         * @param refId     关联的ID
         * @param refType   关联的类型: 作业评论 作业回复 艺考圈评论 艺考圈回复
         * @param status     评论状态 0正常 1删除
         */
        void loadPinLunData(int userId,String content,int refId,String refType,int status);
    }
}
