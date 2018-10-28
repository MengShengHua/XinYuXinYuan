package com.example.xinyuxinyuan.presenter.home;

import com.example.xinyuxinyuan.model.bean.XiangQingBean;
import com.example.xinyuxinyuan.contract.home.XiangQing;
import com.example.xinyuxinyuan.model.home.XiangQingModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 键盘上的手艺人 on 2018/5/8.
 */

public class XiangQingPresenter implements XiangQing.Presenter{
    XiangQing.View view;
    private final XiangQingModel xiangQingModel;

    public XiangQingPresenter(XiangQing.View view){
        this.view = view;
        xiangQingModel = RetrofitUtils.getRetrofitUtils().getService(XiangQingModel.class);
    }

    @Override
    public void loadXiangQingData(int teacherId,int loginUserId) {
        Map<String,Integer> params = new HashMap<>();
        params.put("teacherId",teacherId);
        params.put("loginUserId",loginUserId);
        xiangQingModel.getXiangQingData(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<XiangQingBean>() {
                    @Override
                    public void accept(XiangQingBean xiangQingBean) throws Exception {
                        view.showXiangQingData(xiangQingBean);
                    }
                });
    }
}
