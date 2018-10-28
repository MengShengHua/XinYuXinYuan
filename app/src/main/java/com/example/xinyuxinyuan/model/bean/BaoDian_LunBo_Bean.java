package com.example.xinyuxinyuan.model.bean;

import java.util.List;

/**
 * Created by 键盘上的手艺人 on 2018/5/7.
 */

public class BaoDian_LunBo_Bean {

    /**
     * code : 0
     * message : 成功
     * data : {"pageNum":1,"pageSize":2,"size":2,"startRow":0,"endRow":1,"total":2,"pages":1,"list":[{"id":53,"page":1,"rows":20,"title":"","type":"2","urlType":"0","pcImgUrl":"","pcUrl":null,"mobileImgUrl":"http://qiniu.5roo.com/d780bd15-c4d2-416b-bf06-6cc7e8c57779.png","mobileUrl":null,"sortNo":null,"status":0},{"id":55,"page":1,"rows":20,"title":"","type":"2","urlType":"0","pcImgUrl":"","pcUrl":null,"mobileImgUrl":"http://qiniu.5roo.com/dae524ea-5fc9-44cc-9450-0f9c0af626f2.png","mobileUrl":null,"sortNo":null,"status":0}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
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
         * pageNum : 1
         * pageSize : 2
         * size : 2
         * startRow : 0
         * endRow : 1
         * total : 2
         * pages : 1
         * list : [{"id":53,"page":1,"rows":20,"title":"","type":"2","urlType":"0","pcImgUrl":"","pcUrl":null,"mobileImgUrl":"http://qiniu.5roo.com/d780bd15-c4d2-416b-bf06-6cc7e8c57779.png","mobileUrl":null,"sortNo":null,"status":0},{"id":55,"page":1,"rows":20,"title":"","type":"2","urlType":"0","pcImgUrl":"","pcUrl":null,"mobileImgUrl":"http://qiniu.5roo.com/dae524ea-5fc9-44cc-9450-0f9c0af626f2.png","mobileUrl":null,"sortNo":null,"status":0}]
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
             * id : 53
             * page : 1
             * rows : 20
             * title :
             * type : 2
             * urlType : 0
             * pcImgUrl :
             * pcUrl : null
             * mobileImgUrl : http://qiniu.5roo.com/d780bd15-c4d2-416b-bf06-6cc7e8c57779.png
             * mobileUrl : null
             * sortNo : null
             * status : 0
             */

            private int id;
            private int page;
            private int rows;
            private String title;
            private String type;
            private String urlType;
            private String pcImgUrl;
            private Object pcUrl;
            private String mobileImgUrl;
            private Object mobileUrl;
            private Object sortNo;
            private int status;

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

            public String getUrlType() {
                return urlType;
            }

            public void setUrlType(String urlType) {
                this.urlType = urlType;
            }

            public String getPcImgUrl() {
                return pcImgUrl;
            }

            public void setPcImgUrl(String pcImgUrl) {
                this.pcImgUrl = pcImgUrl;
            }

            public Object getPcUrl() {
                return pcUrl;
            }

            public void setPcUrl(Object pcUrl) {
                this.pcUrl = pcUrl;
            }

            public String getMobileImgUrl() {
                return mobileImgUrl;
            }

            public void setMobileImgUrl(String mobileImgUrl) {
                this.mobileImgUrl = mobileImgUrl;
            }

            public Object getMobileUrl() {
                return mobileUrl;
            }

            public void setMobileUrl(Object mobileUrl) {
                this.mobileUrl = mobileUrl;
            }

            public Object getSortNo() {
                return sortNo;
            }

            public void setSortNo(Object sortNo) {
                this.sortNo = sortNo;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
