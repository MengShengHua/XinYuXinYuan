package com.example.xinyuxinyuan.contract.bean;

import java.util.List;

/**
 * Created by 键盘上的手艺人 on 2018/5/7.
 */

public class YuGaoBean {

    /**
     * code : 0
     * message : 成功
     * data : {"pageNum":1,"pageSize":20,"size":2,"startRow":1,"endRow":2,"total":2,"pages":1,"list":[{"majorIds":"6","address":"北京市朝阳区亚运村曹八里1号院6号楼-星语心愿艺教","coverImg":"http://qiniu.5roo.com/0e9fca4e-def4-493d-85a5-8b391e8b25b7.jpg","endDate":1523692800000,"subscribeNum":20,"price":128,"collegeIds":"5","reservationNum":16,"id":66,"title":"艺术沙龙：把你的小梦想，带到更大的艺术世界","startDate":1523685600000},{"majorIds":"1","address":"北京市朝阳区曹八里1号院6号楼","coverImg":"http://qiniu.5roo.com/40a30523-0b69-4073-a453-38cf02349a68.jpg","endDate":1521966600000,"subscribeNum":20,"price":1730,"collegeIds":"14","reservationNum":45,"id":61,"title":"4天，32课时，轻松拿音基教师资格证","startDate":1521855000000}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
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
         * pageSize : 20
         * size : 2
         * startRow : 1
         * endRow : 2
         * total : 2
         * pages : 1
         * list : [{"majorIds":"6","address":"北京市朝阳区亚运村曹八里1号院6号楼-星语心愿艺教","coverImg":"http://qiniu.5roo.com/0e9fca4e-def4-493d-85a5-8b391e8b25b7.jpg","endDate":1523692800000,"subscribeNum":20,"price":128,"collegeIds":"5","reservationNum":16,"id":66,"title":"艺术沙龙：把你的小梦想，带到更大的艺术世界","startDate":1523685600000},{"majorIds":"1","address":"北京市朝阳区曹八里1号院6号楼","coverImg":"http://qiniu.5roo.com/40a30523-0b69-4073-a453-38cf02349a68.jpg","endDate":1521966600000,"subscribeNum":20,"price":1730,"collegeIds":"14","reservationNum":45,"id":61,"title":"4天，32课时，轻松拿音基教师资格证","startDate":1521855000000}]
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
             * majorIds : 6
             * address : 北京市朝阳区亚运村曹八里1号院6号楼-星语心愿艺教
             * coverImg : http://qiniu.5roo.com/0e9fca4e-def4-493d-85a5-8b391e8b25b7.jpg
             * endDate : 1523692800000
             * subscribeNum : 20
             * price : 128
             * collegeIds : 5
             * reservationNum : 16
             * id : 66
             * title : 艺术沙龙：把你的小梦想，带到更大的艺术世界
             * startDate : 1523685600000
             */

            private String majorIds;
            private String address;
            private String coverImg;
            private long endDate;
            private int subscribeNum;
            private int price;
            private String collegeIds;
            private int reservationNum;
            private int id;
            private String title;
            private long startDate;

            public String getMajorIds() {
                return majorIds;
            }

            public void setMajorIds(String majorIds) {
                this.majorIds = majorIds;
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

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public long getStartDate() {
                return startDate;
            }

            public void setStartDate(long startDate) {
                this.startDate = startDate;
            }
        }
    }
}
