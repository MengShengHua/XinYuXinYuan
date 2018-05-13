package com.example.xinyuxinyuan.contract.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 键盘上的手艺人 on 2018/5/8.
 */

public class XiangQingBean {

    @SerializedName("code")
    private int _$Code310; // FIXME check this code
    private String message;
    private DataBean data;

    public int get_$Code310() {
        return _$Code310;
    }

    public void set_$Code310(int _$Code310) {
        this._$Code310 = _$Code310;
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
        @SerializedName("isAttention")
        private int _$IsAttention175; // FIXME check this code
        private int liveCount;
        private int postsCount;
        private double price;
        private int coachingCount;
        private int attentionCount;
        private int fansCount;
        private int homewokPublishCount;
        private UserBean user;
        private PraiseBean praise;
        private List<?> courses;
        private List<?> liveCourses;

        public int get_$IsAttention175() {
            return _$IsAttention175;
        }

        public void set_$IsAttention175(int _$IsAttention175) {
            this._$IsAttention175 = _$IsAttention175;
        }

        public int getLiveCount() {
            return liveCount;
        }

        public void setLiveCount(int liveCount) {
            this.liveCount = liveCount;
        }

        public int getPostsCount() {
            return postsCount;
        }

        public void setPostsCount(int postsCount) {
            this.postsCount = postsCount;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getCoachingCount() {
            return coachingCount;
        }

        public void setCoachingCount(int coachingCount) {
            this.coachingCount = coachingCount;
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

        public int getHomewokPublishCount() {
            return homewokPublishCount;
        }

        public void setHomewokPublishCount(int homewokPublishCount) {
            this.homewokPublishCount = homewokPublishCount;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public PraiseBean getPraise() {
            return praise;
        }

        public void setPraise(PraiseBean praise) {
            this.praise = praise;
        }

        public List<?> getCourses() {
            return courses;
        }

        public void setCourses(List<?> courses) {
            this.courses = courses;
        }

        public List<?> getLiveCourses() {
            return liveCourses;
        }

        public void setLiveCourses(List<?> liveCourses) {
            this.liveCourses = liveCourses;
        }

        public static class UserBean {
            @SerializedName("id")
            private int _$Id327; // FIXME check this code
            private int page;
            private int rows;
            private int pid;
            private String salt;
            private String nickname;
            private String realname;
            private String photo;
            private String images;
            private String intro;
            private String details;
            private String mobile;
            private String psw;
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
            private long lastTime;
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

            public int get_$Id327() {
                return _$Id327;
            }

            public void set_$Id327(int _$Id327) {
                this._$Id327 = _$Id327;
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

            public String getSalt() {
                return salt;
            }

            public void setSalt(String salt) {
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

            public String getPsw() {
                return psw;
            }

            public void setPsw(String psw) {
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

            public long getLastTime() {
                return lastTime;
            }

            public void setLastTime(long lastTime) {
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

        public static class PraiseBean {
            /**
             * praiseCount : 30
             * isPraise : 0
             */

            private int praiseCount;
            private int isPraise;

            public int getPraiseCount() {
                return praiseCount;
            }

            public void setPraiseCount(int praiseCount) {
                this.praiseCount = praiseCount;
            }

            public int getIsPraise() {
                return isPraise;
            }

            public void setIsPraise(int isPraise) {
                this.isPraise = isPraise;
            }
        }
    }
}
