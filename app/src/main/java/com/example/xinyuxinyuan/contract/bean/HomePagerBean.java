package com.example.xinyuxinyuan.contract.bean;

import java.util.List;

/**
 * Created by asd on 2018/5/10.
 */

public class HomePagerBean {

    /**
     * code : 0
     * message : 成功
     * data : {"homewokList":{"pageNum":1,"pageSize":20,"size":0,"startRow":0,"endRow":0,"total":0,"pages":0,"list":[],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[],"navigateFirstPage":0,"navigateLastPage":0,"firstPage":0,"lastPage":0},"userInfo":{"nickname":"大爷","photo":"http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg","attention":0,"attentionCount":2,"fansCount":2,"userType":1,"userId":664}}
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
         * homewokList : {"pageNum":1,"pageSize":20,"size":0,"startRow":0,"endRow":0,"total":0,"pages":0,"list":[],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[],"navigateFirstPage":0,"navigateLastPage":0,"firstPage":0,"lastPage":0}
         * userInfo : {"nickname":"大爷","photo":"http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg","attention":0,"attentionCount":2,"fansCount":2,"userType":1,"userId":664}
         */

        private HomewokListBean homewokList;
        private UserInfoBean userInfo;

        public HomewokListBean getHomewokList() {
            return homewokList;
        }

        public void setHomewokList(HomewokListBean homewokList) {
            this.homewokList = homewokList;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public static class HomewokListBean {
            /**
             * pageNum : 1
             * pageSize : 20
             * size : 0
             * startRow : 0
             * endRow : 0
             * total : 0
             * pages : 0
             * list : []
             * prePage : 0
             * nextPage : 0
             * isFirstPage : true
             * isLastPage : false
             * hasPreviousPage : false
             * hasNextPage : false
             * navigatePages : 8
             * navigatepageNums : []
             * navigateFirstPage : 0
             * navigateLastPage : 0
             * firstPage : 0
             * lastPage : 0
             */

            private int pageNum;
            private int pageSize;
            private int size;
            private int startRow;
            private int endRow;
            private int total;
            private int pages;
            private int prePage;
            private int nextPage;
            private boolean isFirstPage;
            private boolean isLastPage;
            private boolean hasPreviousPage;
            private boolean hasNextPage;
            private int navigatePages;
            private int navigateFirstPage;
            private int navigateLastPage;
            private int firstPage;
            private int lastPage;
            private List<?> list;
            private List<?> navigatepageNums;

            public int getPageNum() {
                return pageNum;
            }

            public void setPageNum(int pageNum) {
                this.pageNum = pageNum;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getStartRow() {
                return startRow;
            }

            public void setStartRow(int startRow) {
                this.startRow = startRow;
            }

            public int getEndRow() {
                return endRow;
            }

            public void setEndRow(int endRow) {
                this.endRow = endRow;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getPrePage() {
                return prePage;
            }

            public void setPrePage(int prePage) {
                this.prePage = prePage;
            }

            public int getNextPage() {
                return nextPage;
            }

            public void setNextPage(int nextPage) {
                this.nextPage = nextPage;
            }

            public boolean isIsFirstPage() {
                return isFirstPage;
            }

            public void setIsFirstPage(boolean isFirstPage) {
                this.isFirstPage = isFirstPage;
            }

            public boolean isIsLastPage() {
                return isLastPage;
            }

            public void setIsLastPage(boolean isLastPage) {
                this.isLastPage = isLastPage;
            }

            public boolean isHasPreviousPage() {
                return hasPreviousPage;
            }

            public void setHasPreviousPage(boolean hasPreviousPage) {
                this.hasPreviousPage = hasPreviousPage;
            }

            public boolean isHasNextPage() {
                return hasNextPage;
            }

            public void setHasNextPage(boolean hasNextPage) {
                this.hasNextPage = hasNextPage;
            }

            public int getNavigatePages() {
                return navigatePages;
            }

            public void setNavigatePages(int navigatePages) {
                this.navigatePages = navigatePages;
            }

            public int getNavigateFirstPage() {
                return navigateFirstPage;
            }

            public void setNavigateFirstPage(int navigateFirstPage) {
                this.navigateFirstPage = navigateFirstPage;
            }

            public int getNavigateLastPage() {
                return navigateLastPage;
            }

            public void setNavigateLastPage(int navigateLastPage) {
                this.navigateLastPage = navigateLastPage;
            }

            public int getFirstPage() {
                return firstPage;
            }

            public void setFirstPage(int firstPage) {
                this.firstPage = firstPage;
            }

            public int getLastPage() {
                return lastPage;
            }

            public void setLastPage(int lastPage) {
                this.lastPage = lastPage;
            }

            public List<?> getList() {
                return list;
            }

            public void setList(List<?> list) {
                this.list = list;
            }

            public List<?> getNavigatepageNums() {
                return navigatepageNums;
            }

            public void setNavigatepageNums(List<?> navigatepageNums) {
                this.navigatepageNums = navigatepageNums;
            }
        }

        public static class UserInfoBean {
            /**
             * nickname : 大爷
             * photo : http://qiniu.5roo.com/ef4838e8-6346-4dc9-9263-d7dff9c73443.jpg
             * attention : 0
             * attentionCount : 2
             * fansCount : 2
             * userType : 1
             * userId : 664
             */

            private String nickname;
            private String photo;
            private int attention;
            private int attentionCount;
            private int fansCount;
            private int userType;
            private int userId;

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public int getAttention() {
                return attention;
            }

            public void setAttention(int attention) {
                this.attention = attention;
            }

            public int getAttentionCount() {
                return attentionCount;
            }

            public void setAttentionCount(int attentionCount) {
                this.attentionCount = attentionCount;
            }

            public int getFansCount() {
                return fansCount;
            }

            public void setFansCount(int fansCount) {
                this.fansCount = fansCount;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }
        }
    }
}
