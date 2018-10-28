package com.example.xinyuxinyuan.presenter.home;

import com.example.xinyuxinyuan.model.bean.ZhaoLaoShiBean;
import com.example.xinyuxinyuan.contract.home.ZhaoLaoShi;
import com.example.xinyuxinyuan.model.home.ZhaoLaoShiModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 键盘上的手艺人 on 2018/5/8.
 */

public class ZhaoLaoShiPresenter implements ZhaoLaoShi.Presenter{
    ZhaoLaoShi.View view;
    private ZhaoLaoShiModel zhaoLaoShiModel;

    public ZhaoLaoShiPresenter(ZhaoLaoShi.View view){
        this.view = view;
        zhaoLaoShiModel = RetrofitUtils.getRetrofitUtils().getService(ZhaoLaoShiModel.class);
    }

    @Override
    public void loadZhaoLaoShiData(int loginUserId,String userType,int page) {
        Map<String,Object> params = new HashMap<>();

        params.put("loginUserId", loginUserId);
        params.put("userType", userType);
        params.put("page", page);
        zhaoLaoShiModel.getZhaoLaoShiData(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZhaoLaoShiBean>() {
                    @Override
                    public void accept(ZhaoLaoShiBean zhaoLaoShiBean) throws Exception {
                        view.showZhaoLaoShiData(zhaoLaoShiBean);
                    }
        });
    }
}
