package com.example.xinyuxinyuan.presenter.dianzan;
import android.util.Log;

import com.example.xinyuxinyuan.contract.bean.DianZanBean;
import com.example.xinyuxinyuan.contract.bean.QuXiaoDianZanBean;
import com.example.xinyuxinyuan.contract.home.QuXiaoDianZan;
import com.example.xinyuxinyuan.model.dianzan.QuXiaoDianZanModel;
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

public class  QuXiaoDianZanPresenter implements QuXiaoDianZan.Presenter{
    QuXiaoDianZan.View view;
    private final QuXiaoDianZanModel quXiaoDianZanModel;

    public QuXiaoDianZanPresenter(QuXiaoDianZan.View view){
        this.view = view;
        quXiaoDianZanModel = RetrofitUtils.getRetrofitUtils().getService(QuXiaoDianZanModel.class);
    }

    @Override
    public void loadQuXiaoDianZan(int userId,int id,int loginUserId,String type) {
        Map<String,Object> params = new HashMap<>();
        params.put("userId",userId);
        params.put("id",id);
        params.put("loginUserId",loginUserId);
        params.put("type",type);
        Map<String,String> headers = new HashMap<>();
        headers.put("apptoken", ShareUtils.getToken());
        quXiaoDianZanModel.getQuXiaoDianZanData(params,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<QuXiaoDianZanBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("----------",d.toString());
                    }

                    @Override
                    public void onNext(QuXiaoDianZanBean quXiaoDianZanBean) {
                        view.showQuXiaoDianZanData(quXiaoDianZanBean);
                        Log.e("-----------------",quXiaoDianZanBean.getMessage());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("-----------------",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
