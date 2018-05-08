package com.example.xinyuxinyuan.contract.bean;

import java.util.List;

/**
 * Created by 键盘上的手艺人 on 2018/5/5.
 */

public class ZuoYeBean {

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
        private List<ListBean> list;
        private List<Integer> navigatepageNums;

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

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<Integer> getNavigatepageNums() {
            return navigatepageNums;
        }

        public void setNavigatepageNums(List<Integer> navigatepageNums) {
            this.navigatepageNums = navigatepageNums;
        }

        public static class ListBean {
            /**
             * tUserType : 2
             * coverImg : http://qiniu.5roo.com/Fhy-iI1Bj2oo7Q1agYeGp48xbHEk?imageView2/0/w/480/h/270
             * praiseNum : 7
             * source : 求教作品
             * topTime : 0
             * isPeep : 0
             * content : 老师o(^o^)o我这个作品，请指导下。
             * studentId : 261
             * duration : null
             * path : http://qiniu.5roo.com/Fhy-iI1Bj2oo7Q1agYeGp48xbHEk
             * peepPrice : 1
             * tPhoto : http://qiniu.5roo.com/3dd87e36-ecfe-4049-bb1a-20c65b07f6e5.jpg
             * answerPermission : 0
             * worksType : 图片
             * giftNum : 7
             * nickname : 一只蜗牛
             * id : 220
             * tRealname : 张鹏远
             * createDate : 1517889135000
             * answerDate : 1518169517000
             * photo : http://qiniu.5roo.com/c6e0ff5d-7593-471b-8302-9006003a1b1f.jpg
             * majorIds : 10
             * commentNum : 0
             * tIntro : 美术达人
             * picProperty : 386_270
             * tUserId : 276
             * isPraise : 0
             * userType : 1
             * pushDate : 1522734871000
             * isAnswer : 0
             */

            private int tUserType;
            private String coverImg;
            private int praiseNum;
            private String source;
            private int topTime;
            private int isPeep;
            private String content;
            private int studentId;
            private Object duration;
            private String path;
            private int peepPrice;
            private String tPhoto;
            private int answerPermission;
            private String worksType;
            private int giftNum;
            private String nickname;
            private int id;
            private String tRealname;
            private long createDate;
            private long answerDate;
            private String photo;
            private String majorIds;
            private int commentNum;
            private String tIntro;
            private String picProperty;
            private int tUserId;
            private int isPraise;
            private int userType;
            private long pushDate;
            private int isAnswer;

            public int getTUserType() {
                return tUserType;
            }

            public void setTUserType(int tUserType) {
                this.tUserType = tUserType;
            }

            public String getCoverImg() {
                return coverImg;
            }

            public void setCoverImg(String coverImg) {
                this.coverImg = coverImg;
            }

            public int getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(int praiseNum) {
                this.praiseNum = praiseNum;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public int getTopTime() {
                return topTime;
            }

            public void setTopTime(int topTime) {
                this.topTime = topTime;
            }

            public int getIsPeep() {
                return isPeep;
            }

            public void setIsPeep(int isPeep) {
                this.isPeep = isPeep;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getStudentId() {
                return studentId;
            }

            public void setStudentId(int studentId) {
                this.studentId = studentId;
            }

            public Object getDuration() {
                return duration;
            }

            public void setDuration(Object duration) {
                this.duration = duration;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public int getPeepPrice() {
                return peepPrice;
            }

            public void setPeepPrice(int peepPrice) {
                this.peepPrice = peepPrice;
            }

            public String getTPhoto() {
                return tPhoto;
            }

            public void setTPhoto(String tPhoto) {
                this.tPhoto = tPhoto;
            }

            public int getAnswerPermission() {
                return answerPermission;
            }

            public void setAnswerPermission(int answerPermission) {
                this.answerPermission = answerPermission;
            }

            public String getWorksType() {
                return worksType;
            }

            public void setWorksType(String worksType) {
                this.worksType = worksType;
            }

            public int getGiftNum() {
                return giftNum;
            }

            public void setGiftNum(int giftNum) {
                this.giftNum = giftNum;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTRealname() {
                return tRealname;
            }

            public void setTRealname(String tRealname) {
                this.tRealname = tRealname;
            }

            public long getCreateDate() {
                return createDate;
            }

            public void setCreateDate(long createDate) {
                this.createDate = createDate;
            }

            public long getAnswerDate() {
                return answerDate;
            }

            public void setAnswerDate(long answerDate) {
                this.answerDate = answerDate;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getMajorIds() {
                return majorIds;
            }

            public void setMajorIds(String majorIds) {
                this.majorIds = majorIds;
            }

            public int getCommentNum() {
                return commentNum;
            }

            public void setCommentNum(int commentNum) {
                this.commentNum = commentNum;
            }

            public String getTIntro() {
                return tIntro;
            }

            public void setTIntro(String tIntro) {
                this.tIntro = tIntro;
            }

            public String getPicProperty() {
                return picProperty;
            }

            public void setPicProperty(String picProperty) {
                this.picProperty = picProperty;
            }

            public int getTUserId() {
                return tUserId;
            }

            public void setTUserId(int tUserId) {
                this.tUserId = tUserId;
            }

            public int getIsPraise() {
                return isPraise;
            }

            public void setIsPraise(int isPraise) {
                this.isPraise = isPraise;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public long getPushDate() {
                return pushDate;
            }

            public void setPushDate(long pushDate) {
                this.pushDate = pushDate;
            }

            public int getIsAnswer() {
                return isAnswer;
            }

            public void setIsAnswer(int isAnswer) {
                this.isAnswer = isAnswer;
            }
        }
    }
}
