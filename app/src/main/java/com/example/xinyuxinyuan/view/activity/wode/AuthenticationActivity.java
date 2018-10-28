package com.example.xinyuxinyuan.view.activity.wode;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.model.bean.APIBean;
import com.example.xinyuxinyuan.contract.my.authentication.AuthenticationContract;
import com.example.xinyuxinyuan.presenter.my.authentication.AuthenticationPresenter;
import com.example.xinyuxinyuan.utils.LoginShareUtils;
import com.example.xinyuxinyuan.utils.ToastUtils;

public class AuthenticationActivity extends BaseActivity implements View.OnClickListener, AuthenticationContract.AuthenticationContractView {

    private ImageView multiplexingTitle_return;
    private TextView multiplexingTitle_title;
    private EditText myCertification_name;
    private EditText myCertification_majors;
    private EditText myCertification_inputMess;
    private ImageView myCertification_showIcCard;
    private LinearLayout myCertification_postIcCard;
    private Button myCertification_postBtn;
    private AuthenticationPresenter presenter;


    private void initView() {
        multiplexingTitle_return = (ImageView) findViewById(R.id.multiplexingTitle_return);
        multiplexingTitle_title = (TextView) findViewById(R.id.multiplexingTitle_title);
        multiplexingTitle_title.setText("我的认证");
        myCertification_name = (EditText) findViewById(R.id.myCertification_name);
        myCertification_majors = (EditText) findViewById(R.id.myCertification_majors);
        myCertification_inputMess = (EditText) findViewById(R.id.myCertification_inputMess);
        myCertification_showIcCard = (ImageView) findViewById(R.id.myCertification_showIcCard);
        myCertification_postIcCard = (LinearLayout) findViewById(R.id.myCertification_postIcCard);
        myCertification_postBtn = (Button) findViewById(R.id.myCertification_postBtn);

        myCertification_postBtn.setOnClickListener(this);
        multiplexingTitle_return.setOnClickListener(this);
        myCertification_postIcCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String userId = LoginShareUtils.getUserMessage(this, "id");
        String name = myCertification_name.getText().toString().trim();
        String lingyu = myCertification_majors.getText().toString().trim();
        String userInfor = myCertification_inputMess.getText().toString().trim();

        switch (v.getId()) {
            case R.id.multiplexingTitle_return:
                finish();
                break;
            case R.id.myCertification_postIcCard:
                ToastUtils.mainThread("图片上传有问题",0);
                break;
            case R.id.myCertification_postBtn:
                presenter.loadAuthentication(userId, name, lingyu, userInfor, "", userId);
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_authentication;
    }

    @Override
    protected void init() {
        initView();
    }

    @Override
    protected void loadData() {
        presenter = new AuthenticationPresenter(this);
    }

    @Override
    public void showAuthentication(APIBean apiBean) {
        ToastUtils.mainThread(apiBean.getMessage(), 0);
    }
}
