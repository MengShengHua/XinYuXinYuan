package com.example.xinyuxinyuan.presenter.home;

import com.example.xinyuxinyuan.contract.bean.YuGaoXiangQingBean;
import com.example.xinyuxinyuan.contract.home.YuGaoXiangQing;
import com.example.xinyuxinyuan.model.home.YuGaoXiangQingModel;
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

public class YuGaoXiangQingPresenter implements YuGaoXiangQing.Presenter{

    YuGaoXiangQing.View view;
    private final YuGaoXiangQingModel yuGaoXiangQingModel;

    public YuGaoXiangQingPresenter(YuGaoXiangQing.View view){
        this.view = view;
        yuGaoXiangQingModel = RetrofitUtils.getRetrofitUtils().getService(YuGaoXiangQingModel.class);
    }

    @Override
    public void loadYuGaoXiangQing(int loginUserId, int courseId) {
        Map<String,Object> params = new HashMap<>();
        params.put("loginUserId",loginUserId);
        params.put("courseId",courseId);
        Map<String,String> headers = new HashMap<>();
        headers.put("apptoken", ShareUtils.getToken());
        yuGaoXiangQingModel.getYuGaoXiangQingBean(params,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<YuGaoXiangQingBean>() {
                    @Override
                    public void accept(YuGaoXiangQingBean yuGaoXiangQingBean) throws Exception {
                        view.showYuGaoXiangQing(yuGaoXiangQingBean);
                    }
                });
    }
}
