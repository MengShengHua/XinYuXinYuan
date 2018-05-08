package com.example.xinyuxinyuan.presenter.home;

import com.example.xinyuxinyuan.contract.Bean.ZuoYeBean;
import com.example.xinyuxinyuan.contract.home.ZuoYe;
import com.example.xinyuxinyuan.model.home.ZuoYeModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 键盘上的手艺人 on 2018/5/5.
 */

public class ZuoYePresenter implements ZuoYe.Presenter{

    ZuoYe.View view;
    private final ZuoYeModel zuoyeModel;

    public ZuoYePresenter(ZuoYe.View view){
        this.view = view;
        zuoyeModel = RetrofitUtils.getRetrofitUtils().getService(ZuoYeModel.class);
    }


    /**
     *
     * @param sortord     0代表智能筛选  1代表偷听  2代表最新点评
     * @param loginUserId 用户登录成功后返回的id
     * @param page       代表页数
     * @param rows         这个代表一页中的多少条数据
     *
     *        此处网络请求还需要一个请求头appkoten(在拦截器中添加了,此处不用添加)
     */
    @Override
    public void loadZuoYeData(int sortord, int loginUserId, int page, int rows) {
        Map<String,Integer> params = new HashMap<>();
        params.put("sortord",sortord);
        params.put("loginUserId",loginUserId);
        params.put("page",page);
        params.put("rows",rows);
        Map<String,String> headers = new HashMap<>();
        headers.put("apptoken", ShareUtils.getToken());
        zuoyeModel.getZuoYeData(params,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZuoYeBean>() {
                    @Override
                    public void accept(ZuoYeBean zuoYeBean) throws Exception {
                        view.showZuoYeData(zuoYeBean);
                    }
        });
    }
}
