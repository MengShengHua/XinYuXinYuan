package com.example.xinyuxinyuan.view.fragment.wode;


import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.xinyuxinyuan.App;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseFragment;
import com.example.xinyuxinyuan.contract.bean.UserInforBean;
import com.example.xinyuxinyuan.contract.my.FollowContract;
import com.example.xinyuxinyuan.presenter.my.FollowPresenter;
import com.example.xinyuxinyuan.utils.LoginShareUtils;
import com.example.xinyuxinyuan.view.activity.wode.AuthenticationActivity;
import com.example.xinyuxinyuan.view.activity.wode.HobbyActivity;
import com.example.xinyuxinyuan.view.activity.wode.MyMessageActivity;
import com.example.xinyuxinyuan.view.activity.wode.giftconter.GiftConterActivity;
import com.example.xinyuxinyuan.view.activity.wode.order.OrderActivity;
import com.example.xinyuxinyuan.view.activity.wode.PersonalActivity;
import com.example.xinyuxinyuan.view.activity.wode.RechargeActivity;
import com.example.xinyuxinyuan.view.activity.wode.SetActivity;
import com.example.xinyuxinyuan.view.activity.wode.FollowAndFansActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyInformationFragment extends BaseFragment implements View.OnClickListener, FollowContract.FollowContractView {
    private ImageView myInformation_Message;
    private ImageView myInformation_Set;
    private ImageView myInformation_Header;
    private TextView myInformation_UserName;
    private TextView myInformation_Myinformation;
    private TextView myInformation_work;
    private TextView myInformation_TieZi;
    private TextView myInformation_follow;
    private TextView myInformation_Fans;
    private TextView myInformation_WaitForMoney;
    private TextView myInformation_WaitForShiYong;
    private TextView myInformation_WaitForReturnGoods;
    private TextView myInformation_WaitForOrder;
    private TextView myInformation_JinDou;
    private LinearLayout myInformation_Recharge;
    private LinearLayout myInformation_Gift;
    private LinearLayout myInformation_Collection;
    private LinearLayout myInformation_PianHao;
    private TextView myInformation_RenZhengState;
    private LinearLayout myInformation_RenZheng;
    private ArrayList<String> userAllMessage;
    private FollowPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my_information;
    }

    @Override
    protected void init(View view) {
        initView(view);

    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.loadMyFollow(LoginShareUtils.getUserMessage(getContext(), "id"));
        Log.e("----", "我的关注");
    }

    @Override
    protected void loadData() {
//        关注
        presenter = new FollowPresenter(this);

        OnClickListener();
//        获取用户登录的所有信息
        userAllMessage = LoginShareUtils.getUserAllMessage(App.context);
//        昵称
        myInformation_UserName.setText(userAllMessage.get(0));
        Glide.with(this).load(userAllMessage.get(2)).asBitmap()
                .override(200, 200).into(new BitmapImageViewTarget(myInformation_Header) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getResources(), resource);
                drawable.setCircular(true);
                myInformation_Header.setImageDrawable(drawable);
            }
        });
    }


    @Override
    public void onClick(View v) {
        Intent followIntent = new Intent(getContext(), FollowAndFansActivity.class);
        Intent orderIntent = new Intent(getContext(), OrderActivity.class);
        switch (v.getId()) {
            case R.id.myInformation_Message:
                break;
            case R.id.myInformation_Set:
                startActivity(new Intent(getContext(), SetActivity.class));
                break;
            case R.id.myInformation_Header:
                startActivity(new Intent(getContext(), PersonalActivity.class));
                break;
            case R.id.myInformation_UserName:
                break;
            case R.id.myInformation_Myinformation:
                Intent intent = new Intent(getContext(), MyMessageActivity.class);
                intent.putExtra("nickname", userAllMessage.get(0));
                intent.putExtra("phone", userAllMessage.get(1));
                intent.putExtra("photo", userAllMessage.get(2));
                intent.putExtra("id", userAllMessage.get(3));
                intent.putExtra("token", userAllMessage.get(4));
                startActivity(intent);
                break;
            case R.id.myInformation_work:
//                复用名师
                break;
            case R.id.myInformation_TieZi:
//                复用宝典
                break;
            case R.id.myInformation_follow:
//                关注和粉丝通用一个Activity
                followIntent.putExtra("FollowAndFans", "关注");
                startActivity(followIntent);
                break;
            case R.id.myInformation_Fans:
//                关注和粉丝通用一个Activity
                followIntent.putExtra("FollowAndFans", "粉丝");
                startActivity(followIntent);
                break;
            case R.id.myInformation_WaitForMoney:
                orderIntent.putExtra("order", "待付款");
                startActivity(orderIntent);
                break;
            case R.id.myInformation_WaitForShiYong:
                orderIntent.putExtra("order", "待使用");
                startActivity(orderIntent);
                break;
            case R.id.myInformation_WaitForReturnGoods:
                orderIntent.putExtra("order", "待退货");
                startActivity(orderIntent);
                break;
            case R.id.myInformation_WaitForOrder:
                orderIntent.putExtra("order", "我的订单");
                startActivity(orderIntent);
                break;
            case R.id.myInformation_JinDou:
                break;
            case R.id.myInformation_Recharge:
                startActivity(new Intent(getContext(), RechargeActivity.class));
                break;
            case R.id.myInformation_Gift:
                startActivity(new Intent(getContext(), GiftConterActivity.class));
                break;
            case R.id.myInformation_Collection:

                break;
            case R.id.myInformation_PianHao:
                startActivity(new Intent(getContext(), HobbyActivity.class));
                break;
            case R.id.myInformation_RenZhengState:

                break;
            case R.id.myInformation_RenZheng:
                startActivity(new Intent(getContext(), AuthenticationActivity.class));
                break;

        }
    }

    private void OnClickListener() {
        myInformation_Message.setOnClickListener(this);
        myInformation_Set.setOnClickListener(this);
        myInformation_Header.setOnClickListener(this);
        myInformation_UserName.setOnClickListener(this);
        myInformation_Myinformation.setOnClickListener(this);
        myInformation_work.setOnClickListener(this);
        myInformation_TieZi.setOnClickListener(this);
        myInformation_follow.setOnClickListener(this);
        myInformation_Fans.setOnClickListener(this);
        myInformation_WaitForMoney.setOnClickListener(this);
        myInformation_WaitForShiYong.setOnClickListener(this);
        myInformation_WaitForReturnGoods.setOnClickListener(this);
        myInformation_WaitForOrder.setOnClickListener(this);
        myInformation_JinDou.setOnClickListener(this);
        myInformation_Recharge.setOnClickListener(this);
        myInformation_Gift.setOnClickListener(this);
        myInformation_Collection.setOnClickListener(this);
        myInformation_PianHao.setOnClickListener(this);
        myInformation_RenZhengState.setOnClickListener(this);
        myInformation_RenZheng.setOnClickListener(this);
    }

    private void initView(View view) {
        //        右上角消息图标
        myInformation_Message = view.findViewById(R.id.myInformation_Message);
//        右上角设置图标
        myInformation_Set = view.findViewById(R.id.myInformation_Set);
//        头像
        myInformation_Header = view.findViewById(R.id.myInformation_Header);
//        昵称
        myInformation_UserName = view.findViewById(R.id.myInformation_UserName);
//        我的信息
        myInformation_Myinformation = view.findViewById(R.id.myInformation_Myinformation);
//        作品
        myInformation_work = view.findViewById(R.id.myInformation_work);
//        帖子
        myInformation_TieZi = view.findViewById(R.id.myInformation_TieZi);
//        关注
        myInformation_follow = view.findViewById(R.id.myInformation_follow);
//        粉丝
        myInformation_Fans = view.findViewById(R.id.myInformation_Fans);
//        代付款
        myInformation_WaitForMoney = view.findViewById(R.id.myInformation_WaitForMoney);
//        代使用
        myInformation_WaitForShiYong = view.findViewById(R.id.myInformation_WaitForShiYong);
//        代退货
        myInformation_WaitForReturnGoods = view.findViewById(R.id.myInformation_WaitForReturnGoods);
//        我的订单
        myInformation_WaitForOrder = view.findViewById(R.id.myInformation_WaitForOrder);

//        充值中心
        myInformation_Recharge = view.findViewById(R.id.myInformation_Recharge);
        //       充值中心金豆数量
        myInformation_JinDou = view.findViewById(R.id.myInformation_JinDou);
//        礼物中心
        myInformation_Gift = view.findViewById(R.id.myInformation_Gift);
//        我的收藏
        myInformation_Collection = view.findViewById(R.id.myInformation_Collection);
//        我的偏好
        myInformation_PianHao = view.findViewById(R.id.myInformation_PianHao);
        //        我的认证
        myInformation_RenZheng = view.findViewById(R.id.myInformation_RenZheng);
        //        是否认证的状态
        myInformation_RenZhengState = view.findViewById(R.id.myInformation_RenZhengState);
    }

    @Override
    public void showMyFollow(UserInforBean userInforBean) {
        UserInforBean.DataBean data = userInforBean.getData();
        Log.e("数据", data.toString());
        myInformation_follow.setText(data.getAttentionCount() + "");
        myInformation_Fans.setText(data.getFansCount() + "");
        myInformation_JinDou.setText(data.getBeanAmount() + "");
        myInformation_work.setText(data.getHomewokCount() + "");
        myInformation_TieZi.setText(data.getArtcircleCount() + "");
    }
}
