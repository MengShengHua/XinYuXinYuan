package com.example.xinyuxinyuan.presenter.home;

import android.util.Log;

import com.example.xinyuxinyuan.model.bean.BaoDianBean;
import com.example.xinyuxinyuan.model.bean.BaoDian_LunBo_Bean;
import com.example.xinyuxinyuan.contract.home.BaoDian;
import com.example.xinyuxinyuan.model.home.BaoDianModel;
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

public class BaoDianPresenter implements BaoDian.Presenter{
    BaoDian.View view;
    private final BaoDianModel baoDianModel;

    public BaoDianPresenter(BaoDian.View view){
        this.view = view;
        baoDianModel = RetrofitUtils.getRetrofitUtils().getService(BaoDianModel.class);
    }

    /**
     *
     * @param sortord   0:智能 1:赞数 2：最新评论
     * @param loginUserId  用户id
     * @param page          页数
     * @param rows       数据条目
     */
    @Override
    public void loadBaoDianData(int sortord, int loginUserId, int page, int rows) {
        Map<String,Integer> params = new HashMap<>();
        params.put("sortord",sortord);
        params.put("loginUserId",loginUserId);
        params.put("page",page);
        params.put("rows",rows);
        Map<String,String> headers = new HashMap<>();
        headers.put("apptoken", ShareUtils.getToken());
        baoDianModel.getBaoDianData(params,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaoDianBean>() {
                    @Override
                    public void accept(BaoDianBean baoDianBean) throws Exception {
                        view.showBaoDianData(baoDianBean);
                    }
                });
    }

    @Override
    public void loadLunBoData() {
        Map<String,Integer> params = new HashMap<>();
        Map<String,String> headers = new HashMap<>();
        Log.e("我地方我地方贝多芬", ShareUtils.getToken());
        headers.put("apptoken", ShareUtils.getToken());
        baoDianModel.getBaoDianLunBoData(params,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaoDian_LunBo_Bean>() {
                    @Override
                    public void accept(BaoDian_LunBo_Bean baoDian_lunBo_bean) throws Exception {
                        view.showLunBoData(baoDian_lunBo_bean);
                    }
                });
    }
}
