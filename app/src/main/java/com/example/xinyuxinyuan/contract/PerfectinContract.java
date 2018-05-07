package com.example.xinyuxinyuan.contract;

import android.content.Intent;
import android.net.Uri;
import android.widget.Button;

import com.example.xinyuxinyuan.contract.Bean.CheckUserLoginModel;
import com.example.xinyuxinyuan.contract.Bean.UpLoadImgModel;

import java.io.File;
import java.util.Date;

/**
 * Created by asd on 2018/5/3.
 */

public interface PerfectinContract {
    interface Perfectinpresenter {
        void loadHeadPortrait(Date date, Intent intent, Uri uri_xiangCe, File image_file);

        void loadJudgeNickName(String name, Button button);

        void loadJudgePassword(String password, Button button);

        void loadHeader(String token,File image_file);

        void loadPerfectOver(String nickname, Integer sex, String header, String phone, String password);
    }

    interface PerfectinView {
        //        void showHeader(Bitmap bitmap);
        void showMessage(String mes);

        void showUpLoadHeaderImg(UpLoadImgModel upLoadImgModel);

        void showPerfectOver(CheckUserLoginModel checkUserLoginModel);
    }
}
