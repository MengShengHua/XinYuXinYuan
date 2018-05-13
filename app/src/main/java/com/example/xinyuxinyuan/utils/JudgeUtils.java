package com.example.xinyuxinyuan.utils;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by asd on 2018/5/8.
 */

public class JudgeUtils {
    /**
     * 密码的判断
     * @param password
     * @param button
     * @param imageView
     */
    public static void judgePassword(String password, Button button, ImageView imageView) {
        if (password.length() >= 6) {
            button.setBackgroundColor(Color.parseColor("#142fdf"));
            button.setEnabled(true);
        } else {
            button.setBackgroundColor(Color.parseColor("#e6e3e3"));
            button.setEnabled(false);
        }
        if (password.equals("")) {
            imageView.setVisibility(View.GONE);
            button.setBackgroundColor(Color.parseColor("#e6e3e3"));
            button.setEnabled(false);
        }
    }
    public static void judgePhone(String phone, Button button, ImageView imageView) {
        String regex = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$";
        if (phone.length() == 11 && phone.matches(regex)) {
            button.setBackgroundColor(Color.parseColor("#142fdf"));
            button.setEnabled(true);
        } else {
            button.setBackgroundColor(Color.parseColor("#e6e3e3"));
            button.setEnabled(false);
        }
        if (phone.equals("")) {
            imageView.setVisibility(View.GONE);
            button.setBackgroundColor(Color.parseColor("#e6e3e3"));
            button.setEnabled(false);
        }
    }
}
