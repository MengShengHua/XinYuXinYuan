package com.example.xinyuxinyuan.view.activity.perfectinformation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.model.bean.CheckUserLoginModel;
import com.example.xinyuxinyuan.model.bean.UpLoadImgModel;
import com.example.xinyuxinyuan.presenter.IpPerfectinPersenter;
import com.example.xinyuxinyuan.contract.PerfectinContract;
import com.example.xinyuxinyuan.utils.LoginShareUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;
import com.example.xinyuxinyuan.utils.ToastUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PerfectinActivity extends BaseActivity implements View.OnClickListener, PerfectinContract.PerfectinView, RadioGroup.OnCheckedChangeListener {

    private RelativeLayout perfectinActivity_Photograph;
    private EditText perfectinActivity_Nickname;
    private ImageView perfectinActivity_clearNickmame;
    private ImageView perfectinActivity_header;
    private RadioButton perfectinActivity_Man;
    private RadioButton perfectinActivity_woman;
    private RadioGroup perfectinActivity_Rg;
    private EditText perfectinActivity_Password;
    private ImageView perfectinActivity_clearPassword;
    private Button perfectinActivity_over;
    private Uri uri_xiangCe;
    private IpPerfectinPersenter contract;
    /**
     * 头像上传为本地手机相册所选图片的File路径
     */

    private File image_file;
    private SimpleDateFormat dateFormat;
    private Date date;
    private SharedPreferences preferences;
    //    用来接收性别
    private Integer SEX;
    //上传成功后的头像网址
    private String ImgUrl;
    //    男
    private final int MAN = 0;
    //    女
    private final int WOMAN = 1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_perfectin;
    }

    @Override
    protected void init() {
//        选择头像
        perfectinActivity_Photograph = findViewById(R.id.perfectinActivity_Photograph);
//        头像
        perfectinActivity_header = findViewById(R.id.perfectinActivity_header);
//        昵称
        perfectinActivity_Nickname = findViewById(R.id.perfectinActivity_Nickname);
//        清空昵称
        perfectinActivity_clearNickmame = findViewById(R.id.perfectinActivity_clearNickmame);
        perfectinActivity_clearNickmame.setOnClickListener(this);
//        选择男性
        perfectinActivity_Man = findViewById(R.id.perfectinActivity_Man);
        perfectinActivity_Rg = findViewById(R.id.perfectinActivity_Rg);

//        选择女性
        perfectinActivity_woman = findViewById(R.id.perfectinActivity_woman);
//        密码
        perfectinActivity_Password = findViewById(R.id.perfectinActivity_Password);
//        清空密码
        perfectinActivity_clearPassword = findViewById(R.id.perfectinActivity_clearPassword);
//        、完成
        perfectinActivity_over = findViewById(R.id.perfectinActivity_over);
        perfectinActivity_Rg.setOnCheckedChangeListener(this);
        perfectinActivity_over.setOnClickListener(this);
        perfectinActivity_clearPassword.setOnClickListener(this);
//        创建P层对象
        contract = new IpPerfectinPersenter(this);
    }

    @Override
    protected void loadData() {
        preferences = getSharedPreferences("Register", MODE_PRIVATE);
        perfectinActivity_Photograph.setOnClickListener(this);
        perfectinActivity_Nickname.addTextChangedListener(new TextWatcher() {
            @Override
//            变化时
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                perfectinActivity_clearNickmame.setVisibility(View.VISIBLE);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
//            变化结束后
            public void afterTextChanged(Editable s) {
                contract.loadJudgeNickName(perfectinActivity_Nickname.getText().toString().trim(), perfectinActivity_over);
            }
        });
        perfectinActivity_Password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                perfectinActivity_clearPassword.setVisibility(View.VISIBLE);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                perfectinActivity_over.setBackgroundColor(Color.parseColor("#142fdf"));
                perfectinActivity_over.setEnabled(true);
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.perfectinActivity_Photograph:
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 100);

                break;
            case R.id.perfectinActivity_clearNickmame:
                perfectinActivity_Nickname.setText("");
                perfectinActivity_clearNickmame.setVisibility(View.GONE);
                break;
            case R.id.perfectinActivity_clearPassword:
                perfectinActivity_Password.setText("");
                perfectinActivity_clearPassword.setVisibility(View.GONE);
                break;
            case R.id.perfectinActivity_over:
//                判断密码
                contract.loadJudgePassword(perfectinActivity_Password.getText().toString().trim(), perfectinActivity_over);
//                如果男性被选中
                if (perfectinActivity_Man.isChecked()) {
                    SEX = MAN;
                } else if (perfectinActivity_woman.isChecked()) {
                    SEX = WOMAN;
                } else {
                    ToastUtils.mainThread("请选择性别", 0);
                }
                if (image_file == null) {
                    ToastUtils.mainThread("头像未上传", 0);
                    return;
                }
//                P层头像上传的方法
                contract.loadHeader(ShareUtils.getToken(), image_file);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //        获取系统时间
        date = new Date(System.currentTimeMillis());
//        头像路径
        dateFormat = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss");
        image_file = new File(PerfectinActivity.this.getPackageName() + ".authority.fileprovider", Environment.getExternalStorageDirectory() + File.separator + dateFormat.format(date) + ".jpg");
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            // /////////////////获取照片后进行裁剪//////////
            uri_xiangCe = data.getData();
            //                调用P层裁剪方法
            Intent intent = new Intent("com.android.camera.action.CROP");
            contract.loadHeadPortrait(date, intent, uri_xiangCe, image_file);
            startActivityForResult(intent, 113);
        }
        // 裁剪返回
        if (requestCode == 113 && resultCode == RESULT_OK) {
            // 取得SDCard图片路径做显示
            Bundle extras = data.getExtras();
            // 得到图片
            Bitmap photo = extras.getParcelable("data");
            perfectinActivity_header.setImageBitmap(photo);

        }
    }

    @Override
    public void showMessage(String mes) {
        ToastUtils.mainThread(mes, 0);
    }

    /**
     * 图片上传
     *
     * @param upLoadImgModel
     */
    @Override
    public void showUpLoadHeaderImg(UpLoadImgModel upLoadImgModel) {
//        上传的图片路径
        ImgUrl = upLoadImgModel.getData().getFileName();
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("imgUrl", ImgUrl);
        edit.commit();
        ToastUtils.mainThread("上传成功", 0);
        contract.loadPerfectOver(perfectinActivity_Nickname.getText().toString().trim(),
                SEX, ImgUrl, preferences.getString("phone", "手机号没有获取到"), perfectinActivity_Password.getText().toString().trim());
        ToastUtils.mainThread("完善成功", 0);
//        将性别储存到SharedPreferences里
        LoginShareUtils.userAddDataSharedPreferences(PerfectinActivity.this, null, "sex", String.valueOf(SEX));
    }


    @Override
    public void showPerfectOver(CheckUserLoginModel checkUserLoginModel) {
        String message = checkUserLoginModel.getMessage();
        ToastUtils.mainThread(message, 0);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.perfectinActivity_Man:
                perfectinActivity_Man.setBackgroundColor(Color.parseColor("#de2a2a"));
                perfectinActivity_woman.setBackgroundColor(Color.parseColor("#fffefe"));
                break;
            case R.id.perfectinActivity_woman:
                perfectinActivity_woman.setBackgroundColor(Color.parseColor("#de2a2a"));
                perfectinActivity_Man.setBackgroundColor(Color.parseColor("#fffefe"));
                break;
        }
    }
}
