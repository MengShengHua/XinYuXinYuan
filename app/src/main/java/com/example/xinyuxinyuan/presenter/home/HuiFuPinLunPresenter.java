package com.example.xinyuxinyuan.presenter.home;

import com.example.xinyuxinyuan.contract.bean.HuiFuBean;
import com.example.xinyuxinyuan.contract.home.HuiFuPinLun;
import com.example.xinyuxinyuan.model.home.HuiFuPinLunModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 键盘上的手艺人 on 2018/5/12.
 */

public class HuiFuPinLunPresenter implements HuiFuPinLun.Presenter{
    HuiFuPinLun.View view;
    private final HuiFuPinLunModel huiFuPinLunModel;

    public HuiFuPinLunPresenter(HuiFuPinLun.View view){
        this.view = view;
        huiFuPinLunModel = RetrofitUtils.getRetrofitUtils().getService(HuiFuPinLunModel.class);
    }

    /**
     *
     * @param pid       (回复才有）评论ID 默认为0
     * @param userId    评论人ID
     * @param content   评论内容
     * @param refId      关联的ID
     * @param refType   关联的类型: 作业评论 作业回复 艺考圈评论 艺考圈回复
     * @param status    评论状态 0正常 1删除
     */
    @Override
    public void loadHuiFuPinLunData(int pid, int userId, String content,String refType, int status) {
        Map<String,Object> params = new HashMap<>();
        params.put("pid",pid);
        params.put("userId",userId);
        params.put("content",content);
        params.put("refType",refType);
        params.put("status",status);
        Map<String,String> headers = new HashMap<>();
        headers.put("apptoken", ShareUtils.getToken());
        huiFuPinLunModel.getPinLunHuiFuData(params,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HuiFuBean>() {
                    @Override
                    public void accept(HuiFuBean huiFuBean) throws Exception {
                        view.showHuiFuPinLunData(huiFuBean);
                    }
                });
    }
}
