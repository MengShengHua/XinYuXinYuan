package com.example.xinyuxinyuan.contract.bean;

/**
 * Created by vicoltree on 17/10/29.
 */

public class UpLoadImgModel {

    /**
     * code : 0
     * message : 成功
     * data : {"fileName":"http://qiniu.5roo.com/8e557484-1d1e-4958-8f69-6af93d09d235.png"}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * fileName : http://qiniu.5roo.com/8e557484-1d1e-4958-8f69-6af93d09d235.png
         */

        private String fileName;

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }
    }
}