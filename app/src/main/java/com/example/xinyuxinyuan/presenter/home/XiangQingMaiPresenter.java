package com.example.xinyuxinyuan.presenter.home;

import com.example.xinyuxinyuan.model.bean.XiangQingMaiBean;
import com.example.xinyuxinyuan.contract.home.XiangQingMai;
import com.example.xinyuxinyuan.model.home.XiangQingMaiModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 键盘上的手艺人 on 2018/5/9.
 */

public class XiangQingMaiPresenter implements XiangQingMai.Presenter{
    XiangQingMai.View view;
    private final XiangQingMaiModel xiangQingMaiModel;

    public XiangQingMaiPresenter(XiangQingMai.View view){
        this.view = view;
        xiangQingMaiModel = RetrofitUtils.getRetrofitUtils().getService(XiangQingMaiModel.class);
    }


    @Override
    public void loadXiangQingMaiData(int loginUserId,int id) {
        Map<String,Object> params = new HashMap<>();
        params.put("loginUserId",loginUserId);
        params.put("id",id);
        Map<String,String> headers = new HashMap<>();
        headers.put("apptoken", ShareUtils.getToken());

        xiangQingMaiModel.getXiangQingMaiData(params,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<XiangQingMaiBean>() {
                    @Override
                    public void accept(XiangQingMaiBean xiangQingMaiBean) throws Exception {
                        view.showXiangQingMaiData(xiangQingMaiBean);
                    }
                });
    }
}
