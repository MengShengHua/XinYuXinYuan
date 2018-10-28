package com.example.xinyuxinyuan.view.activity.wode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.contract.PersonInforContract;
import com.example.xinyuxinyuan.model.bean.HomePagerBean;
import com.example.xinyuxinyuan.model.bean.LoginBean;
import com.example.xinyuxinyuan.presenter.PersonHomePagerPresenter;
import com.example.xinyuxinyuan.utils.LoginShareUtils;
import com.example.xinyuxinyuan.utils.ToastUtils;
import com.example.xinyuxinyuan.view.fragment.mingshi.MingShiFragment;
import com.example.xinyuxinyuan.view.fragment.zuoye.fragment.ZhiNengFragment;

public class PersonalActivity extends BaseActivity implements View.OnClickListener, PersonInforContract.PersonInforView {

    private ImageView personalActivity_return;
    private ImageView personalActivity_Header;
    private TextView personalActivity_followCount;
    private TextView personalActivity_FansCount;
    private Button personalActivity_Bt_follow;
    private TextView personalActivity_works;
    private TextView personalActivity_worksColor;
    private TextView personalActivity_Tiezi;
    private TextView personalActivity_TieziColor;
    private FrameLayout personalActivity_FrameLayout;
    private PersonHomePagerPresenter presenter;
    //    传过来的用户ID
    private String UserId;
    private String judgeFollow;
    private String photo;

    @Override
    protected void onResume() {
        super.onResume();
        if (UserId != null) {
            if (mOnClickListener != null) {
                mOnClickListener.onClick(UserId);
            }
            presenter.loadUserInfor(664 + "", LoginShareUtils.getUserMessage(this, "id"));
        }

    }

    private void initView() {
//        返回上页面
        personalActivity_return = (ImageView) findViewById(R.id.personalActivity_return);
//        用户头像
        personalActivity_Header = (ImageView) findViewById(R.id.personalActivity_Header);
//        关注数量
        personalActivity_followCount = (TextView) findViewById(R.id.personalActivity_followCount);
//        粉丝数量
        personalActivity_FansCount = (TextView) findViewById(R.id.personalActivity_FansCount);
//        关注
        personalActivity_Bt_follow = (Button) findViewById(R.id.personalActivity_Bt_follow);
//        作品
        personalActivity_works = (TextView) findViewById(R.id.personalActivity_works);
//        作品底部颜色
        personalActivity_worksColor = (TextView) findViewById(R.id.personalActivity_worksColor);
//        帖子
        personalActivity_Tiezi = (TextView) findViewById(R.id.personalActivity_Tiezi);
//        帖子底部颜色
        personalActivity_TieziColor = (TextView) findViewById(R.id.personalActivity_TieziColor);
//        FrameLayout
        personalActivity_FrameLayout = (FrameLayout) findViewById(R.id.personalActivity_FrameLayout);

        personalActivity_return.setOnClickListener(this);
        personalActivity_Bt_follow.setOnClickListener(this);
        personalActivity_works.setOnClickListener(this);
        personalActivity_Tiezi.setOnClickListener(this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal;
    }

    @Override
    protected void init() {
        initView();
        //replacetContenView(R.id.personalActivity_FrameLayout, MingShiFragment.class, null);
    }

    @Override
    protected void loadData() {
        presenter = new PersonHomePagerPresenter(this);
        Intent intent = getIntent();
        UserId = intent.getStringExtra("UserId");
        photo = intent.getStringExtra("photo");

//        获取从粉丝页面穿过的值
        judgeFollow = intent.getStringExtra("是否关注");
        if ("yes".equals(judgeFollow)) {
            personalActivity_Bt_follow.setText("已关注");
            personalActivity_Bt_follow.setBackgroundColor(Color.parseColor("#ffffff"));
            personalActivity_Bt_follow.setTextColor(Color.parseColor("#dfdddd"));
        }

        if(!photo.contains("null")){
            Glide.with(this).load(photo).asBitmap()
                    .override(200, 200).into(new BitmapImageViewTarget(personalActivity_Header) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getResources(), resource);
                    drawable.setCircular(true);
                    personalActivity_Header.setImageDrawable(drawable);
                }
            });
        } else {
            personalActivity_Header.setBackgroundResource(R.mipmap.user_head_portrait);
        }

    }


    @Override
    public void onClick(View v) {
        String Bt = personalActivity_Bt_follow.getText().toString().trim();
        switch (v.getId()) {
            case R.id.personalActivity_return:
                finish();
                break;
            case R.id.personalActivity_Bt_follow:
//                true为关注，false为取消关注
                if (presenter.JudgButton(Bt, personalActivity_Bt_follow)) {
//            关注
//                    第一个参数为被关注者的用户ID，
                    presenter.loadFollow(827 + "", LoginShareUtils.getUserMessage(PersonalActivity.this, "id"));
                } else {
//                取消关注
                    presenter.loadDismissFollow(827 + "", LoginShareUtils.getUserMessage(PersonalActivity.this, "id"));
                }
                break;
            case R.id.personalActivity_works:
                personalActivity_works.setTextColor(Color.parseColor("#333333"));
                personalActivity_Tiezi.setTextColor(Color.parseColor("#666666"));
                personalActivity_TieziColor.setVisibility(View.GONE);
                personalActivity_worksColor.setVisibility(View.VISIBLE);
//                跳转到名师Fragment界面，名师界面获取此界面的接口回调的值，根据用户ID在进行一次网络访问
               // replacetContenView(R.id.personalActivity_FrameLayout, MingShiFragment.class, null);
                break;
            case R.id.personalActivity_Tiezi:
                personalActivity_works.setTextColor(Color.parseColor("#666666"));
                personalActivity_Tiezi.setTextColor(Color.parseColor("#333333"));
                personalActivity_TieziColor.setVisibility(View.VISIBLE);
                personalActivity_worksColor.setVisibility(View.GONE);
//                跳转到宝典Fragment里的随便复用的，，要把对用户ID传过去，获取到用户的帖子
              //  replacetContenView(R.id.personalActivity_FrameLayout, ZhiNengFragment.class, null);
                break;
        }

    }

    @Override
    public void showFollow(LoginBean loginBean) {
        ToastUtils.mainThread(loginBean.getMessage(), 0);
    }

    @Override
    public void showUserInfor(HomePagerBean homePagerBean) {
        HomePagerBean.DataBean.UserInfoBean userInfo = homePagerBean.getData().getUserInfo();
        personalActivity_FansCount.setText(userInfo.getFansCount() + "");
        personalActivity_followCount.setText(userInfo.getAttentionCount() + "");
    }

    public interface OnClickListener {
        void onClick(String userId);
    }

    private OnClickListener mOnClickListener;

    public void setOnClickListener(OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }
}
