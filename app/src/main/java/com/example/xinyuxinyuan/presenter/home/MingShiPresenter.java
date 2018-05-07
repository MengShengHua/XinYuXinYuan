package com.example.xinyuxinyuan.presenter.home;

import com.example.xinyuxinyuan.contract.Bean.MingShiBean;
import com.example.xinyuxinyuan.contract.home.MingShi;
import com.example.xinyuxinyuan.model.home.MingShiModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 键盘上的手艺人 on 2018/5/4.
 */

public class MingShiPresenter implements MingShi.Presenter{
    MingShi.View view;
    private final MingShiModel mingShiModel;

    public MingShiPresenter(MingShi.View view){
        this.view = view;
        mingShiModel = RetrofitUtils.getRetrofitUtils().getService(MingShiModel.class);
    }
    @Override
    public void loadMingShiData() {
        Map<String,Integer> params = new HashMap<>();
        Map<String,String> headers = new HashMap<>();
        headers.put("apptoken", ShareUtils.getToken());
        mingShiModel.getMingShiData(params,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MingShiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        
                    }

                    @Override
                    public void onNext(MingShiBean mingShiBean) {
                        MingShiBean.DataBean data = mingShiBean.getData();
                        view.showMingShiData(data);
//                        for (MingShiBean.DataBean.HomewoksBean homewoksBean : data.getHomewoks()) {
//                            Log.e("MingShiPresenter", homewoksBean.getContent());
//                        }
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
