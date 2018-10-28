package com.example.xinyuxinyuan.contract.bean;

/**
 * Created by vicoltree on 17/11/30.
 */

public class ALiPayModel {


    /**
     * code : 0
     * message : 成功
     */

    private int code;
    private String message;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
