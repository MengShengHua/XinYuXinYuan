package com.example.xinyuxinyuan.view.activity.home.zuoyexiangqing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.model.bean.ZuoYeXiangQingBean;
import com.example.xinyuxinyuan.utils.zidingyi.GlideCircleTransform;

import java.util.List;

/**
 * Created by 键盘上的手艺人 on 2018/5/11.
 */

public class TouXiangAdpater extends RecyclerView.Adapter<TouXiangAdpater.Hodler>{
    Context context;
    List<ZuoYeXiangQingBean.DataBean.RewardUserListBean> rewardUserList;
    public TouXiangAdpater(Context context, List<ZuoYeXiangQingBean.DataBean.RewardUserListBean> rewardUserList) {
        this.context = context;
        this.rewardUserList = rewardUserList;
    }

    @NonNull
    @Override
    public TouXiangAdpater.Hodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.tou_xiang_layout, parent, false);
        Hodler hodler = new Hodler(inflate);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull TouXiangAdpater.Hodler holder, int position) {
        Glide.with(context).load(rewardUserList.get(position).getUserPhoto()).transform(new GlideCircleTransform(context)).into(holder.tou_xiang_image);
    }

    @Override
    public int getItemCount() {
        return rewardUserList.size();
    }

    public class Hodler extends RecyclerView.ViewHolder {

        private final ImageView tou_xiang_image;

        public Hodler(View itemView) {
            super(itemView);
            tou_xiang_image = itemView.findViewById(R.id.tou_xiang_image);
        }
    }
}
