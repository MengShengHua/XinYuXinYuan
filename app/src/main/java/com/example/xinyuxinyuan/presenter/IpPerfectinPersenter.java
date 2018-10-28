package com.example.xinyuxinyuan.presenter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.Button;

import com.example.xinyuxinyuan.model.bean.CheckUserLoginModel;
import com.example.xinyuxinyuan.model.bean.UpLoadImgModel;
import com.example.xinyuxinyuan.contract.PerfectinContract;
import com.example.xinyuxinyuan.model.regist.RegistModel;
import com.example.xinyuxinyuan.utils.RetrofitUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by asd on 2018/5/3.
 */

public class IpPerfectinPersenter implements PerfectinContract.Perfectinpresenter {
    private PerfectinContract.PerfectinView view;
    private final RegistModel service;

    public IpPerfectinPersenter(PerfectinContract.PerfectinView view) {
        this.view = view;
        service = RetrofitUtils.getRetrofitUtils().getService(RegistModel.class);
    }

    /**
     * 打开相册
     */
    @Override
    public void loadHeadPortrait(Date date, Intent intent, Uri uri_xiangCe, File image_file) {
        intent.setDataAndType(uri_xiangCe, "image/*");
        // crop为true是设置在开启的intent中设置显示的view可以剪裁
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX,outputY 是剪裁图片的宽高
        intent.putExtra("outputX", 160);
        intent.putExtra("outputY", 160);
        intent.putExtra("return-data", true);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(image_file));
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
    }

    /**
     * 对昵称进行判断
     *
     * @param name
     * @param button
     */
    @Override
    public void loadJudgeNickName(String name, Button button) {
        if (name.length() > 16) {
//        不符合规则
            button.setBackgroundColor(Color.parseColor("#e6e3e3"));
            view.showMessage("昵称只能（1-16）位");
            button.setEnabled(false);
        } else {
            button.setBackgroundColor(Color.parseColor("#142fdf"));
            button.setEnabled(true);

        }
    }

    /**
     * 对密码进行判断
     *
     * @param password
     * @param button
     */
    @Override
    public void loadJudgePassword(String password, Button button) {
//        不符合规则
        if (password.length() < 6 || password.length() > 16) {
            button.setBackgroundColor(Color.parseColor("#e6e3e3"));
            view.showMessage("密码只能（6-16）位");
            button.setEnabled(false);
        } else {
            button.setBackgroundColor(Color.parseColor("#142fdf"));
            button.setEnabled(true);
        }
    }

    /**
     * 头像上传
     * 放弃上传，因上传了一天
     *
     * @param image_file
     */
    @Override
    public void loadHeader(String token, File image_file) {
        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);
        RequestBody imageBody = RequestBody.create(MediaType.parse("*jpg"), image_file);
        builder.addFormDataPart("file", image_file.getName(), imageBody);
        List<MultipartBody.Part> parts = builder.build().parts();
        HashMap<String, String> headerMap = new HashMap<>();
//        headerMap.put("Authorization", token);
        service.loadHeaderImg(ShareUtils.getToken(),parts, headerMap)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<UpLoadImgModel>() {
                    @Override
                    public void accept(UpLoadImgModel upLoadImgModel) throws Exception {
                        view.showUpLoadHeaderImg(upLoadImgModel);

                    }
                });
    }

    /**
     * 点击完成时，对数据进行提交
     *
     * @param nickname
     * @param sex
     * @param header
     * @param phone
     * @param password
     */
    @Override
    public void loadPerfectOver(String nickname, Integer sex, String header, String phone, String password) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("nickname", nickname);
        params.put("sex", sex);
        params.put("photo", header);
        params.put("mobile", phone);
        params.put("psw", password);
        service.loadUserInformationLogin(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<CheckUserLoginModel>() {
                    @Override
                    public void accept(CheckUserLoginModel checkUserLoginModel) throws Exception {
                        view.showPerfectOver(checkUserLoginModel);
                    }
                });
    }


}
