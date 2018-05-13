package com.example.xinyuxinyuan.view.activity.home.xianshangke.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.contract.bean.GuanZhuBean;
import com.example.xinyuxinyuan.contract.bean.ShouChangBean;
import com.example.xinyuxinyuan.contract.bean.XiangQingMaiBean;
import com.example.xinyuxinyuan.contract.bean.YuGaoXiangQingBean;
import com.example.xinyuxinyuan.contract.home.GuanZhu;
import com.example.xinyuxinyuan.contract.home.ShouChang;
import com.example.xinyuxinyuan.contract.home.XiangQingMai;
import com.example.xinyuxinyuan.contract.home.YuGaoXiangQing;
import com.example.xinyuxinyuan.presenter.dianzan.GuanZhuPresenter;
import com.example.xinyuxinyuan.presenter.dianzan.ShouChangPresenter;
import com.example.xinyuxinyuan.presenter.home.XiangQingMaiPresenter;
import com.example.xinyuxinyuan.presenter.home.YuGaoXiangQingPresenter;
import com.example.xinyuxinyuan.utils.DataUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;
import com.example.xinyuxinyuan.utils.UrlData;
import com.example.xinyuxinyuan.utils.zidingyi.GlideCircleTransform;
import com.example.xinyuxinyuan.view.activity.home.zhaolaoshi.activity.XiangQingActivity;
import com.example.xinyuxinyuan.view.activity.login.LoginActivity;

public class XiangQing_Mai_Activity extends BaseActivity implements XiangQingMai.View, View.OnClickListener, GuanZhu.View, ShouChang.View, YuGaoXiangQing.View {

    private boolean ShouChangTag = false;
    private CheckBox activity_xiang_qing_mai_shoucang_checkBox;
    private LinearLayout activity_xiang_qing_mai_shoucang_checkBoxGroup;
    private TextView activity_xiang_qing_mai_shoucang_goumai;
    private LinearLayout activity_xiang_qing_mai_shoucang_goumaiGroup;
    private ImageView activity_xiang_qing_mai_image;
    private TextView activity_xiang_qing_mai_chongbo;
    private TextView activity_xiang_qing_mai_timeQian;
    private TextView activity_xiang_qing_mai_time;
    private TextView activity_xiang_qing_mai_biaoyan;
    private TextView activity_xiang_qing_mai_yuyueCount;
    private TextView activity_xiang_qing_mai_price;
    private ImageView activity_xiang_qing_mai_photo;
    private TextView activity_xiang_qing_mai_name;
    private ImageView activity_xiang_qing_mai_vip;
    private TextView activity_xiang_qing_mai_type;
    private TextView activity_xiang_qing_mai_guanzhu;
    private WebView activity_xiang_qing_mai_wenView;
    private ImageView activity_xiang_qing_mai_finishImage;
    private ImageView activity_xiang_qing_mai_fenxiangImage;
    private int id;
    private int Tag = 0;
    private XiangQingMaiPresenter xiangQingMaiPresenter;

    private GuanZhuPresenter guanZhuPresenter;
    private FrameLayout masterlivedetail_frame;
    private ShouChangPresenter shouChangPresenter;
    private LinearLayout activity_xiang_qing_mai_zixun_group;
    private TextView activity_xiang_qing_mai_zixun_text;
    private LinearLayout activity_xiang_qing_mai_teacher_group;
    private int type;
    private YuGaoXiangQingPresenter yuGaoXiangQingPresenter;
    private String numBer;
    private int attentionId;
    private int attentionId1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_xiang_qing__mai_;
    }

    @Override
    protected void init() {

        Intent intent = getIntent();

        id = intent.getIntExtra("id", 0);


        //实例化关注的P层
        guanZhuPresenter = new GuanZhuPresenter(this);

        yuGaoXiangQingPresenter = new YuGaoXiangQingPresenter(this);
        masterlivedetail_frame = findViewById(R.id.masterlivedetail_frame);
        activity_xiang_qing_mai_shoucang_checkBox = findViewById(R.id.activity_xiang_qing_mai_shoucang_checkBox);
        activity_xiang_qing_mai_shoucang_checkBoxGroup = findViewById(R.id.activity_xiang_qing_mai_shoucang_checkBoxGroup);
        activity_xiang_qing_mai_shoucang_goumai = findViewById(R.id.activity_xiang_qing_mai_shoucang_goumai);
        activity_xiang_qing_mai_shoucang_goumaiGroup = findViewById(R.id.activity_xiang_qing_mai_shoucang_goumaiGroup);
        activity_xiang_qing_mai_image = findViewById(R.id.activity_xiang_qing_mai_image);
        activity_xiang_qing_mai_chongbo = findViewById(R.id.activity_xiang_qing_mai_chongbo);
        activity_xiang_qing_mai_timeQian = findViewById(R.id.activity_xiang_qing_mai_timeQian);
        activity_xiang_qing_mai_time = findViewById(R.id.activity_xiang_qing_mai_time);
        activity_xiang_qing_mai_biaoyan = findViewById(R.id.activity_xiang_qing_mai_biaoyan);
        activity_xiang_qing_mai_yuyueCount = findViewById(R.id.activity_xiang_qing_mai_yuyueCount);
        activity_xiang_qing_mai_price = findViewById(R.id.activity_xiang_qing_mai_price);
        activity_xiang_qing_mai_photo = findViewById(R.id.activity_xiang_qing_mai_photo);
        activity_xiang_qing_mai_name = findViewById(R.id.activity_xiang_qing_mai_name);
        activity_xiang_qing_mai_vip = findViewById(R.id.activity_xiang_qing_mai_vip);
        activity_xiang_qing_mai_type = findViewById(R.id.activity_xiang_qing_mai_type);
        activity_xiang_qing_mai_guanzhu = findViewById(R.id.activity_xiang_qing_mai_guanzhu);
        activity_xiang_qing_mai_wenView = findViewById(R.id.activity_xiang_qing_mai_wenView);
        activity_xiang_qing_mai_finishImage = findViewById(R.id.activity_xiang_qing_mai_finishImage);
        activity_xiang_qing_mai_fenxiangImage = findViewById(R.id.activity_xiang_qing_mai_fenxiangImage);
        activity_xiang_qing_mai_fenxiangImage = findViewById(R.id.activity_xiang_qing_mai_fenxiangImage);
        activity_xiang_qing_mai_zixun_group = findViewById(R.id.activity_xiang_qing_mai_zixun_Group);
        activity_xiang_qing_mai_zixun_text = findViewById(R.id.activity_xiang_qing_mai_zixun_text);
        activity_xiang_qing_mai_teacher_group = findViewById(R.id.activity_xiang_qing_mai_teacher_group);
        type = intent.getIntExtra("type", 0);

        if (type == 5) {
            activity_xiang_qing_mai_zixun_group.setVisibility(View.VISIBLE);
            activity_xiang_qing_mai_zixun_text.setOnClickListener(this);
            activity_xiang_qing_mai_shoucang_goumai.setText("预约");
            activity_xiang_qing_mai_teacher_group.setVisibility(View.GONE);
        } else {
            activity_xiang_qing_mai_zixun_group.setVisibility(View.GONE);
            activity_xiang_qing_mai_teacher_group.setVisibility(View.VISIBLE);
        }

        /**
         * WebSettings的作用:对WebView进行配置和管理
         */
        WebSettings webSettings = activity_xiang_qing_mai_wenView.getSettings();


        /**
         * 如果访问的页面中要与javaScript进行交互,必须设置支持javaScript
         */
        webSettings.setJavaScriptEnabled(true);

        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

        //缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件

        //其他细节操作
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式

        activity_xiang_qing_mai_wenView.setWebChromeClient(new MyWebChromeClient());

        activity_xiang_qing_mai_wenView.loadUrl(String.format(UrlData.LIVE_WEBVIEW_URL, id));

        //实例化P层
        xiangQingMaiPresenter = new XiangQingMaiPresenter(this);

        //实例化收藏P层
        shouChangPresenter = new ShouChangPresenter(this);

        activity_xiang_qing_mai_finishImage.setOnClickListener(this);
        activity_xiang_qing_mai_fenxiangImage.setOnClickListener(this);
        activity_xiang_qing_mai_shoucang_goumaiGroup.setOnClickListener(this);
        activity_xiang_qing_mai_shoucang_checkBoxGroup.setOnClickListener(this);
        activity_xiang_qing_mai_shoucang_checkBox.setOnClickListener(this);
        activity_xiang_qing_mai_guanzhu.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        if (type == 5) {
            yuGaoXiangQingPresenter.loadYuGaoXiangQing(ShareUtils.getLoginUserId(), id);
        } else {
            xiangQingMaiPresenter.loadXiangQingMaiData(ShareUtils.getLoginUserId(), id);
        }
    }

    //拿到数据
    @Override
    public void showXiangQingMaiData(XiangQingMaiBean xiangQingMaiBean) {
        attentionId1 = xiangQingMaiBean.getData().getTeacherId();

        if (xiangQingMaiBean.getData().getIsFavorite() == 0) {
            activity_xiang_qing_mai_shoucang_checkBox.setChecked(false);
        } else if (xiangQingMaiBean.getData().getIsFavorite() == 1) {
            activity_xiang_qing_mai_shoucang_checkBox.setChecked(true);
        }
        Glide.with(this).load(xiangQingMaiBean.getData().getCoverImg()).into(activity_xiang_qing_mai_image);
        activity_xiang_qing_mai_chongbo.setText("重播");
        activity_xiang_qing_mai_timeQian.setText("讲堂课堂");
        activity_xiang_qing_mai_time.setText(DataUtils.getDateToString(xiangQingMaiBean.getData().getStartDate()));
        activity_xiang_qing_mai_biaoyan.setText("表演");
        activity_xiang_qing_mai_yuyueCount.setText(xiangQingMaiBean.getData().getSubscribe() + "/" + xiangQingMaiBean.getData().getSubscribeNum());
        activity_xiang_qing_mai_price.setText("" + xiangQingMaiBean.getData().getPrice());
        activity_xiang_qing_mai_name.setText(xiangQingMaiBean.getData().getNickname());
        activity_xiang_qing_mai_type.setText(xiangQingMaiBean.getData().getIntro());


        if (xiangQingMaiBean.getData().getAttention() == 0) {
            Tag = 0;
            activity_xiang_qing_mai_guanzhu.setText("关注");
            activity_xiang_qing_mai_guanzhu.setBackgroundColor(Color.parseColor("#142fdf"));
        } else if (xiangQingMaiBean.getData().getAttention() == 1) {
            Tag = 1;
            activity_xiang_qing_mai_guanzhu.setText("已关注");
            activity_xiang_qing_mai_guanzhu.setBackgroundColor(Color.parseColor("#f9f9f9"));
        }


        if (xiangQingMaiBean.getData().getUserType() == 3) {
            activity_xiang_qing_mai_vip.setImageResource(R.mipmap.home_level_vip_yellow);
        } else if (xiangQingMaiBean.getData().getUserType() == 4) {
            activity_xiang_qing_mai_vip.setImageResource(R.mipmap.home_level_vip_red);
        } else {
            activity_xiang_qing_mai_vip.setImageResource(R.mipmap.home_level_vip_blue);
        }
        Glide.with(this).load(xiangQingMaiBean.getData().getPhoto()).transform(new GlideCircleTransform(this)).into(activity_xiang_qing_mai_photo);
        activity_xiang_qing_mai_shoucang_goumai.setText("购买");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_xiang_qing_mai_finishImage:
                finish();
                break;
            case R.id.activity_xiang_qing_mai_fenxiangImage:
                Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_xiang_qing_mai_shoucang_checkBoxGroup:

                break;
            case R.id.activity_xiang_qing_mai_shoucang_goumaiGroup:
                Toast.makeText(this, "购买了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_xiang_qing_mai_guanzhu:
                isLogin();
                Tag++;
                if (Tag % 2 == 1) {
                    //发起关注取消请求
                    guanZhuPresenter.loadQuXiaoGuanZhu(attentionId1, ShareUtils.getLoginUserId());

                } else {
                    //发起关注的请求
                    guanZhuPresenter.loadGuanZhu(attentionId1, ShareUtils.getLoginUserId());

                }
                break;
            case R.id.activity_xiang_qing_mai_zixun_text:
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + numBer));//跳转到拨号界面，同时传递电话号码
                startActivity(dialIntent);
                break;
            case R.id.activity_xiang_qing_mai_shoucang_checkBox:
                isLogin();
                if (activity_xiang_qing_mai_shoucang_checkBox.isChecked()) {
                    if (type == 5) {
                        shouChangPresenter.loadShouChangData(id, ShareUtils.getLoginUserId(), "体验课");
                    } else {
                        //收藏的网络请求
                        shouChangPresenter.loadShouChangData(id, ShareUtils.getLoginUserId(), "直播课");
                    }
                } else {
                    if (type == 5) {
                        shouChangPresenter.loadQuXiaoShouChangData(id, ShareUtils.getLoginUserId(), "体验课");
                    } else {
                        //取消收藏的网络请求
                        shouChangPresenter.loadQuXiaoShouChangData(id, ShareUtils.getLoginUserId(), "直播课");
                    }
                }
                break;
        }
    }

    @Override
    public void showGuanZhu(GuanZhuBean guanZhuBean) {
        activity_xiang_qing_mai_guanzhu.setText("已关注");
        activity_xiang_qing_mai_guanzhu.setBackgroundColor(Color.parseColor("#f9f9f9"));
    }

    @Override
    public void showQuXiaoGuanZhu(GuanZhuBean guanZhuBean) {
        activity_xiang_qing_mai_guanzhu.setText("关注");
        activity_xiang_qing_mai_guanzhu.setBackgroundColor(Color.parseColor("#142fdf"));
    }


    @Override
    public void showShouChangData(ShouChangBean shouChangBean) {
        Toast.makeText(this, "已收藏", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showQuXiaoShouChangData(ShouChangBean shouChangBean) {
        Toast.makeText(this, "取消收藏", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void showYuGaoXiangQing(YuGaoXiangQingBean yuGaoXiangQingBean) {
        yuGaoXiangQingBean.getData().toString();
        numBer = yuGaoXiangQingBean.getData().getMobile();
        activity_xiang_qing_mai_wenView.loadUrl(String.format(UrlData.Notice_WebView_Url, id));
        if (yuGaoXiangQingBean.getData().getFavorite() == 0) {
            activity_xiang_qing_mai_shoucang_checkBox.setChecked(false);
        } else if (yuGaoXiangQingBean.getData().getFavorite() == 1) {
            activity_xiang_qing_mai_shoucang_checkBox.setChecked(true);
        }
        Glide.with(this).load(yuGaoXiangQingBean.getData().getCoverImg()).into(activity_xiang_qing_mai_image);
        activity_xiang_qing_mai_chongbo.setText("重播");
        activity_xiang_qing_mai_timeQian.setText("讲堂课堂");
        activity_xiang_qing_mai_time.setText(DataUtils.getDateToString(yuGaoXiangQingBean.getData().getStartDate()));
        activity_xiang_qing_mai_biaoyan.setText("表演");
        activity_xiang_qing_mai_yuyueCount.setText(yuGaoXiangQingBean.getData().getReservationNum() + "/" + yuGaoXiangQingBean.getData().getSubscribeNum());
        activity_xiang_qing_mai_price.setText("" + yuGaoXiangQingBean.getData().getPrice());
        activity_xiang_qing_mai_shoucang_goumai.setText("预约");
    }


    private class MyWebChromeClient extends WebChromeClient {
        private View mCustomView;
        private CustomViewCallback mCustomViewCallback;

        @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {
            super.onShowCustomView(view, callback);
            masterlivedetail_frame.setVisibility(View.VISIBLE);
            if (mCustomView != null) {
                callback.onCustomViewHidden();
                return;
            }
            mCustomView = view;
            masterlivedetail_frame.addView(mCustomView);
            mCustomViewCallback = callback;
            activity_xiang_qing_mai_wenView.setVisibility(View.GONE);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        @Override
        public void onHideCustomView() {
            masterlivedetail_frame.setVisibility(View.GONE);
            activity_xiang_qing_mai_wenView.setVisibility(View.VISIBLE);
            if (mCustomView == null) {
                return;
            }
            mCustomView.setVisibility(View.GONE);
            masterlivedetail_frame.removeView(mCustomView);
            mCustomViewCallback.onCustomViewHidden();
            mCustomView = null;
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            super.onHideCustomView();
        }
    }


    private void isLogin() {
        if (ShareUtils.getLoginUserId() == 0) {
            Toast.makeText(this, "请您先去登录", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(XiangQing_Mai_Activity.this, LoginActivity.class);
            startActivity(intent);
            return;
        }
    }
}
