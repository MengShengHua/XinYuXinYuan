package com.example.xinyuxinyuan.view.activity.wode.set;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.utils.LoginShareUtils;

public class EditActivity extends BaseActivity implements View.OnClickListener {

    private ImageView multiplexingTitle_return;
    private TextView multiplexingTitle_title;
    private EditText editActivity_Informationediting;
    private Button editActivity_Preservation;
    private Boolean nickName;

    private void initView() {
        multiplexingTitle_return = (ImageView) findViewById(R.id.multiplexingTitle_return);
        multiplexingTitle_title = (TextView) findViewById(R.id.multiplexingTitle_title);

        editActivity_Informationediting = (EditText) findViewById(R.id.editActivity_Informationediting);
        editActivity_Preservation = (Button) findViewById(R.id.editActivity_Preservation);
        multiplexingTitle_return.setOnClickListener(this);
        editActivity_Preservation.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_edit;
    }

    @Override
    protected void init() {
        initView();
        Intent intent = getIntent();
        nickName = intent.getBooleanExtra("nickName", false);
        if (nickName) {
            multiplexingTitle_title.setText("编辑昵称");
            editActivity_Informationediting.setText(LoginShareUtils.getUserMessage(EditActivity.this, "nickname"));
        } else {
            multiplexingTitle_title.setText("编辑详细地址");
            if (LoginShareUtils.getUserMessage(EditActivity.this, "address") == null) {
                editActivity_Informationediting.setText("");
            } else {
                editActivity_Informationediting.setText(LoginShareUtils.getUserMessage(EditActivity.this, "address"));
            }
        }
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.multiplexingTitle_return:
                finish();
                break;
            case R.id.editActivity_Preservation:
                if (nickName) {
                    LoginShareUtils.deleteUserData(EditActivity.this, "nickname");
                    LoginShareUtils.userAddDataSharedPreferences(EditActivity.this, null, "nickname", editActivity_Informationediting.getText().toString().trim());
                } else {
                    if (LoginShareUtils.getUserMessage(EditActivity.this, "address") == null) {
                        LoginShareUtils.userAddDataSharedPreferences(EditActivity.this, null, "address", editActivity_Informationediting.getText().toString().trim());
                    }else{
                        LoginShareUtils.deleteUserData(EditActivity.this,"address");
                        LoginShareUtils.userAddDataSharedPreferences(EditActivity.this, null, "address", editActivity_Informationediting.getText().toString().trim());
                    }
                }
                finish();
                break;

        }
    }
}
