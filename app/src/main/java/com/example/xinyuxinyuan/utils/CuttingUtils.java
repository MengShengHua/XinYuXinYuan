package com.example.xinyuxinyuan.utils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;
import java.util.Date;

/**
 * Created by asd on 2018/5/9.
 */

public class CuttingUtils {
    public static void imgCutting(Date date, Intent intent, Uri uri_xiangCe, File image_file) {
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
}
