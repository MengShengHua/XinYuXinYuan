package com.example.xinyuxinyuan.presenter.home;

import com.example.xinyuxinyuan.contract.bean.XianShangKeBean;
import com.example.xinyuxinyuan.contract.home.XianShangKe;
import com.example.xinyuxinyuan.model.home.XianShangKeModel;
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

public class XianShangKePresenter implements XianShangKe.Presenter{
    XianShangKe.View view;
    private final XianShangKeModel xianShangKeModel;

    public XianShangKePresenter(XianShangKe.View view){
        this.view = view;
        xianShangKeModel = RetrofitUtils.getRetrofitUtils().getService(XianShangKeModel.class);
    }

    @Override
    public void loadXianShangKeData(int loginUserId,String type,int page) {
        Map<String,Object> params = new HashMap<>();
        params.put("loginUserId",loginUserId);
        params.put("type",type);
        params.put("page",page);

        Map<String,String> headers = new HashMap<>();
        headers.put("apptoken", ShareUtils.getToken());
        xianShangKeModel.getXianShangKeData(params,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<XianShangKeBean>() {
                    @Override
                    public void accept(XianShangKeBean xianShangKeBean) throws Exception {
                        view.showXianShangKeData(xianShangKeBean);
                    }
                });
    }
}
