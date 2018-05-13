package com.example.xinyuxinyuan.contract.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 键盘上的手艺人 on 2018/5/8.
 */

public class ZhaoLaoShiBean {


    @SerializedName("code")
    private int _$Code20; // FIXME check this code
    private String message;
    private DataBean data;

    public int get_$Code20() {
        return _$Code20;
    }

    public void set_$Code20(int _$Code20) {
        this._$Code20 = _$Code20;
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
        @SerializedName("pageNum")
        private int _$PageNum206; // FIXME check this code
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

        public int get_$PageNum206() {
            return _$PageNum206;
        }

        public void set_$PageNum206(int _$PageNum206) {
            this._$PageNum206 = _$PageNum206;
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
            @SerializedName("id")
            private int _$Id231; // FIXME check this code
            private int page;
            private int rows;
            private int pid;
            private Object salt;
            private String nickname;
            private String realname;
            private String photo;
            private String images;
            private String intro;
            private String details;
            private String mobile;
            private Object psw;
            private String email;
            private int sex;
            private Object birthday;
            private String country;
            private Object province;
            private String city;
            private Object area;
            private Object address;
            private int userType;
            private Object post;
            private String college;
            private String major;
            private String skilled;
            private Object ip;
            private Object lastTime;
            private long createDate;
            private Object idcardFront;
            private Object idcardBack;
            private Object teachCard;
            private int isauth;
            private Object identityAuthTime;
            private int pushHome;
            private long sortTime;
            private Object openid;
            private Object unionid;
            private Object qqUid;
            private Object sinaUid;
            private int status;
            private int topTime;
            private String videoPath;
            private int beanAmount;
            private Object openidMini;
            private Object openidWx;
            private Object flag;
            private int weight;

            public int get_$Id231() {
                return _$Id231;
            }

            public void set_$Id231(int _$Id231) {
                this._$Id231 = _$Id231;
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

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public Object getSalt() {
                return salt;
            }

            public void setSalt(Object salt) {
                this.salt = salt;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getRealname() {
                return realname;
            }

            public void setRealname(String realname) {
                this.realname = realname;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getDetails() {
                return details;
            }

            public void setDetails(String details) {
                this.details = details;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public Object getPsw() {
                return psw;
            }

            public void setPsw(Object psw) {
                this.psw = psw;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public Object getBirthday() {
                return birthday;
            }

            public void setBirthday(Object birthday) {
                this.birthday = birthday;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public Object getProvince() {
                return province;
            }

            public void setProvince(Object province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public Object getArea() {
                return area;
            }

            public void setArea(Object area) {
                this.area = area;
            }

            public Object getAddress() {
                return address;
            }

            public void setAddress(Object address) {
                this.address = address;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public Object getPost() {
                return post;
            }

            public void setPost(Object post) {
                this.post = post;
            }

            public String getCollege() {
                return college;
            }

            public void setCollege(String college) {
                this.college = college;
            }

            public String getMajor() {
                return major;
            }

            public void setMajor(String major) {
                this.major = major;
            }

            public String getSkilled() {
                return skilled;
            }

            public void setSkilled(String skilled) {
                this.skilled = skilled;
            }

            public Object getIp() {
                return ip;
            }

            public void setIp(Object ip) {
                this.ip = ip;
            }

            public Object getLastTime() {
                return lastTime;
            }

            public void setLastTime(Object lastTime) {
                this.lastTime = lastTime;
            }

            public long getCreateDate() {
                return createDate;
            }

            public void setCreateDate(long createDate) {
                this.createDate = createDate;
            }

            public Object getIdcardFront() {
                return idcardFront;
            }

            public void setIdcardFront(Object idcardFront) {
                this.idcardFront = idcardFront;
            }

            public Object getIdcardBack() {
                return idcardBack;
            }

            public void setIdcardBack(Object idcardBack) {
                this.idcardBack = idcardBack;
            }

            public Object getTeachCard() {
                return teachCard;
            }

            public void setTeachCard(Object teachCard) {
                this.teachCard = teachCard;
            }

            public int getIsauth() {
                return isauth;
            }

            public void setIsauth(int isauth) {
                this.isauth = isauth;
            }

            public Object getIdentityAuthTime() {
                return identityAuthTime;
            }

            public void setIdentityAuthTime(Object identityAuthTime) {
                this.identityAuthTime = identityAuthTime;
            }

            public int getPushHome() {
                return pushHome;
            }

            public void setPushHome(int pushHome) {
                this.pushHome = pushHome;
            }

            public long getSortTime() {
                return sortTime;
            }

            public void setSortTime(long sortTime) {
                this.sortTime = sortTime;
            }

            public Object getOpenid() {
                return openid;
            }

            public void setOpenid(Object openid) {
                this.openid = openid;
            }

            public Object getUnionid() {
                return unionid;
            }

            public void setUnionid(Object unionid) {
                this.unionid = unionid;
            }

            public Object getQqUid() {
                return qqUid;
            }

            public void setQqUid(Object qqUid) {
                this.qqUid = qqUid;
            }

            public Object getSinaUid() {
                return sinaUid;
            }

            public void setSinaUid(Object sinaUid) {
                this.sinaUid = sinaUid;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getTopTime() {
                return topTime;
            }

            public void setTopTime(int topTime) {
                this.topTime = topTime;
            }

            public String getVideoPath() {
                return videoPath;
            }

            public void setVideoPath(String videoPath) {
                this.videoPath = videoPath;
            }

            public int getBeanAmount() {
                return beanAmount;
            }

            public void setBeanAmount(int beanAmount) {
                this.beanAmount = beanAmount;
            }

            public Object getOpenidMini() {
                return openidMini;
            }

            public void setOpenidMini(Object openidMini) {
                this.openidMini = openidMini;
            }

            public Object getOpenidWx() {
                return openidWx;
            }

            public void setOpenidWx(Object openidWx) {
                this.openidWx = openidWx;
            }

            public Object getFlag() {
                return flag;
            }

            public void setFlag(Object flag) {
                this.flag = flag;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }
        }
    }
}
