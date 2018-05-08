package com.example.xinyuxinyuan.presenter.home;

import com.example.xinyuxinyuan.contract.bean.YuGaoBean;
import com.example.xinyuxinyuan.contract.home.YuGao;
import com.example.xinyuxinyuan.model.home.YuGaoModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 键盘上的手艺人 on 2018/5/7.
 */

public class YuGaoPresenter implements YuGao.Presenter{
    YuGao.View view;
    private YuGaoModel yuGaoModel;

    public YuGaoPresenter(YuGao.View view){
        this.view = view;
        yuGaoModel = RetrofitUtils.getRetrofitUtils().getService(YuGaoModel.class);
    }
    @Override
    public void loadYuGaoData(int page,int rows,int loginUserId,String startDate,String endDate) {
        Map<String,Object> params = new HashMap<>();
        params.put("page",page);
        params.put("rows",rows);
        params.put("loginUserId",loginUserId);
        params.put("startDate",startDate);
        params.put("endDate",endDate);

        Map<String,String> headers = new HashMap<>();
        headers.put("apptoken", ShareUtils.getToken());
        yuGaoModel.getYuGaoData(params,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<YuGaoBean>() {
                    @Override
                    public void accept(YuGaoBean yuGaoBean) throws Exception {
                        view.showYuGaoData(yuGaoBean);
                }
        });
    }
}
