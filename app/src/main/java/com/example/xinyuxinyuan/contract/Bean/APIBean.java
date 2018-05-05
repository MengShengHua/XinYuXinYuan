package com.example.xinyuxinyuan.contract.Bean;

/**
 * Created by 键盘上的手艺人 on 2018/5/4.
 */

public class APIBean {

    /**
     * code : 0
     * message : 成功
     * data : {"apptoken":"G00hN1wuqkr/NStp+5iS7itUQup0nEDpNHELksZAl9yaUIXK1tVHgg=="}
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
         * apptoken : G00hN1wuqkr/NStp+5iS7itUQup0nEDpNHELksZAl9yaUIXK1tVHgg==
         */

        private String apptoken;

        public String getApptoken() {
            return apptoken;
        }

        public void setApptoken(String apptoken) {
            this.apptoken = apptoken;
        }
    }
}
