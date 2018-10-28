package com.example.xinyuxinyuan.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xinyuxinyuan.model.bean.FansBean;
import com.example.xinyuxinyuan.model.my.personpage.PersonPageModel;
import com.example.xinyuxinyuan.utils.LoginShareUtils;
import com.example.xinyuxinyuan.utils.RetrofitUtils;
import com.example.xinyuxinyuan.utils.ToastUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        loadData();

    }

    //统一加载布局
    protected abstract int getLayoutId();

    //统一做数据初始化
    protected abstract void init(View view);

    //统一加载数据
    protected abstract void loadData();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onResume() {
        super.onResume();
        HashMap<String, Object> parmas = new HashMap<>();
        parmas.put("loginUserId", LoginShareUtils.getUserMessage(getContext(), "id"));
        RetrofitUtils.getRetrofitUtils().getService(PersonPageModel.class).getMyFens(parmas)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<FansBean>() {
                    @Override
                    public void accept(FansBean fansBean) throws Exception {
                        List<FansBean.DataBean.ListBean> list = fansBean.getData().getList();
                        ToastUtils.mainThread(list.size() + "", 0);
                    }
                });
    }
}
