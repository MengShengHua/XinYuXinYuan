package com.example.xinyuxinyuan.presenter.home;

import com.example.xinyuxinyuan.contract.bean.PinLunBean;
import com.example.xinyuxinyuan.contract.bean.ZuoYeXiangQingBean;
import com.example.xinyuxinyuan.contract.home.PinLun;
import com.example.xinyuxinyuan.model.home.PinLunModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 键盘上的手艺人 on 2018/5/11.
 */

public class PinLunPresenter implements PinLun.Presenter{
    PinLun.View view;
    private final PinLunModel pinLunModel;

    public PinLunPresenter(PinLun.View view){
        this.view = view;
        pinLunModel = RetrofitUtils.getRetrofitUtils().getService(PinLunModel.class);
    }
    /**
     *
     * @param pid       (回复才有）评论ID 默认为0
     * @param userId    评论人ID
     * @param content   评论内容
     * @param refId     关联的ID
     * @param refType   关联的类型: 作业评论 作业回复 艺考圈评论 艺考圈回复
     * @param status     评论状态 0正常 1删除
     */
    @Override
    public void loadPinLunData(int userId,String content,int refId,String refType,int status) {
        Map<String,Object> params = new HashMap<>();
        params.put("userId",userId);
        params.put("content",content);
        params.put("refId",refId);
        params.put("refType",refType);
        params.put("status",status);
        Map<String,String> headers = new HashMap<>();
        headers.put("apptoken", ShareUtils.getToken());
        pinLunModel.getPinLunData(params,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZuoYeXiangQingBean.DataBean.CommentsBean.ListBean>() {
                    @Override
                    public void accept(ZuoYeXiangQingBean.DataBean.CommentsBean.ListBean listBean) throws Exception {
                        view.showPinLunData(listBean);
                    }
                });
    }
}
