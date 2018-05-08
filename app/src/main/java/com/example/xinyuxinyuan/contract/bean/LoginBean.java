package com.example.xinyuxinyuan.contract.bean;

/**
 * Created by asd on 2018/5/4.
 */

public class LoginBean {


    /**
     * code : 1
     * message : cid为空
     * data : {"nickname":"顾陈","mobile":"17633301440","photo":"http://qiniu.5roo.com/feed24bae7e14a249aa48eaad4fdd162.jpg","id":827,"token":"eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJoMmN1MXciLCJzdWIiOiI4MjciLCJleHAiOjE1MjYxMDk4OTUsImlhdCI6MTUyNTUwNTA5NX0.v_zK_MezbRMdEBLeRrVVa0xbZLw7-x4jUprDZ57X9SZQHJ30WXtoMTc5PIQvlnMTcChTk3RcniIcDrH11RgS6g"}
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
         * nickname : 顾陈
         * mobile : 17633301440
         * photo : http://qiniu.5roo.com/feed24bae7e14a249aa48eaad4fdd162.jpg
         * id : 827
         * token : eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJoMmN1MXciLCJzdWIiOiI4MjciLCJleHAiOjE1MjYxMDk4OTUsImlhdCI6MTUyNTUwNTA5NX0.v_zK_MezbRMdEBLeRrVVa0xbZLw7-x4jUprDZ57X9SZQHJ30WXtoMTc5PIQvlnMTcChTk3RcniIcDrH11RgS6g
         */

        private String nickname;
        private String mobile;
        private String photo;
        private int id;
        private String token;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
