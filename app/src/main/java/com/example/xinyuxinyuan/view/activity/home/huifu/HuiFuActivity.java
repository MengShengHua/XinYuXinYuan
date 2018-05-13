package com.example.xinyuxinyuan.view.activity.home.huifu;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.contract.bean.HuiFuBean;
import com.example.xinyuxinyuan.contract.bean.ZuoYeXiangQingBean;
import com.example.xinyuxinyuan.contract.home.HuiFuPinLun;
import com.example.xinyuxinyuan.contract.home.PinLun;
import com.example.xinyuxinyuan.presenter.home.HuiFuPinLunPresenter;
import com.example.xinyuxinyuan.presenter.home.PinLunPresenter;
import java.util.ArrayList;
import java.util.List;

public class HuiFuActivity extends BaseActivity implements View.OnClickListener, HuiFuPinLun.View,PinLun.View {

    private ImageView title_fuyong_finish;
    private TextView title_fuyong_text;
    private RecyclerView huifu_recyclerView;
    private int pid;
    private int userId;
    private HuiFuPinLunPresenter huiFuPinLunPresenter;
    private EditText huifu_editText;
    private Button huifu_sendBtn;
    private PinLunPresenter pinLunPresenter;
    private List<Object> myList = new ArrayList<>();
    private HuiFuAdpater huiFuAdpater;
    private List<HuiFuBean> mList = new ArrayList<>();
    private ZuoYeXiangQingBean.DataBean.CommentsBean.ListBean listBean;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hui_fu;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        pid = intent.getIntExtra("pid", 0);
        userId = intent.getIntExtra("userId", 0);
        listBean = (ZuoYeXiangQingBean.DataBean.CommentsBean.ListBean) intent.getSerializableExtra("bean");
        //实例化P层对象
        huiFuPinLunPresenter = new HuiFuPinLunPresenter(this);

        pinLunPresenter = new PinLunPresenter(this);

        title_fuyong_finish = (ImageView) findViewById(R.id.title_fuyong_finish);
        title_fuyong_text = (TextView) findViewById(R.id.title_fuyong_text);
        huifu_recyclerView = (RecyclerView) findViewById(R.id.huifu_recyclerView);
        huifu_editText = findViewById(R.id.huifu_editText);
        huifu_sendBtn = findViewById(R.id.huifu_sendBtn);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        huifu_recyclerView.setLayoutManager(linearLayoutManager);
        //设置适配器
        huiFuAdpater = new HuiFuAdpater(this,mList);
        huifu_recyclerView.setAdapter(huiFuAdpater);

        title_fuyong_finish.setOnClickListener(this);
        huifu_sendBtn.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_fuyong_finish:
                finish();
                break;
            case R.id.huifu_sendBtn:

                huiFuPinLunPresenter.loadHuiFuPinLunData(pid,userId,huifu_editText.getText().toString(),"作业回复",0);
                break;
        }
    }

    @Override
    public void showHuiFuPinLunData(HuiFuBean huiFuBean) {
        mList.add(huiFuBean);
        huiFuAdpater.notifyDataSetChanged();
        huifu_editText.setText("");
    }

    @Override
    public void showPinLunData(ZuoYeXiangQingBean.DataBean.CommentsBean.ListBean listBean) {

    }
}
