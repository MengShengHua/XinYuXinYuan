package com.example.xinyuxinyuan.contract.bean;

import java.util.List;

/**
 * Created by asd on 2018/5/12.
 */

public class HobbyBean {

    /**
     * code : 0
     * message : 成功
     * data : {"majors":[{"isMy":1,"name":"声乐","id":1},{"isMy":0,"name":"编导","id":2},{"isMy":0,"name":"空乘","id":5},{"isMy":0,"name":"表演","id":6},{"isMy":0,"name":"美术","id":7},{"isMy":0,"name":"器乐","id":27},{"isMy":1,"name":"舞蹈表演","id":32},{"isMy":0,"name":"舞蹈编导","id":33},{"isMy":0,"name":"戏剧文学","id":44},{"isMy":0,"name":"播音主持","id":49},{"isMy":0,"name":"其他","id":50}],"colleges":[{"isMy":1,"name":"中央音乐学院","id":1},{"isMy":1,"name":"中央美术学院","id":2},{"isMy":0,"name":"中央戏剧学院","id":3},{"isMy":0,"name":"北京电影学院","id":4},{"isMy":1,"name":"北京舞蹈学院","id":5},{"isMy":0,"name":"鲁迅美术学院","id":6},{"isMy":0,"name":"上海戏剧学院","id":7},{"isMy":0,"name":"中国戏曲学院","id":8},{"isMy":0,"name":"南京艺术学院","id":9},{"isMy":0,"name":"四川美术学院","id":10},{"isMy":0,"name":"四川音乐学院","id":11},{"isMy":0,"name":"沈阳音乐学院","id":12},{"isMy":0,"name":"中国音乐学院","id":14},{"isMy":0,"name":"中央工艺美术学院","id":15},{"isMy":0,"name":"北京师范大学","id":16},{"isMy":0,"name":"山西工商学院","id":17},{"isMy":0,"name":"武汉音乐学院","id":19},{"isMy":0,"name":"中南民族大学","id":20},{"isMy":0,"name":"河北传媒学院","id":21},{"isMy":0,"name":"陕西师范大学","id":23},{"isMy":0,"name":"西安培华学院","id":25},{"isMy":0,"name":"北京现代音乐学院","id":26},{"isMy":0,"name":"中国传媒大学","id":27},{"isMy":0,"name":"首都师范大学","id":28},{"isMy":0,"name":"广东外语外贸大学","id":29},{"isMy":0,"name":"广州美术学院","id":30},{"isMy":0,"name":"东北农业大学","id":31}]}
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
        private List<MajorsBean> majors;
        private List<CollegesBean> colleges;

        public List<MajorsBean> getMajors() {
            return majors;
        }

        public void setMajors(List<MajorsBean> majors) {
            this.majors = majors;
        }

        public List<CollegesBean> getColleges() {
            return colleges;
        }

        public void setColleges(List<CollegesBean> colleges) {
            this.colleges = colleges;
        }

        public static class MajorsBean {
            /**
             * isMy : 1
             * name : 声乐
             * id : 1
             */

            private int isMy;
            private String name;
            private int id;

            public int getIsMy() {
                return isMy;
            }

            public void setIsMy(int isMy) {
                this.isMy = isMy;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class CollegesBean {
            /**
             * isMy : 1
             * name : 中央音乐学院
             * id : 1
             */

            private int isMy;
            private String name;
            private int id;

            public int getIsMy() {
                return isMy;
            }

            public void setIsMy(int isMy) {
                this.isMy = isMy;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
