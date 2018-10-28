package com.example.xinyuxinyuan.presenter.home;

import com.example.xinyuxinyuan.model.bean.ZuoYeXiangQingBean;
import com.example.xinyuxinyuan.contract.home.ZuoYeXiangQing;
import com.example.xinyuxinyuan.model.home.ZuoYeXiangQingModel;
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

public class ZuoYeXiangQingPresenter implements ZuoYeXiangQing.Presenter{
    ZuoYeXiangQing.View view;
    private final ZuoYeXiangQingModel zuoYeXiangQingModel;

    public ZuoYeXiangQingPresenter(ZuoYeXiangQing.View view){
        this.view = view;
        zuoYeXiangQingModel = RetrofitUtils.getRetrofitUtils().getService(ZuoYeXiangQingModel.class);
    }
    @Override
    public void loadZuoYeXiangQingData(int loginUserId,int homewokId) {
        Map<String,Object> params = new HashMap<>();
        params.put("loginUserId",loginUserId);
        params.put("homewokId",homewokId);
        Map<String,String> headers = new HashMap<>();
        headers.put("apptoken", ShareUtils.getToken());
        zuoYeXiangQingModel.getZuoYeXiangQingData(params,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZuoYeXiangQingBean>() {
                    @Override
                    public void accept(ZuoYeXiangQingBean zuoYeXiangQingBean) throws Exception {
                        view.showZuoYeXiangQingData(zuoYeXiangQingBean);
                    }
                });
    }
}
