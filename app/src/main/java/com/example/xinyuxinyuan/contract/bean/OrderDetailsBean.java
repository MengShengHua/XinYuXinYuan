package com.example.xinyuxinyuan.contract.bean;

/**
 * Created by asd on 2018/5/11.
 */

public class OrderDetailsBean {

    /**
     * code : 0
     * message : 成功
     * data : {"orderInfo":{"orderNo":"180511150335077","coverImg":"http://qiniu.5roo.com/40a30523-0b69-4073-a453-38cf02349a68.jpg","price":1730,"bankType":"","orderStatus":2,"oid":1613,"refId":61,"title":"4天，32课时，轻松拿音基教师资格证","type":"体验","startDate":1521855000000,"createDate":1526022215000}}
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
         * orderInfo : {"orderNo":"180511150335077","coverImg":"http://qiniu.5roo.com/40a30523-0b69-4073-a453-38cf02349a68.jpg","price":1730,"bankType":"","orderStatus":2,"oid":1613,"refId":61,"title":"4天，32课时，轻松拿音基教师资格证","type":"体验","startDate":1521855000000,"createDate":1526022215000}
         */

        private OrderInfoBean orderInfo;

        public OrderInfoBean getOrderInfo() {
            return orderInfo;
        }

        public void setOrderInfo(OrderInfoBean orderInfo) {
            this.orderInfo = orderInfo;
        }

        public static class OrderInfoBean {
            /**
             * orderNo : 180511150335077
             * coverImg : http://qiniu.5roo.com/40a30523-0b69-4073-a453-38cf02349a68.jpg
             * price : 1730
             * bankType :
             * orderStatus : 2
             * oid : 1613
             * refId : 61
             * title : 4天，32课时，轻松拿音基教师资格证
             * type : 体验
             * startDate : 1521855000000
             * createDate : 1526022215000
             */

            private String orderNo;
            private String coverImg;
            private int price;
            private String bankType;
            private int orderStatus;
            private int oid;
            private int refId;
            private String title;
            private String type;
            private long startDate;
            private long createDate;

            public String getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(String orderNo) {
                this.orderNo = orderNo;
            }

            public String getCoverImg() {
                return coverImg;
            }

            public void setCoverImg(String coverImg) {
                this.coverImg = coverImg;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getBankType() {
                return bankType;
            }

            public void setBankType(String bankType) {
                this.bankType = bankType;
            }

            public int getOrderStatus() {
                return orderStatus;
            }

            public void setOrderStatus(int orderStatus) {
                this.orderStatus = orderStatus;
            }

            public int getOid() {
                return oid;
            }

            public void setOid(int oid) {
                this.oid = oid;
            }

            public int getRefId() {
                return refId;
            }

            public void setRefId(int refId) {
                this.refId = refId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public long getStartDate() {
                return startDate;
            }

            public void setStartDate(long startDate) {
                this.startDate = startDate;
            }

            public long getCreateDate() {
                return createDate;
            }

            public void setCreateDate(long createDate) {
                this.createDate = createDate;
            }
        }
    }
}
