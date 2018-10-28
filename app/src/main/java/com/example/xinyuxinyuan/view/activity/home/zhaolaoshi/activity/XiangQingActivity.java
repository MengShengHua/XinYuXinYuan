package com.example.xinyuxinyuan.view.activity.home.zhaolaoshi.activity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.model.bean.DianZanBean;
import com.example.xinyuxinyuan.model.bean.GuanZhuBean;
import com.example.xinyuxinyuan.model.bean.QuXiaoDianZanBean;
import com.example.xinyuxinyuan.model.bean.XiangQingBean;
import com.example.xinyuxinyuan.contract.home.DianZan;
import com.example.xinyuxinyuan.contract.home.GuanZhu;
import com.example.xinyuxinyuan.contract.home.QuXiaoDianZan;
import com.example.xinyuxinyuan.contract.home.XiangQing;
import com.example.xinyuxinyuan.presenter.dianzan.DianZanPresenter;
import com.example.xinyuxinyuan.presenter.dianzan.GuanZhuPresenter;
import com.example.xinyuxinyuan.presenter.dianzan.QuXiaoDianZanPresenter;
import com.example.xinyuxinyuan.presenter.home.XiangQingPresenter;
import com.example.xinyuxinyuan.utils.ShareUtils;
import com.example.xinyuxinyuan.utils.zidingyi.GlideCircleTransform;
import com.example.xinyuxinyuan.view.activity.login.LoginActivity;
import com.example.xinyuxinyuan.view.activity.wode.FollowAndFansActivity;
import com.example.xinyuxinyuan.view.activity.wode.PersonalActivity;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

public class XiangQingActivity extends BaseActivity implements XiangQing.View, View.OnClickListener, DianZan.View, CompoundButton.OnCheckedChangeListener, QuXiaoDianZan.View, GuanZhu.View{

    private int teacherId;
    private XiangQingPresenter xiangQingPresenter;

    private RelativeLayout xiangqing_fudao_group;
    private ImageView xiangqing_image_datu;
    private TextView xiangqing_text_huibai;
    private CheckBox xiangqing_chectBox_dianzan;
    private ImageView xiangqing_image_touxiang;
    private TextView xiangqing_text_name;
    private ImageView xiangqing_image_vip;
    private TextView xiangqing_text_daren;
    private TextView xiangqing_text_guanzhu;
    private LinearLayout kecheng_lineaLayout;
    private LinearLayout zuoye_lineaLayout;
    private LinearLayout fudao_lineaLayout;
    private LinearLayout tiezi_lineaLayout;
    private LinearLayout guanzhu_lineaLayout;
    private LinearLayout fensi_lineaLayout;
    private TextView xiangqing_text_xia;
    private TextView masterdetail_teacherdetail_tv;

    private ImageView xiangqing_image_finish;
    private ImageView xiangqing_image_fenxiang;
    private boolean Tag = false;
    private TextView xiangqing_text_dianzan;
    private TextView fensi_lineaLayout_text;
    private TextView guanzhu_lineaLayout_text;
    private TextView tiezi_lineaLayout_text;
    private TextView fudao_lineaLayout_text;
    private TextView zuoye_lineaLayout_text;
    private TextView kecheng_lineaLayout_text;
    private DianZanPresenter dianZanPresenter;
    private int id;
    private int zanCount;
    private boolean DianTag = false;
    private int isPraise;
    private QuXiaoDianZanPresenter quXiaoDianZanPresenter;
    private GuanZhuPresenter guanZhuPresenter;
    private int fenshi;
    private String country;
    private String images;
    private String college;
    private String photo;
    private String nickname;
    private int id1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_xiang_qing;
    }

    @Override
    protected void init() {
        //实例化点赞P层
        dianZanPresenter = new DianZanPresenter(this);

        //实例化取消点赞P层
        quXiaoDianZanPresenter = new QuXiaoDianZanPresenter(this);

        //实例化关注P层
        guanZhuPresenter = new GuanZhuPresenter(this);
        xiangqing_fudao_group = findViewById(R.id.xiangqing_fudao_group);
        xiangqing_image_datu = findViewById(R.id.xiangqing_image_datu);
        xiangqing_text_huibai = findViewById(R.id.xiangqing_text_huibai);
        xiangqing_chectBox_dianzan = findViewById(R.id.xiangqing_chectBox_dianzan);
        xiangqing_image_touxiang = findViewById(R.id.xiangqing_image_touxiang);
        xiangqing_text_name = findViewById(R.id.xiangqing_text_name);
        xiangqing_image_vip = findViewById(R.id.xiangqing_image_vip);
        xiangqing_text_daren = findViewById(R.id.xiangqing_text_daren);
        xiangqing_text_guanzhu = findViewById(R.id.xiangqing_text_guanzhu);
        kecheng_lineaLayout = findViewById(R.id.kecheng_lineaLayout);
        kecheng_lineaLayout_text = findViewById(R.id.kecheng_lineaLayout_text);
        zuoye_lineaLayout = findViewById(R.id.zuoye_lineaLayout);
        zuoye_lineaLayout_text = findViewById(R.id.zuoye_lineaLayout_text);
        fudao_lineaLayout = findViewById(R.id.fudao_lineaLayout);
        fudao_lineaLayout_text = findViewById(R.id.fudao_lineaLayout_text);
        tiezi_lineaLayout = findViewById(R.id.tiezi_lineaLayout);
        tiezi_lineaLayout_text = findViewById(R.id.tiezi_lineaLayout_text);
        guanzhu_lineaLayout = findViewById(R.id.guanzhu_lineaLayout);
        guanzhu_lineaLayout_text = findViewById(R.id.guanzhu_lineaLayout_text);
        fensi_lineaLayout = findViewById(R.id.fensi_lineaLayout);
        fensi_lineaLayout_text = findViewById(R.id.fensi_lineaLayout_text);
        xiangqing_text_xia = findViewById(R.id.xiangqing_text_xia);
        masterdetail_teacherdetail_tv = findViewById(R.id.masterdetail_teacherdetail_tv);
        xiangqing_image_finish = findViewById(R.id.xiangqing_image_finish);
        xiangqing_image_fenxiang = findViewById(R.id.xiangqing_image_fenxiang);

        Intent intent = getIntent();
        teacherId = intent.getIntExtra("teacherId", 0);
        //实例化P层
        xiangQingPresenter = new XiangQingPresenter(this);
        xiangqing_fudao_group.setOnClickListener(this);
        xiangqing_text_guanzhu.setOnClickListener(this);
        kecheng_lineaLayout.setOnClickListener(this);
        zuoye_lineaLayout.setOnClickListener(this);
        fudao_lineaLayout.setOnClickListener(this);
        tiezi_lineaLayout.setOnClickListener(this);
        guanzhu_lineaLayout.setOnClickListener(this);
        fensi_lineaLayout.setOnClickListener(this);
        xiangqing_image_finish.setOnClickListener(this);
        xiangqing_image_fenxiang.setOnClickListener(this);
        xiangqing_chectBox_dianzan.setOnClickListener(this);
        xiangqing_image_touxiang.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        xiangQingPresenter.loadXiangQingData(teacherId, ShareUtils.getLoginUserId());
        Log.e("发给甲方根据法国恢复规划法规和方法更好", "" + ShareUtils.getLoginUserId());
    }

    @Override
    public void showXiangQingData(XiangQingBean xiangQingBean) {
        id1 = xiangQingBean.getData().getUser().get_$Id327();
        college = xiangQingBean.getData().getUser().getCollege();
        photo = xiangQingBean.getData().getUser().getPhoto();
        images = xiangQingBean.getData().getUser().getImages();
        nickname = xiangQingBean.getData().getUser().getNickname();
        zanCount = xiangQingBean.getData().getPraise().getPraiseCount();
        isPraise = xiangQingBean.getData().getPraise().getIsPraise();
        id1 = xiangQingBean.getData().getUser().get_$Id327();
        if (isPraise == 1) {
            xiangqing_chectBox_dianzan.setChecked(true);
        } else {
            xiangqing_chectBox_dianzan.setChecked(false);
        }


        if (xiangQingBean.getData().get_$IsAttention175() == 0) {
            Tag = false;
            xiangqing_text_guanzhu.setText("关注");
            xiangqing_text_guanzhu.setBackgroundColor(Color.parseColor("#142fdf"));
        } else if (xiangQingBean.getData().get_$IsAttention175() == 1) {
            Tag = true;
            xiangqing_text_guanzhu.setText("已关注");
            xiangqing_text_guanzhu.setBackgroundColor(Color.parseColor("#f9f9f9"));
        } else {
            xiangqing_text_guanzhu.setText("互相关注");
            xiangqing_text_guanzhu.setBackgroundColor(Color.parseColor("#f9f9f9"));
        }

        fenshi = xiangQingBean.getData().getFansCount();
        fensi_lineaLayout_text.setText("" + fenshi);

        xiangqing_chectBox_dianzan.setText("" + zanCount);

        country = xiangQingBean.getData().getUser().getCountry();
        xiangqing_text_huibai.setText(xiangQingBean.getData().getUser().getSkilled());
        xiangqing_text_name.setText(xiangQingBean.getData().getUser().getNickname());
        xiangqing_text_daren.setText(xiangQingBean.getData().getUser().getIntro());
        kecheng_lineaLayout_text.setText("" + xiangQingBean.getData().getUser().getMajor());
        zuoye_lineaLayout_text.setText("" + xiangQingBean.getData().getUser().getPid());
        tiezi_lineaLayout_text.setText("" + xiangQingBean.getData().getUser().getBeanAmount());
        guanzhu_lineaLayout_text.setText("" + xiangQingBean.getData().getUser().getStatus());
        fudao_lineaLayout_text.setText("" + xiangQingBean.getData().getUser().getIsauth());

        Glide.with(this).load(xiangQingBean.getData().getUser().getImages()).into(xiangqing_image_datu);
        Glide.with(this).load(xiangQingBean.getData().getUser().getImages()).transform(new GlideCircleTransform(this)).into(xiangqing_image_touxiang);
        xiangqing_text_xia.setText(xiangQingBean.getData().getUser().getDetails());
        if (xiangQingBean.getData().getUser().getUserType() == 4) {
            xiangqing_image_vip.setImageResource(R.mipmap.home_level_vip_red);
        } else if (xiangQingBean.getData().getUser().getUserType() == 3) {
            xiangqing_image_vip.setImageResource(R.mipmap.home_level_vip_yellow);
        } else {
            xiangqing_image_vip.setImageResource(R.mipmap.home_level_vip_blue);
        }
        xiangqing_chectBox_dianzan.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xiangqing_fudao_group:
                Toast.makeText(this, "请不动", Toast.LENGTH_SHORT).show();
                break;
            case R.id.xiangqing_text_guanzhu:
                isLogin();
                if (Tag) {
                    //发起关注取消请求
                    guanZhuPresenter.loadQuXiaoGuanZhu(id1, ShareUtils.getLoginUserId());

                } else {
                    //发起关注的请求
                    guanZhuPresenter.loadGuanZhu(id1, ShareUtils.getLoginUserId());
                }
                break;
            case R.id.kecheng_lineaLayout:

                break;
            case R.id.zuoye_lineaLayout:

                break;
            case R.id.fudao_lineaLayout:

                break;
            case R.id.tiezi_lineaLayout:

                break;
            case R.id.guanzhu_lineaLayout:
                Intent intent1 = new Intent(this, FollowAndFansActivity.class);
                intent1.putExtra("FollowAndFans","关注");

                startActivity(intent1);
                break;
            case R.id.fensi_lineaLayout:
                Intent intent = new Intent(this, FollowAndFansActivity.class);
                intent.putExtra("FollowAndFans","粉丝");
                intent.putExtra("id",id1);
                startActivity(intent);
                break;
            case R.id.xiangqing_image_finish:
                finish();
                break;
            case R.id.xiangqing_image_fenxiang:

                UMWeb web = new UMWeb(photo);
                web.setTitle(nickname);//标题
                UMImage umImage = new UMImage(XiangQingActivity.this,images);
                web.setThumb(umImage);
                web.setDescription("滴滴案件结案了");//描述
                new ShareAction(XiangQingActivity.this)
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(shareListener)
                        .withMedia(web)
                        .open();

                break;
            case R.id.xiangqing_chectBox_dianzan:
                isLogin();
                if (xiangqing_chectBox_dianzan.isChecked()) {
                    dianZanPresenter.loadDianZanData(id, teacherId, ShareUtils.getLoginUserId(), "老师");
                } else {
                    quXiaoDianZanPresenter.loadQuXiaoDianZan(id, teacherId, ShareUtils.getLoginUserId(), "老师");
                }
                break;
            case R.id.xiangqing_image_touxiang:
                Intent intent2 = new Intent(this, PersonalActivity.class);
                intent2.putExtra("UserId",id1);
                intent2.putExtra("photo",photo);
                startActivity(intent2);
                break;
        }
    }

    @Override
    public void showDianZanData(DianZanBean dianZanBean) {
        xiangqing_chectBox_dianzan.setText("" + (Integer.parseInt(xiangqing_chectBox_dianzan.getText().toString()) + 1));
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

    private void isLogin() {
        if (ShareUtils.getLoginUserId() == 0) {
            Toast.makeText(this, "请您先去登录", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(XiangQingActivity.this, LoginActivity.class);
            startActivity(intent);
            return;
        }
    }


    @Override
    public void showQuXiaoDianZanData(QuXiaoDianZanBean quXiaoDianZan) {
        xiangqing_chectBox_dianzan.setText("" + (Integer.parseInt(xiangqing_chectBox_dianzan.getText().toString()) - 1));
    }

    @Override
    public void showGuanZhu(GuanZhuBean guanZhuBean) {
        Tag = true;
        xiangqing_text_guanzhu.setText("已关注");
        fenshi = fenshi + 1;
        fensi_lineaLayout_text.setText("" + fenshi);
        xiangqing_text_guanzhu.setBackgroundColor(Color.parseColor("#f9f9f9"));
    }

    @Override
    public void showQuXiaoGuanZhu(GuanZhuBean guanZhuBean) {
        Tag = false;
        xiangqing_text_guanzhu.setText("关注");
        fenshi = fenshi - 1;
        fensi_lineaLayout_text.setText("" + fenshi);
        xiangqing_text_guanzhu.setBackgroundColor(Color.parseColor("#142fdf"));
    }


    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(XiangQingActivity.this,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(XiangQingActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(XiangQingActivity.this,"取消了",Toast.LENGTH_LONG).show();

        }
    };
}
