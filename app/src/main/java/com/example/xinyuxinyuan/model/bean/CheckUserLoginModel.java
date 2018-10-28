package com.example.xinyuxinyuan.model.bean;

/**
 * Created by asd on 2018/5/4.
 */

public class CheckUserLoginModel {

    /**
     * code : 0
     * message : 成功
     * data : {"nickname":"0050953","mobile":null,"photo":null,"id":743,"token":"eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJmMjQzaWsiLCJzdWIiOiI3NDMiLCJleHAiOjE1MjYwMjk4MTgsImlhdCI6MTUyNTQyNTAxOH0.HGEbB53KTvpLtVWkkBMGGJswnu9nQEUuRqpF7AxzqK1GqkvHXbE2mkdAbS_mryQhSqIGYykaN4yZTgh8eXBVoQ"}
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
         * nickname : 0050953
         * mobile : null
         * photo : null
         * id : 743
         * token : eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJmMjQzaWsiLCJzdWIiOiI3NDMiLCJleHAiOjE1MjYwMjk4MTgsImlhdCI6MTUyNTQyNTAxOH0.HGEbB53KTvpLtVWkkBMGGJswnu9nQEUuRqpF7AxzqK1GqkvHXbE2mkdAbS_mryQhSqIGYykaN4yZTgh8eXBVoQ
         */

        private String nickname;
        private Object mobile;
        private Object photo;
        private int id;
        private String token;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public Object getMobile() {
            return mobile;
        }

        public void setMobile(Object mobile) {
            this.mobile = mobile;
        }

        public Object getPhoto() {
            return photo;
        }

        public void setPhoto(Object photo) {
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
