package com.example.xinyuxinyuan.utils;

import android.widget.Toast;

import com.example.xinyuxinyuan.App;

/**
 * Created by asd on 2018/5/3.
 */

public class ToastUtils {

    public static void mainThread(String toastData, int toastTime) {
        Toast.makeText(App.context, toastData, toastTime).show();
    }

    public static void childThread(final String toastData, final int toastTime) {
        App.context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(App.context, toastData, toastTime).show();
            }
        });
    }
}
