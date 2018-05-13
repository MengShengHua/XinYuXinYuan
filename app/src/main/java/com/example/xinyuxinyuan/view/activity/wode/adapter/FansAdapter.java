package com.example.xinyuxinyuan.view.activity.wode.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.contract.PersonInforContract;
import com.example.xinyuxinyuan.contract.bean.FansBean;
import com.example.xinyuxinyuan.contract.bean.HomePagerBean;
import com.example.xinyuxinyuan.contract.bean.LoginBean;
import com.example.xinyuxinyuan.presenter.PersonHomePagerPresenter;
import com.example.xinyuxinyuan.utils.LoginShareUtils;
import com.example.xinyuxinyuan.utils.ToastUtils;
import com.example.xinyuxinyuan.view.activity.wode.PersonalActivity;

import java.util.List;

/**
 * Created by asd on 2018/5/10.
 */

public class FansAdapter extends BaseAdapter implements PersonInforContract.PersonInforView {
    private List<FansBean.DataBean.ListBean> list;
    private Context context;
    private Resources resources;
    PersonHomePagerPresenter presenter = new PersonHomePagerPresenter(this);
    //    用来标记是否关注
    private int count;

    public FansAdapter(List<FansBean.DataBean.ListBean> list, Context context, Resources resources) {
        this.list = list;
        this.context = context;
        this.resources = resources;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.follow_adapter, null);
        final ImageView followadapter_FollowHeader = convertView.findViewById(R.id.followadapter_FollowHeader);
        TextView followadapter_FollowName = convertView.findViewById(R.id.followadapter_FollowName);
        final Button followadapter_bt_Follow = convertView.findViewById(R.id.followadapter_bt_Follow);
        String photo = list.get(position).getPhoto();
        if (photo.endsWith(".jpg") || photo.endsWith(".png")) {
            Glide.with(context).load(list.get(position).getPhoto()).asBitmap()
                    .override(200, 200).into(new BitmapImageViewTarget(followadapter_FollowHeader) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(resources, resource);
                    drawable.setCircular(true);
                    followadapter_FollowHeader.setImageDrawable(drawable);
                }
            });
        } else if (photo.contains("null")) {
            followadapter_FollowHeader.setBackgroundResource(R.mipmap.user_head_portrait);
        }
        followadapter_FollowHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fansIntent = new Intent(context, PersonalActivity.class);
                fansIntent.putExtra("UserId", list.get(position).getFansId() + "");
//                传到个人界面判断你是否关注这个人
                if (followadapter_bt_Follow.getText().toString().trim().equals("已关注")) {
                    fansIntent.putExtra("是否关注", "yes");
                } else {

                    fansIntent.putExtra("是否关注", "no");
                }
                context.startActivity(fansIntent);
            }
        });
        followadapter_FollowName.setText(list.get(position).getNickname());
        final String btData = followadapter_bt_Follow.getText().toString().trim();
        followadapter_bt_Follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if (count % 2 == 0) {
                    presenter.loadFollow(list.get(position).getFansId() + "", LoginShareUtils.getUserMessage(context, "id"));
                    followadapter_bt_Follow.setText("已关注");
                    followadapter_bt_Follow.setBackgroundColor(Color.parseColor("#ffffff"));
                    followadapter_bt_Follow.setTextColor(Color.parseColor("#dfdddd"));
                } else {
                    presenter.loadDismissFollow(list.get(position).getFansId() + "", LoginShareUtils.getUserMessage(context, "id"));
                    followadapter_bt_Follow.setText("关注");
                    followadapter_bt_Follow.setBackgroundColor(Color.parseColor("#142fdf"));
                    followadapter_bt_Follow.setTextColor(Color.parseColor("#ffffff"));
                }
            }
        });
        return convertView;
    }

    @Override
    public void showFollow(LoginBean loginBean) {
        ToastUtils.mainThread(loginBean.getMessage(), 0);
    }

    /**
     * 忽略大法开启
     * @param homePagerBean
     */
    @Override
    public void showUserInfor(HomePagerBean homePagerBean) {

    }
}
