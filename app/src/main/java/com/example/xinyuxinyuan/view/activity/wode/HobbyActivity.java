package com.example.xinyuxinyuan.view.activity.wode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.contract.bean.HobbyBean;
import com.example.xinyuxinyuan.contract.my.HobbyContract;
import com.example.xinyuxinyuan.presenter.my.HobbyPresenter;
import com.example.xinyuxinyuan.utils.LoginShareUtils;
import com.example.xinyuxinyuan.view.activity.wode.adapter.HobbyMajorAdapter;
import com.example.xinyuxinyuan.view.activity.wode.adapter.HobbySchoolAdapter;

import java.util.List;

public class HobbyActivity extends BaseActivity implements View.OnClickListener, HobbyContract.HobbyContractView {

    private ImageView multiplexingTitle_return;
    private TextView multiplexingTitle_title;
    private GridView hobbyActivity_major;
    private GridView hobbyActivity_school;
    private Button hobbyActivity_Preservation;
    private HobbyPresenter presenter;
    private List<HobbyBean.DataBean.MajorsBean> majors;
    private List<HobbyBean.DataBean.CollegesBean> colleges;
    private int mMajors;
    private int mSchool;

    private void initView() {
        multiplexingTitle_return = (ImageView) findViewById(R.id.multiplexingTitle_return);
        multiplexingTitle_return.setOnClickListener(this);
        multiplexingTitle_title = (TextView) findViewById(R.id.multiplexingTitle_title);
        multiplexingTitle_title.setText("");
        hobbyActivity_major = (GridView) findViewById(R.id.hobbyActivity_major);
        hobbyActivity_school = (GridView) findViewById(R.id.hobbyActivity_school);
        hobbyActivity_Preservation = (Button) findViewById(R.id.hobbyActivity_Preservation);
        hobbyActivity_Preservation.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hobby;
    }

    @Override
    protected void init() {
        initView();
        presenter = new HobbyPresenter(this);
        presenter.loadUserHobby(LoginShareUtils.getUserMessage(this, "id"));
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hobbyActivity_Preservation:
                break;
            case R.id.multiplexingTitle_return:
                finish();
                break;
        }
    }

    @Override
    public void showUserHobby(HobbyBean hobbyBean) {
        majors = hobbyBean.getData().getMajors();
        HobbyMajorAdapter hobbyMajorAdapter = new HobbyMajorAdapter(majors, HobbyActivity.this);
        hobbyActivity_major.setAdapter(hobbyMajorAdapter);
        colleges = hobbyBean.getData().getColleges();
        HobbySchoolAdapter collegesAdapter = new HobbySchoolAdapter(colleges, HobbyActivity.this);
        hobbyActivity_school.setAdapter(collegesAdapter);
        hobbyActivity_major.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mMajors = position;
//                presenter.loadPreservationHooby(LoginShareUtils.getUserMessage(HobbyActivity.this, "id"), );
            }
        });
        hobbyActivity_school.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSchool = position;

            }
        });
    }
}
