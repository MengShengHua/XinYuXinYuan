package com.example.xinyuxinyuan.presenter.dianzan;

import com.example.xinyuxinyuan.model.bean.ShouChangBean;
import com.example.xinyuxinyuan.contract.home.ShouChang;
import com.example.xinyuxinyuan.model.home.ShouChangModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 键盘上的手艺人 on 2018/5/10.
 */

public class ShouChangPresenter implements ShouChang.Presenter{
    ShouChang.View view;
    private final ShouChangModel shouChangModel;

    public ShouChangPresenter(ShouChang.View view){
        this.view = view;
        shouChangModel = RetrofitUtils.getRetrofitUtils().getService(ShouChangModel.class);
    }
    @Override
    public void loadShouChangData(int id,int loginUserId,String type) {
        Map<String,Object> params = new HashMap<>();
        params.put("id",id);
        params.put("loginUserId",loginUserId);
        params.put("type",type);
        Map<String,String> headers = new HashMap<>();
        headers.put("apptoken", ShareUtils.getToken());
        shouChangModel.getShouChangData(params,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShouChangBean>() {
                    @Override
                    public void accept(ShouChangBean shouChangBean) throws Exception {
                        view.showShouChangData(shouChangBean);
                    }
                });
    }

    @Override
    public void loadQuXiaoShouChangData(int id,int loginUserId,String type) {
        Map<String,Object> params = new HashMap<>();
        params.put("id",id);
        params.put("loginUserId",loginUserId);
        params.put("type",type);
        Map<String,String> headers = new HashMap<>();
        headers.put("apptoken", ShareUtils.getToken());
        shouChangModel.getQuXiaoShouChangData(params,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShouChangBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ShouChangBean shouChangBean) {
                        view.showQuXiaoShouChangData(shouChangBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
