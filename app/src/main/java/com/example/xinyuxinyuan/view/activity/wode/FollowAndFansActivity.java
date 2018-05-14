package com.example.xinyuxinyuan.view.activity.wode;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.contract.bean.FansBean;
import com.example.xinyuxinyuan.contract.bean.FollowBean;
import com.example.xinyuxinyuan.model.my.personpage.PersonPageModel;
import com.example.xinyuxinyuan.presenter.my.FollowPresenter;
import com.example.xinyuxinyuan.utils.LoginShareUtils;
import com.example.xinyuxinyuan.utils.RetrofitUtils;
import com.example.xinyuxinyuan.view.activity.wode.adapter.FansAdapter;
import com.example.xinyuxinyuan.view.activity.wode.adapter.FollowAdapter;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class FollowAndFansActivity extends BaseActivity implements View.OnClickListener {

    private ImageView multiplexingTitle_return;
    private TextView multiplexingTitle_title;
    private ListView followActivity_listview;
    private FollowPresenter presenter;
    private FollowAdapter followAdapter;
    private FansAdapter fansAdapter;
    private List<FansBean.DataBean.ListBean> list;
    private int id;

    private void initView() {
        multiplexingTitle_return = (ImageView) findViewById(R.id.multiplexingTitle_return);
        multiplexingTitle_title = (TextView) findViewById(R.id.multiplexingTitle_title);
        multiplexingTitle_title.setText("关注");
        followActivity_listview = (ListView) findViewById(R.id.followActivity_listview);
        multiplexingTitle_return.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_follow;
    }

    @Override
    protected void init() {
        initView();
    }

    @Override
    protected void loadData() {
//        这里粉丝和关注通用这的这个ctivity，判断获取出来的值，显示不同的数据
         Intent intent = getIntent();
        String followAndFans = intent.getStringExtra("FollowAndFans");
        id = intent.getIntExtra("id", 0);

        if (followAndFans.equals("关注")) {
            multiplexingTitle_title.setText("关注");
            loadFollowMethod();
        } else {
            multiplexingTitle_title.setText("粉丝");
            loadFansMethod();
        }

    }

    //粉丝
    private void loadFansMethod() {

        HashMap<String, Object> parmas = new HashMap<>();
        if(id != 0){
            parmas.put("loginUserId", id+"");

        }else{
            parmas.put("loginUserId", LoginShareUtils.getUserMessage(this, "id"));
        }
        parmas.put("page",1);
        parmas.put("rows",50);
        RetrofitUtils.getRetrofitUtils().getService(PersonPageModel.class).getMyFens(parmas)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<FansBean>() {
                    @Override
                    public void accept(FansBean fansBean) throws Exception {
                        list = fansBean.getData().getList();
                        fansAdapter = new FansAdapter(list, FollowAndFansActivity.this, getResources());
                        followActivity_listview.setAdapter(fansAdapter);
                    }
                });
    }

    //关注
    private void loadFollowMethod() {
        HashMap<String, String> parmas = new HashMap<>();
        parmas.put("loginUserId", LoginShareUtils.getUserMessage(this, "id"));

        RetrofitUtils.getRetrofitUtils().getService(PersonPageModel.class).getMyFollow(parmas)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<FollowBean>() {
                    @Override
                    public void accept(FollowBean followBean) throws Exception {
                        List<FollowBean.DataBean.ListBean> list = followBean.getData().getList();
                        followAdapter = new FollowAdapter(list, FollowAndFansActivity.this, getResources());
                        followActivity_listview.setAdapter(followAdapter);
                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.multiplexingTitle_return:
                finish();
                break;

        }
    }
}
