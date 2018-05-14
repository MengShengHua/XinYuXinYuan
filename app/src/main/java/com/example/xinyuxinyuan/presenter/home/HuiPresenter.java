package com.example.xinyuxinyuan.presenter.home;

import com.example.xinyuxinyuan.contract.bean.HuiBean;
import com.example.xinyuxinyuan.contract.home.Hui;
import com.example.xinyuxinyuan.model.home.HuiModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 键盘上的手艺人 on 2018/5/14.
 */

public class HuiPresenter implements Hui.Presenter{
    Hui.View view;
    private final HuiModel huiModel;

    public HuiPresenter(Hui.View view){
        this.view = view;
        huiModel = RetrofitUtils.getRetrofitUtils().getService(HuiModel.class);
    }
    @Override
    public void showHuiData(int loginUserId,int artcircleId,int commentsId) {
        Map<String,Object> params = new HashMap<>();
        params.put("loginUserId",loginUserId);
        params.put("artcircleId",artcircleId);
        params.put("commentsId",commentsId);
        Map<String,String> headers = new HashMap<>();
        headers.put("apptoken", ShareUtils.getToken());
        huiModel.getHuiData(params,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HuiBean>() {
                    @Override
                    public void accept(HuiBean huiBean) throws Exception {
                        view.loadHuiData(huiBean);
                    }
                });
    }
}
