package com.example.xinyuxinyuan.presenter.dianzan;
import com.example.xinyuxinyuan.model.bean.GuanZhuBean;
import com.example.xinyuxinyuan.contract.home.GuanZhu;
import com.example.xinyuxinyuan.model.dianzan.GuanZhuModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;
import java.util.HashMap;
import java.util.Map;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 键盘上的手艺人 on 2018/5/10.
 */

public class GuanZhuPresenter implements GuanZhu.Presenter{
    GuanZhu.View view;
    private final GuanZhuModel guanZhuModel;

    public GuanZhuPresenter(GuanZhu.View view){
        this.view = view;
        guanZhuModel = RetrofitUtils.getRetrofitUtils().getService(GuanZhuModel.class);
    }

    @Override
    public void loadGuanZhu(int attentionId,int loginUserId) {
        Map<String,Object> params = new HashMap<>();
        params.put("attentionId",attentionId);
        params.put("loginUserId",loginUserId);
        Map<String,String> headers = new HashMap<>();
        headers.put("apptoken", ShareUtils.getToken());
        guanZhuModel.getGuanZhu(params,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GuanZhuBean>() {
                    @Override
                    public void accept(GuanZhuBean guanZhuBean) throws Exception {
                        view.showGuanZhu(guanZhuBean);
                    }
                });
    }

    @Override
    public void loadQuXiaoGuanZhu(int attentionId,int loginUserId) {
        Map<String,Object> params = new HashMap<>();
        params.put("attentionId",attentionId);
        params.put("loginUserId",loginUserId);
        Map<String,String> headers = new HashMap<>();
        headers.put("apptoken", ShareUtils.getToken());
        guanZhuModel.getQuXiaoGuanZhu(params,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GuanZhuBean>() {
                    @Override
                    public void accept(GuanZhuBean guanZhuBean) throws Exception {
                        view.showQuXiaoGuanZhu(guanZhuBean);
                    }
                });
    }
}
