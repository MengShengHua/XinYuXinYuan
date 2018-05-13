package com.example.xinyuxinyuan.view.activity.wode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.utils.CuttingUtils;
import com.example.xinyuxinyuan.utils.LoginShareUtils;
import com.example.xinyuxinyuan.view.activity.wode.set.EditActivity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyMessageActivity extends BaseActivity implements View.OnClickListener {

    private ImageView multiplexingTitle_return;
    private TextView multiplexingTitle_title;
    private ImageView messageActivity_HeaderTest;
    private LinearLayout messageActivity_Header;
    private TextView messageActivity_nickNameTest;
    private LinearLayout messageActivity_nickName;
    private TextView messageActivity_sexTest;
    private LinearLayout messageActivity_sex;
    private TextView messageActivity_regionTest;
    private LinearLayout messageActivity_region;
    private TextView messageActivity_BirthdayTest;
    private LinearLayout messageActivity_Birthday;
    private Date date;
    private SimpleDateFormat dateFormat;
    private File image_file;

    private void initView() {
//        返回上页面
        multiplexingTitle_return = (ImageView) findViewById(R.id.multiplexingTitle_return);
        multiplexingTitle_title = (TextView) findViewById(R.id.multiplexingTitle_title);
        multiplexingTitle_title.setText("我的信息");
//        头像图片
        messageActivity_HeaderTest = (ImageView) findViewById(R.id.messageActivity_HeaderTest);
//        头像
        messageActivity_Header = (LinearLayout) findViewById(R.id.messageActivity_Header);
//        用户昵称
        messageActivity_nickNameTest = (TextView) findViewById(R.id.messageActivity_nickNameTest);
//        昵称
        messageActivity_nickName = (LinearLayout) findViewById(R.id.messageActivity_nickName);
//        用户性别
        messageActivity_sexTest = (TextView) findViewById(R.id.messageActivity_sexTest);
//        性别
        messageActivity_sex = (LinearLayout) findViewById(R.id.messageActivity_sex);
//        用户地区
        messageActivity_regionTest = (TextView) findViewById(R.id.messageActivity_regionTest);
//        地区
        messageActivity_region = (LinearLayout) findViewById(R.id.messageActivity_region);
//        用户生日
        messageActivity_BirthdayTest = (TextView) findViewById(R.id.messageActivity_BirthdayTest);
//        生日
        messageActivity_Birthday = (LinearLayout) findViewById(R.id.messageActivity_Birthday);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_message;
    }

    @Override
    protected void init() {
        initView();
        loadUserHeader();
        OnClickListener();
        messageActivity_nickNameTest.setText(LoginShareUtils.getUserMessage(MyMessageActivity.this, "nickname"));
        messageActivity_sexTest.setText(LoginShareUtils.getUserMessage(MyMessageActivity.this, "sex"));
        if (LoginShareUtils.getUserMessage(MyMessageActivity.this, "address") != null) {
            messageActivity_regionTest.setText(LoginShareUtils.getUserMessage(MyMessageActivity.this, "address"));
        } else {
            messageActivity_regionTest.setText("请填写地区");
        }
    }


    private void OnClickListener() {
        multiplexingTitle_return.setOnClickListener(this);
        messageActivity_Header.setOnClickListener(this);
        messageActivity_nickName.setOnClickListener(this);
        messageActivity_sex.setOnClickListener(this);
        messageActivity_region.setOnClickListener(this);
        messageActivity_Birthday.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MyMessageActivity.this, EditActivity.class);
        switch (view.getId()) {
            case R.id.multiplexingTitle_return:
                finish();
                break;
            case R.id.messageActivity_Header:
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 100);
                break;
            case R.id.messageActivity_nickName:
//                用来标记是哪个控件跳转的界面
                intent.putExtra("nickName", true);
                startActivity(intent);
                break;
            case R.id.messageActivity_sex:
                break;
            case R.id.messageActivity_region:
//                用来标记是哪个控件跳转的界面
                intent.putExtra("nickName", false);
                startActivity(intent);
                break;
            case R.id.messageActivity_Birthday:
                break;
        }
    }

    private void loadUserHeader() {
        Glide.with(this).load(LoginShareUtils.getUserMessage(MyMessageActivity.this, "photo")).asBitmap()
                .override(200, 200).into(new BitmapImageViewTarget(messageActivity_HeaderTest) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getResources(), resource);
                drawable.setCircular(true);
                messageActivity_HeaderTest.setImageDrawable(drawable);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //        获取系统时间
        date = new Date(System.currentTimeMillis());
//        头像路径
        dateFormat = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss");
        image_file = new File(Environment.getExternalStorageDirectory() + File.separator + dateFormat.format(date) + ".jpg");
        super.onActivityResult(requestCode, resultCode, data);
        if (image_file != null) {
            LoginShareUtils.deleteUserData(MyMessageActivity.this, "photo");
            LoginShareUtils.userAddDataSharedPreferences(MyMessageActivity.this, null, "photo", image_file.getPath());
            Log.e("图片路径", image_file.getPath());
        }
        if (requestCode == 100 && resultCode == RESULT_OK) {
            // /////////////////获取照片后进行裁剪//////////
            Uri uri_xiangCe = data.getData();
            //                调用P层裁剪方法
            Intent intent = new Intent("com.android.camera.action.CROP");
            CuttingUtils.imgCutting(date, intent, uri_xiangCe, image_file);

            startActivityForResult(intent, 113);

        }
        // 裁剪返回
        if (requestCode == 113 && resultCode == RESULT_OK) {
            // 取得SDCard图片路径做显示
            Bundle extras = data.getExtras();
            // 得到图片
            Bitmap photo = extras.getParcelable("data");
            messageActivity_HeaderTest.setImageBitmap(photo);

        }
    }
}
