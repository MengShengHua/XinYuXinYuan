package com.example.xinyuxinyuan.model.bean;

/**
 * Created by vicoltree on 17/11/30.
 */

public class NoticeDetailOrderBean {


    /**
     * code : 0
     * message : 成功
     * data : {"id":40,"page":1,"rows":20,"orderNo":"171130110254050","buyerId":73,"buyerNickname":"xyxy","buyerMobile":"15701662050","buyerRealname":"xyxyx","sellerId":0,"sellerNickname":"星语心愿平台","sellerMobile":null,"sellerRealname":"星语心愿平台","refId":20,"refType":"体验课","refTitle":"哈哈","originalPrice":null,"actualPriceac":1,"discount":null,"bankType":null,"openid":null,"leaveMessage":null,"payTime":null,"deviceInfo":null,"feeType":null,"tradeType":null,"tradeNo":null,"mchId":null,"remark":null,"createDate":null,"orderStatus":null,"status":null}
     */

    private int code;
    private String message;
    private DataBean data;

    @Override
    public String toString() {
        return "NoticeDetailOrderBean{" +
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

        private int id;
        private int page;
        private int rows;
        private String orderNo;

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", page=" + page +
                    ", rows=" + rows +
                    ", orderNo='" + orderNo + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getRows() {
            return rows;
        }

        public void setRows(int rows) {
            this.rows = rows;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

    }
}
