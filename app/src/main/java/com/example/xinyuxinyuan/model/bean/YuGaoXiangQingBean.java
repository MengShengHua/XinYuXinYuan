package com.example.xinyuxinyuan.model.bean;

/**
 * Created by 键盘上的手艺人 on 2018/5/12.
 */

public class YuGaoXiangQingBean {

    /**
     * code : 0
     * message : 成功
     * data : {"address":"北京市朝阳区亚运村曹八里1号院6号楼-星语心愿艺教","coverImg":"http://qiniu.5roo.com/0e9fca4e-def4-493d-85a5-8b391e8b25b7.jpg","endDate":1523692800000,"collegeIds":"5","reservationNum":21,"mobile":"13691095049","isReservation":0,"title":"艺术沙龙：把你的小梦想，带到更大的艺术世界","courseContent":"<p><img src=\"http://qiniu.5roo.com/d19d7bea-9716-4fca-acec-b5efa0640ec4.jpg\" style=\"max-width:100%;\"><\/p><p><img src=\"http://qiniu.5roo.com/73496b73-cdc7-4cd8-8f7c-12172cbf7e33.jpg\" style=\"max-width: 100%;\"><\/p><p><img src=\"http://qiniu.5roo.com/1592099a-f73d-486e-b25d-af7b90fb9d80.jpg\" style=\"max-width: 100%;\"><br><\/p>","majorIds":"6","subscribeNum":20,"price":128,"id":66,"favorite":0,"startDate":1523685600000,"courseVideoPath":""}
     */

    private int code;
    private String message;
    private DataBean data;

    @Override
    public String toString() {
        return "YuGaoXiangQingBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

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
         * address : 北京市朝阳区亚运村曹八里1号院6号楼-星语心愿艺教
         * coverImg : http://qiniu.5roo.com/0e9fca4e-def4-493d-85a5-8b391e8b25b7.jpg
         * endDate : 1523692800000
         * collegeIds : 5
         * reservationNum : 21
         * mobile : 13691095049
         * isReservation : 0
         * title : 艺术沙龙：把你的小梦想，带到更大的艺术世界
         * courseContent : <p><img src="http://qiniu.5roo.com/d19d7bea-9716-4fca-acec-b5efa0640ec4.jpg" style="max-width:100%;"></p><p><img src="http://qiniu.5roo.com/73496b73-cdc7-4cd8-8f7c-12172cbf7e33.jpg" style="max-width: 100%;"></p><p><img src="http://qiniu.5roo.com/1592099a-f73d-486e-b25d-af7b90fb9d80.jpg" style="max-width: 100%;"><br></p>
         * majorIds : 6
         * subscribeNum : 20
         * price : 128
         * id : 66
         * favorite : 0
         * startDate : 1523685600000
         * courseVideoPath :
         */

        private String address;
        private String coverImg;
        private long endDate;
        private String collegeIds;
        private int reservationNum;
        private String mobile;
        private int isReservation;
        private String title;
        private String courseContent;
        private String majorIds;
        private int subscribeNum;
        private int price;
        private int id;
        private int favorite;
        private long startDate;
        private String courseVideoPath;

        @Override
        public String toString() {
            return "DataBean{" +
                    "address='" + address + '\'' +
                    ", coverImg='" + coverImg + '\'' +
                    ", endDate=" + endDate +
                    ", collegeIds='" + collegeIds + '\'' +
                    ", reservationNum=" + reservationNum +
                    ", mobile='" + mobile + '\'' +
                    ", isReservation=" + isReservation +
                    ", title='" + title + '\'' +
                    ", courseContent='" + courseContent + '\'' +
                    ", majorIds='" + majorIds + '\'' +
                    ", subscribeNum=" + subscribeNum +
                    ", price=" + price +
                    ", id=" + id +
                    ", favorite=" + favorite +
                    ", startDate=" + startDate +
                    ", courseVideoPath='" + courseVideoPath + '\'' +
                    '}';
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCoverImg() {
            return coverImg;
        }

        public void setCoverImg(String coverImg) {
            this.coverImg = coverImg;
        }

        public long getEndDate() {
            return endDate;
        }

        public void setEndDate(long endDate) {
            this.endDate = endDate;
        }

        public String getCollegeIds() {
            return collegeIds;
        }

        public void setCollegeIds(String collegeIds) {
            this.collegeIds = collegeIds;
        }

        public int getReservationNum() {
            return reservationNum;
        }

        public void setReservationNum(int reservationNum) {
            this.reservationNum = reservationNum;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getIsReservation() {
            return isReservation;
        }

        public void setIsReservation(int isReservation) {
            this.isReservation = isReservation;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCourseContent() {
            return courseContent;
        }

        public void setCourseContent(String courseContent) {
            this.courseContent = courseContent;
        }

        public String getMajorIds() {
            return majorIds;
        }

        public void setMajorIds(String majorIds) {
            this.majorIds = majorIds;
        }

        public int getSubscribeNum() {
            return subscribeNum;
        }

        public void setSubscribeNum(int subscribeNum) {
            this.subscribeNum = subscribeNum;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getFavorite() {
            return favorite;
        }

        public void setFavorite(int favorite) {
            this.favorite = favorite;
        }

        public long getStartDate() {
            return startDate;
        }

        public void setStartDate(long startDate) {
            this.startDate = startDate;
        }

        public String getCourseVideoPath() {
            return courseVideoPath;
        }

        public void setCourseVideoPath(String courseVideoPath) {
            this.courseVideoPath = courseVideoPath;
        }
    }
}
