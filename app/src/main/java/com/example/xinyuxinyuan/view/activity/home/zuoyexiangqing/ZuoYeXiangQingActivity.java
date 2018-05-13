package com.example.xinyuxinyuan.view.activity.home.zuoyexiangqing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseActivity;
import com.example.xinyuxinyuan.contract.bean.DianZanBean;
import com.example.xinyuxinyuan.contract.bean.PinLunBean;
import com.example.xinyuxinyuan.contract.bean.QuXiaoDianZanBean;
import com.example.xinyuxinyuan.contract.bean.ZuoYeXiangQingBean;
import com.example.xinyuxinyuan.contract.home.DianZan;
import com.example.xinyuxinyuan.contract.home.PinLun;
import com.example.xinyuxinyuan.contract.home.QuXiaoDianZan;
import com.example.xinyuxinyuan.contract.home.ZuoYeXiangQing;
import com.example.xinyuxinyuan.presenter.dianzan.DianZanPresenter;
import com.example.xinyuxinyuan.presenter.dianzan.QuXiaoDianZanPresenter;
import com.example.xinyuxinyuan.presenter.home.PinLunPresenter;
import com.example.xinyuxinyuan.presenter.home.ZuoYeXiangQingPresenter;
import com.example.xinyuxinyuan.utils.DataUtils;
import com.example.xinyuxinyuan.utils.MyScrollView;
import com.example.xinyuxinyuan.utils.ShareUtils;
import com.example.xinyuxinyuan.utils.zidingyi.GlideCircleTransform;
import com.example.xinyuxinyuan.view.activity.login.LoginActivity;

import java.util.List;

public class ZuoYeXiangQingActivity extends BaseActivity implements View.OnClickListener, View.OnFocusChangeListener, ZuoYeXiangQing.View, DianZan.View, QuXiaoDianZan.View, PinLun.View {
    private ImageView title_fuyong_finish;
    private TextView title_fuyong_text;
    private ImageView zuo_ye_xiang_qing_photo;
    private TextView zuo_ye_xiang_qing_name;
    private TextView zuo_ye_xiang_qing_time;
    private TextView zuo_ye_xiang_qing_from;
    private WebView zuo_ye_xiang_qing_WebView;
    private TextView zuo_ye_xiang_qing_shang;
    private RecyclerView zuo_ye_xiang_qing_shangRecyclerView;
    private LinearLayout zuo_ye_xiang_qing_shang_group;
    private LinearLayout zuo_ye_xiang_qing_pinlun_group;
    private RecyclerView zuo_ye_xiang_pinLun_recyclerView;
    private TextView zuo_ye_xiang_pinLun_chakan;
    private LinearLayout zuo_ye_xiang_qing_contentView;
    private MyScrollView zuo_ye_xiang_qing_myScrollView;
    private TextView zuo_ye_xiang_xiepinglun;
    private TextView zuo_ye_xiang_dianzanshu_btn;
    private TextView zuo_ye_xiang_dianzanshu_count;
    private RelativeLayout zuo_ye_xiang_dianzanshu_group;
    private TextView zuo_ye_xiang_pinlunshu_btn;
    private TextView zuo_ye_xiang_pinlunshu_count;
    private RelativeLayout zuo_ye_xiang_pinlunshu_group;

    private RelativeLayout zuo_ye_xiang_xiePinLun_group;
    private Button zuo_ye_xiang_send_pinlun_btn;
    private EditText zuo_ye_xiang_send_pinlun_editText;
    private RelativeLayout zuo_ye_xiang_send_pinlun_group;
    private LinearLayout wok_detail_aty_group;
    private int id;
    private ZuoYeXiangQingPresenter zuoYeXiangQingPresenter;
    private TextView zuo_ye_xiang_qing_neirong;
    private ImageView zuo_ye_xiang_qing_image;
    private TouXiangAdpater touXiangAdpater;
    private PinLunAdpater pinLunAdpater;
    private LinearLayout linearLayout;
    private TextView textView4;

    private ImageView zuo_ye_xiang_qing_yincang_group_image;
    private TextView zuo_ye_xiang_qing_yincang_group_name;
    private TextView zuo_ye_xiang_qing_yincang_group_daren;
    private ImageView zuo_ye_xiang_qing_yincang_group_vipImage;
    private TextView zuo_ye_xiang_qing_touting_price;
    private ImageView zuo_ye_xiang_qing_touting_playImage;
    private RelativeLayout zuo_ye_xiang_qing_touting_group;
    private RelativeLayout zuo_ye_xiang_qing_yincang_group;
    private boolean DianZanTag = false;
    private DianZanPresenter dianZanPresenter;
    private QuXiaoDianZanPresenter quXiaoDianZanPresenter;
    private ZuoYeXiangQingBean.DataBean.HomewokBean homewok;
    private ZuoYeXiangQingBean.DataBean.HomewokBean homewok1;
    private PinLunPresenter pinLunPresenter;
    private int id1;
    private int pinLunRenId;
    private int userId;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_zuo_ye_xiang_qing;
    }

    @Override
    protected void init() {
        //点赞的P层
        dianZanPresenter = new DianZanPresenter(this);
        //实例化取消点赞的P层
        quXiaoDianZanPresenter = new QuXiaoDianZanPresenter(this);
        //实例化评论的P层对象
        pinLunPresenter = new PinLunPresenter(this);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);

        title_fuyong_finish = (ImageView) findViewById(R.id.title_fuyong_finish);
        title_fuyong_text = (TextView) findViewById(R.id.title_fuyong_text);
        title_fuyong_text.setText("作业详情");
        //实例化P层对象
        zuoYeXiangQingPresenter = new ZuoYeXiangQingPresenter(this);
        zuo_ye_xiang_qing_photo = (ImageView) findViewById(R.id.zuo_ye_xiang_qing_photo);
        zuo_ye_xiang_qing_name = (TextView) findViewById(R.id.zuo_ye_xiang_qing_name);
        zuo_ye_xiang_qing_time = (TextView) findViewById(R.id.zuo_ye_xiang_qing_time);
        zuo_ye_xiang_qing_from = (TextView) findViewById(R.id.zuo_ye_xiang_qing_from);


        zuo_ye_xiang_qing_shang = (TextView) findViewById(R.id.zuo_ye_xiang_qing_shang);
        zuo_ye_xiang_qing_shangRecyclerView = (RecyclerView) findViewById(R.id.zuo_ye_xiang_qing_shangRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        
        zuo_ye_xiang_qing_shangRecyclerView.setLayoutManager(linearLayoutManager);
        zuo_ye_xiang_qing_shang_group = (LinearLayout) findViewById(R.id.zuo_ye_xiang_qing_shang_group);
        zuo_ye_xiang_qing_pinlun_group = (LinearLayout) findViewById(R.id.zuo_ye_xiang_qing_pinlun_group);
        zuo_ye_xiang_pinLun_recyclerView = (RecyclerView) findViewById(R.id.zuo_ye_xiang_pinLun_recyclerView);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        zuo_ye_xiang_pinLun_recyclerView.setLayoutManager(linearLayoutManager1);

        zuo_ye_xiang_pinLun_chakan = (TextView) findViewById(R.id.zuo_ye_xiang_pinLun_chakan);
        zuo_ye_xiang_qing_contentView = (LinearLayout) findViewById(R.id.zuo_ye_xiang_qing_contentView);
        zuo_ye_xiang_qing_myScrollView = (MyScrollView) findViewById(R.id.zuo_ye_xiang_qing_myScrollView);
        zuo_ye_xiang_xiepinglun = (TextView) findViewById(R.id.zuo_ye_xiang_xiepinglun);
        zuo_ye_xiang_dianzanshu_btn = (TextView) findViewById(R.id.zuo_ye_xiang_dianzanshu_btn);
        zuo_ye_xiang_dianzanshu_count = (TextView) findViewById(R.id.zuo_ye_xiang_dianzanshu_count);
        zuo_ye_xiang_dianzanshu_group = (RelativeLayout) findViewById(R.id.zuo_ye_xiang_dianzanshu_group);
        zuo_ye_xiang_pinlunshu_btn = (TextView) findViewById(R.id.zuo_ye_xiang_pinlunshu_btn);
        zuo_ye_xiang_pinlunshu_count = (TextView) findViewById(R.id.zuo_ye_xiang_pinlunshu_count);
        zuo_ye_xiang_pinlunshu_group = (RelativeLayout) findViewById(R.id.zuo_ye_xiang_pinlunshu_group);
        zuo_ye_xiang_xiePinLun_group = (RelativeLayout) findViewById(R.id.zuo_ye_xiang_xiePinLun_group);
        zuo_ye_xiang_send_pinlun_btn = (Button) findViewById(R.id.zuo_ye_xiang_send_pinlun_btn);
        zuo_ye_xiang_send_pinlun_editText = (EditText) findViewById(R.id.zuo_ye_xiang_send_pinlun_editText);
        zuo_ye_xiang_send_pinlun_group = (RelativeLayout) findViewById(R.id.zuo_ye_xiang_send_pinlun_group);
        wok_detail_aty_group = (LinearLayout) findViewById(R.id.wok_detail_aty_group);
        zuo_ye_xiang_qing_neirong = findViewById(R.id.zuo_ye_xiang_qing_neirong);
        zuo_ye_xiang_qing_image = findViewById(R.id.zuo_ye_xiang_qing_image);


        zuo_ye_xiang_qing_yincang_group_image = findViewById(R.id.zuo_ye_xiang_qing_yincang_group_image);
        zuo_ye_xiang_qing_yincang_group_name = findViewById(R.id.zuo_ye_xiang_qing_yincang_group_name);
        zuo_ye_xiang_qing_yincang_group_daren = findViewById(R.id.zuo_ye_xiang_qing_yincang_group_daren);
        zuo_ye_xiang_qing_yincang_group_vipImage = findViewById(R.id.zuo_ye_xiang_qing_yincang_group_vipImage);
        zuo_ye_xiang_qing_touting_price = findViewById(R.id.zuo_ye_xiang_qing_touting_price);
        zuo_ye_xiang_qing_touting_playImage = findViewById(R.id.zuo_ye_xiang_qing_touting_playImage);
        zuo_ye_xiang_qing_touting_group = findViewById(R.id.zuo_ye_xiang_qing_touting_group);
        zuo_ye_xiang_qing_yincang_group = findViewById(R.id.zuo_ye_xiang_qing_yincang_group);


        //刚进来界面时,
        zuo_ye_xiang_dianzanshu_group.setVisibility(View.VISIBLE);
        zuo_ye_xiang_xiePinLun_group.setVisibility(View.VISIBLE);
        zuo_ye_xiang_qing_pinlun_group.setVisibility(View.VISIBLE);
        zuo_ye_xiang_send_pinlun_group.setVisibility(View.GONE);
        zuo_ye_xiang_send_pinlun_editText.setOnFocusChangeListener(this);
        zuo_ye_xiang_xiepinglun.setOnClickListener(this);
        title_fuyong_finish.setOnClickListener(this);
        zuo_ye_xiang_send_pinlun_btn.setOnClickListener(this);
        zuo_ye_xiang_qing_touting_price.setOnClickListener(this);
        zuo_ye_xiang_qing_touting_group.setOnClickListener(this);
        zuo_ye_xiang_qing_touting_playImage.setOnClickListener(this);
        zuo_ye_xiang_qing_yincang_group_image.setOnClickListener(this);
        zuo_ye_xiang_pinlunshu_group.setOnClickListener(this);
        zuo_ye_xiang_dianzanshu_group.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        //加载数据
        zuoYeXiangQingPresenter.loadZuoYeXiangQingData(ShareUtils.getLoginUserId(), id);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zuo_ye_xiang_send_pinlun_btn:
                isLogin();
                submit();
                break;
            case R.id.zuo_ye_xiang_xiepinglun:
                zuo_ye_xiang_dianzanshu_group.setVisibility(View.GONE);
                zuo_ye_xiang_xiePinLun_group.setVisibility(View.GONE);
                zuo_ye_xiang_qing_pinlun_group.setVisibility(View.GONE);
                zuo_ye_xiang_send_pinlun_group.setVisibility(View.VISIBLE);
                zuo_ye_xiang_send_pinlun_btn.setVisibility(View.VISIBLE);
                zuo_ye_xiang_send_pinlun_editText.setFocusable(true);
                break;
            case R.id.title_fuyong_finish:
                finish();
                break;
            case R.id.zuo_ye_xiang_qing_touting_price:
                Toast.makeText(this, "掏钱", Toast.LENGTH_SHORT).show();
                break;
            case R.id.zuo_ye_xiang_qing_touting_group:
                Toast.makeText(this, "掏钱", Toast.LENGTH_SHORT).show();
                break;
            case R.id.zuo_ye_xiang_qing_touting_playImage:
                Toast.makeText(this, "掏钱", Toast.LENGTH_SHORT).show();
                break;
            case R.id.zuo_ye_xiang_qing_yincang_group_image:

                break;
            case R.id.zuo_ye_xiang_pinlunshu_group:

                break;
            case R.id.zuo_ye_xiang_dianzanshu_group:
                isLogin();
                if (DianZanTag == true) {
                    quXiaoDianZanPresenter.loadQuXiaoDianZan(homewok1.getId(), homewok1.getTUserId(), ShareUtils.getLoginUserId(), "学生作业");
                    zuo_ye_xiang_dianzanshu_count.setText("" + homewok1.getPraiseNum());
                } else {
                    dianZanPresenter.loadDianZanData(homewok1.getId(), homewok1.getTUserId(), ShareUtils.getLoginUserId(), "学生作业");
                    zuo_ye_xiang_dianzanshu_count.setText("" + (homewok1.getPraiseNum() + 1));
                }
                break;
        }
    }

    /**
     * id        自动增长列
     * page      当前第几页
     * rows      每页显示条数
     * pid       (回复才有）评论ID 默认为0
     * userId    评论人ID
     * content   评论内容
     * toId      (回复才有）原评论人
     * toContent (回复才有）原评论内容
     * replyId   评论-回复-回复 @的用户ID
     * refId     关联的ID
     * refType   关联的类型: 作业评论 作业回复 艺考圈评论 艺考圈回复
     * createDate 创建时间
     * status     评论状态 0正常 1删除
     */
    private void submit() {
        String editText = zuo_ye_xiang_send_pinlun_editText.getText().toString().trim();
        if (TextUtils.isEmpty(editText)) {
            Toast.makeText(this, "说点什么...", Toast.LENGTH_SHORT).show();
            return;
        }
        pinLunPresenter.loadPinLunData(ShareUtils.getLoginUserId(), editText, id1, "作业评论", 0);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus == true) {
            zuo_ye_xiang_dianzanshu_group.setVisibility(View.GONE);
            zuo_ye_xiang_xiePinLun_group.setVisibility(View.GONE);
            zuo_ye_xiang_qing_pinlun_group.setVisibility(View.GONE);
            zuo_ye_xiang_send_pinlun_group.setVisibility(View.VISIBLE);
            zuo_ye_xiang_send_pinlun_btn.setVisibility(View.VISIBLE);
        } else {
            zuo_ye_xiang_dianzanshu_group.setVisibility(View.GONE);
            zuo_ye_xiang_xiePinLun_group.setVisibility(View.GONE);
            zuo_ye_xiang_qing_pinlun_group.setVisibility(View.GONE);
            zuo_ye_xiang_send_pinlun_group.setVisibility(View.VISIBLE);
            zuo_ye_xiang_send_pinlun_btn.setVisibility(View.GONE);
        }
    }


    private void isLogin() {
        if (ShareUtils.getLoginUserId() == 0) {
            Toast.makeText(this, "请您先去登录", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ZuoYeXiangQingActivity.this, LoginActivity.class);
            startActivity(intent);
            return;
        }
    }

    @Override
    public void showZuoYeXiangQingData(ZuoYeXiangQingBean zuoYeXiangQingBean) {

        homewok1 = zuoYeXiangQingBean.getData().getHomewok();
        id1 = zuoYeXiangQingBean.getData().getHomewok().getId();

        //这是点赞的点击事件
        int praiseNum = zuoYeXiangQingBean.getData().getHomewok().getPraiseNum();
        if (zuoYeXiangQingBean.getData().getHomewok().getIsPraise() == 0) {
            DianZanTag = false;

        } else if (zuoYeXiangQingBean.getData().getHomewok().getIsPraise() == 1) {
            DianZanTag = true;
        }

        zuo_ye_xiang_dianzanshu_count.setText("" + praiseNum);
        zuo_ye_xiang_pinlunshu_count.setText("" + zuoYeXiangQingBean.getData().getHomewok().getCommentNum());
        if (zuoYeXiangQingBean.getData().getHomewok().getTUserType() == 0) {
            zuo_ye_xiang_qing_yincang_group.setVisibility(View.GONE);
        } else {
            zuo_ye_xiang_qing_yincang_group.setVisibility(View.VISIBLE);
        }
        zuo_ye_xiang_qing_yincang_group_daren.setText((String) zuoYeXiangQingBean.getData().getHomewok().getTIntro());
        zuo_ye_xiang_qing_yincang_group_name.setText((String) zuoYeXiangQingBean.getData().getHomewok().getTRealname());
        Glide.with(this).load(zuoYeXiangQingBean.getData().getHomewok().getPhoto()).transform(new GlideCircleTransform(this)).into(zuo_ye_xiang_qing_yincang_group_image);
        Glide.with(this).load(zuoYeXiangQingBean.getData().getHomewok().getAnswerCoverImg()).transform(new GlideCircleTransform(this)).into(zuo_ye_xiang_qing_photo);
        zuo_ye_xiang_qing_name.setText(zuoYeXiangQingBean.getData().getHomewok().getNickname());
        zuo_ye_xiang_qing_time.setText(DataUtils.getDateToStringMMDD(zuoYeXiangQingBean.getData().getHomewok().getCreateDate()));
        zuo_ye_xiang_qing_from.setText(zuoYeXiangQingBean.getData().getHomewok().getSource());
        zuo_ye_xiang_qing_neirong.setText(zuoYeXiangQingBean.getData().getHomewok().getContent());
        Glide.with(this).load(zuoYeXiangQingBean.getData().getHomewok().getCoverImg()).into(zuo_ye_xiang_qing_image);
        List<ZuoYeXiangQingBean.DataBean.RewardUserListBean> rewardUserList = zuoYeXiangQingBean.getData().getRewardUserList();
        //设置赞赏的列表
        touXiangAdpater = new TouXiangAdpater(this, rewardUserList);
        zuo_ye_xiang_qing_shangRecyclerView.setAdapter(touXiangAdpater);
        //设置评论列表的适配器
        List<ZuoYeXiangQingBean.DataBean.CommentsBean.ListBean> list = zuoYeXiangQingBean.getData().getComments().getList();
        pinLunAdpater = new PinLunAdpater(ZuoYeXiangQingActivity.this, list);
        zuo_ye_xiang_pinLun_recyclerView.setAdapter(pinLunAdpater);
    }

    @Override
    public void showDianZanData(DianZanBean dianZanBean) {

    }

    @Override
    public void showQuXiaoDianZanData(QuXiaoDianZanBean quXiaoDianZan) {

    }


    @Override
    public void showPinLunData(ZuoYeXiangQingBean.DataBean.CommentsBean.ListBean listBean) {

        //加载数据
        zuoYeXiangQingPresenter.loadZuoYeXiangQingData(ShareUtils.getLoginUserId(), id);
        zuo_ye_xiang_send_pinlun_editText.setText("");
        //评论id
        pinLunRenId = listBean.getId();
        //评论人id
        userId = listBean.getUserId();

    }
}
