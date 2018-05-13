package com.example.xinyuxinyuan.contract.bean;

import java.util.List;

/**
 * Created by asd on 2018/5/10.
 */

public class HomePagerTieZiBean {

    /**
     * code : 0
     * message : 成功
     * data : {"artcircleList":{"pageNum":1,"pageSize":20,"size":1,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"coverImg":null,"photo":"http://qiniu.5roo.com/null","praiseNum":10,"title":"eqwe12e12e12e","userId":665,"content":"312412412","realname":null,"favoriteNum":1,"majorIds":"1","commentNum":0,"path":"http://qiniu.5roo.com/null","picProperty":null,"worksType":"","nickname":"123","isPraise":1,"userType":1,"id":241,"contentType":"经验分享","createDate":1525858114000,"isFavorite":0}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}}
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
         * artcircleList : {"pageNum":1,"pageSize":20,"size":1,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"coverImg":null,"photo":"http://qiniu.5roo.com/null","praiseNum":10,"title":"eqwe12e12e12e","userId":665,"content":"312412412","realname":null,"favoriteNum":1,"majorIds":"1","commentNum":0,"path":"http://qiniu.5roo.com/null","picProperty":null,"worksType":"","nickname":"123","isPraise":1,"userType":1,"id":241,"contentType":"经验分享","createDate":1525858114000,"isFavorite":0}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
         */

        private ArtcircleListBean artcircleList;

        public ArtcircleListBean getArtcircleList() {
            return artcircleList;
        }

        public void setArtcircleList(ArtcircleListBean artcircleList) {
            this.artcircleList = artcircleList;
        }

        public static class ArtcircleListBean {
            /**
             * pageNum : 1
             * pageSize : 20
             * size : 1
             * startRow : 1
             * endRow : 1
             * total : 1
             * pages : 1
             * list : [{"coverImg":null,"photo":"http://qiniu.5roo.com/null","praiseNum":10,"title":"eqwe12e12e12e","userId":665,"content":"312412412","realname":null,"favoriteNum":1,"majorIds":"1","commentNum":0,"path":"http://qiniu.5roo.com/null","picProperty":null,"worksType":"","nickname":"123","isPraise":1,"userType":1,"id":241,"contentType":"经验分享","createDate":1525858114000,"isFavorite":0}]
             * prePage : 0
             * nextPage : 0
             * isFirstPage : true
             * isLastPage : true
             * hasPreviousPage : false
             * hasNextPage : false
             * navigatePages : 8
             * navigatepageNums : [1]
             * navigateFirstPage : 1
             * navigateLastPage : 1
             * firstPage : 1
             * lastPage : 1
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
                 * coverImg : null
                 * photo : http://qiniu.5roo.com/null
                 * praiseNum : 10
                 * title : eqwe12e12e12e
                 * userId : 665
                 * content : 312412412
                 * realname : null
                 * favoriteNum : 1
                 * majorIds : 1
                 * commentNum : 0
                 * path : http://qiniu.5roo.com/null
                 * picProperty : null
                 * worksType :
                 * nickname : 123
                 * isPraise : 1
                 * userType : 1
                 * id : 241
                 * contentType : 经验分享
                 * createDate : 1525858114000
                 * isFavorite : 0
                 */

                private Object coverImg;
                private String photo;
                private int praiseNum;
                private String title;
                private int userId;
                private String content;
                private Object realname;
                private int favoriteNum;
                private String majorIds;
                private int commentNum;
                private String path;
                private Object picProperty;
                private String worksType;
                private String nickname;
                private int isPraise;
                private int userType;
                private int id;
                private String contentType;
                private long createDate;
                private int isFavorite;

                public Object getCoverImg() {
                    return coverImg;
                }

                public void setCoverImg(Object coverImg) {
                    this.coverImg = coverImg;
                }

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

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
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

                public int getFavoriteNum() {
                    return favoriteNum;
                }

                public void setFavoriteNum(int favoriteNum) {
                    this.favoriteNum = favoriteNum;
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

                public String getPath() {
                    return path;
                }

                public void setPath(String path) {
                    this.path = path;
                }

                public Object getPicProperty() {
                    return picProperty;
                }

                public void setPicProperty(Object picProperty) {
                    this.picProperty = picProperty;
                }

                public String getWorksType() {
                    return worksType;
                }

                public void setWorksType(String worksType) {
                    this.worksType = worksType;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
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

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getContentType() {
                    return contentType;
                }

                public void setContentType(String contentType) {
                    this.contentType = contentType;
                }

                public long getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(long createDate) {
                    this.createDate = createDate;
                }

                public int getIsFavorite() {
                    return isFavorite;
                }

                public void setIsFavorite(int isFavorite) {
                    this.isFavorite = isFavorite;
                }
            }
        }
    }
}
