package com.example.xinyuxinyuan.utils;

import com.example.xinyuxinyuan.App;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class CacheUtils {

    public static DecimalFormat format;

    /**
     * * 清除本应用缓存
     */
    public static boolean deleteCache(File dir) {
        App.context.getCacheDir();
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            int size = 0;
            if (children != null) {
                size = children.length;
                for (int i = 0; i < size; i++) {
                    boolean success = deleteCache(new File(dir, children[i]));
                    if (!success) {
                        return false;
                    }
                }
            }

        }
        if (dir == null) {
            return true;
        } else {
            return dir.delete();
        }
    }


    /**
     * 获取文件
     */
    private static long getFolderSize(File file) throws Exception {
        long size = 0;
        try {
            File[] fileList = file.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                // 如果下面还有文件
                if (fileList[i].isDirectory()) {
                    size = size + getFolderSize(fileList[i]);
                } else {
                    size = size + fileList[i].length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }

    /**
     * 格式化单位
     */
    private static String getFormatSize(double size) {
        //保留两位小数
        format = new DecimalFormat("0.00");
        double kiloByte = size / 1024;
        String format = CacheUtils.format.format(size);
        if (kiloByte < 1) {
            return format + "B";
        }

        double megaByte = kiloByte / 1024;
        if (megaByte < 1) {
            BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
            return result1.setScale(2, BigDecimal.ROUND_HALF_UP)
                    .toPlainString() + "K";
        }

        double gigaByte = megaByte / 1024;
        if (gigaByte < 1) {
            BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
            return result2.setScale(2, BigDecimal.ROUND_HALF_UP)
                    .toPlainString() + "M";
        }

        double teraBytes = gigaByte / 1024;
        if (teraBytes < 1) {
            BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
            return result3.setScale(2, BigDecimal.ROUND_HALF_UP)
                    .toPlainString() + "G";
        }
        BigDecimal result4 = new BigDecimal(teraBytes);
        return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()
                + "T";
    }

    /***
     * 获取应用缓存大小
     */
    public static String getCacheSize(){
        try {
            return getFormatSize(getFolderSize(App.context.getCacheDir()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0.0M";
    }
}
