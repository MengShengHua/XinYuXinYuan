package com.example.xinyuxinyuan.contract.bean;

import java.util.List;

/**
 * Created by 键盘上的手艺人 on 2018/5/14.
 */

public class HuiBean {

    /**
     * code : 0
     * message : 成功
     * data : {"comments":{"pageNum":1,"pageSize":20,"size":0,"startRow":0,"endRow":0,"total":0,"pages":0,"list":[],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[],"navigateFirstPage":0,"navigateLastPage":0,"firstPage":0,"lastPage":0},"comment":{"photo":"http://qiniu.5roo.com/a8a84d5824fa490581ee2bed1e5659ef.jpg","praiseNum":0,"userId":919,"content":"666","realname":null,"replyName":null,"nickname":"\u2026\u2026","replyId":null,"replyNum":0,"isPraise":0,"id":624,"userType":1,"createDate":1526044435000}}
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
         * comments : {"pageNum":1,"pageSize":20,"size":0,"startRow":0,"endRow":0,"total":0,"pages":0,"list":[],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[],"navigateFirstPage":0,"navigateLastPage":0,"firstPage":0,"lastPage":0}
         * comment : {"photo":"http://qiniu.5roo.com/a8a84d5824fa490581ee2bed1e5659ef.jpg","praiseNum":0,"userId":919,"content":"666","realname":null,"replyName":null,"nickname":"\u2026\u2026","replyId":null,"replyNum":0,"isPraise":0,"id":624,"userType":1,"createDate":1526044435000}
         */

        private CommentsBean comments;
        private CommentBean comment;

        public CommentsBean getComments() {
            return comments;
        }

        public void setComments(CommentsBean comments) {
            this.comments = comments;
        }

        public CommentBean getComment() {
            return comment;
        }

        public void setComment(CommentBean comment) {
            this.comment = comment;
        }

        public static class CommentsBean {
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

        public static class CommentBean {
            /**
             * photo : http://qiniu.5roo.com/a8a84d5824fa490581ee2bed1e5659ef.jpg
             * praiseNum : 0
             * userId : 919
             * content : 666
             * realname : null
             * replyName : null
             * nickname : ……
             * replyId : null
             * replyNum : 0
             * isPraise : 0
             * id : 624
             * userType : 1
             * createDate : 1526044435000
             */

            private String photo;
            private int praiseNum;
            private int userId;
            private String content;
            private Object realname;
            private Object replyName;
            private String nickname;
            private Object replyId;
            private int replyNum;
            private int isPraise;
            private int id;
            private int userType;
            private long createDate;

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public int getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(int praiseNum) {
                this.praiseNum = praiseNum;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public Object getRealname() {
                return realname;
            }

            public void setRealname(Object realname) {
                this.realname = realname;
            }

            public Object getReplyName() {
                return replyName;
            }

            public void setReplyName(Object replyName) {
                this.replyName = replyName;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public Object getReplyId() {
                return replyId;
            }

            public void setReplyId(Object replyId) {
                this.replyId = replyId;
            }

            public int getReplyNum() {
                return replyNum;
            }

            public void setReplyNum(int replyNum) {
                this.replyNum = replyNum;
            }

            public int getIsPraise() {
                return isPraise;
            }

            public void setIsPraise(int isPraise) {
                this.isPraise = isPraise;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
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
