package com.example.xinyuxinyuan.presenter.dianzan;
import android.util.Log;

import com.example.xinyuxinyuan.model.bean.DianZanBean;
import com.example.xinyuxinyuan.contract.home.DianZan;
import com.example.xinyuxinyuan.model.dianzan.DianZanModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 键盘上的手艺人 on 2018/5/9.
 */

public class DianZanPresenter implements DianZan.Presenter{

    DianZan.View view;
    private final DianZanModel dianZanModel;

    public DianZanPresenter(DianZan.View view){
        this.view = view;
        dianZanModel = RetrofitUtils.getRetrofitUtils().getService(DianZanModel.class);
    }

    @Override
    public void loadDianZanData(int userId,int id,int loginUserId,String type) {
        Map<String,Object> params = new HashMap<>();
        params.put("userId",userId);
        params.put("id",id);
        params.put("loginUserId",loginUserId);
        params.put("type",type);
        Map<String,String> headers = new HashMap<>();
        headers.put("apptoken", ShareUtils.getToken());
        dianZanModel.getDianZanData(params,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DianZanBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("------------",d.toString());
                    }

                    @Override
                    public void onNext(DianZanBean dianZanBean) {
                        Log.e("------------",dianZanBean.getMessage());
                        view.showDianZanData(dianZanBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("------------",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
