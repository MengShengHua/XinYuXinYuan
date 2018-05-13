package com.example.xinyuxinyuan.view.activity.home.huifu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.contract.bean.HuiFuBean;
import com.example.xinyuxinyuan.utils.DataUtils;
import com.example.xinyuxinyuan.utils.zidingyi.GlideCircleTransform;
import com.example.xinyuxinyuan.view.activity.home.zuoyexiangqing.PinLunAdpater;

import java.util.List;

/**
 * Created by 键盘上的手艺人 on 2018/5/13.
 */

public class HuiFuAdpater extends RecyclerView.Adapter<HuiFuAdpater.Hodler>{
    Context context;
    List<HuiFuBean> mList;
    private int praiseNum;
    private int id;
    private int userId;
    private boolean DianTag = false;
    public HuiFuAdpater(Context context, List<HuiFuBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HuiFuAdpater.Hodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.pin_lun_layout, parent, false);
        Hodler hodler = new Hodler(inflate);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull HuiFuAdpater.Hodler holder, int position) {
        int isPraise = mList.get(position).getData().getIsPraise();

        if (isPraise == 1) {
            holder.pin_lun_item_chect_dianzan.setChecked(true);
            DianTag = true;
        } else {
            holder.pin_lun_item_chect_dianzan.setChecked(false);
            DianTag = false;
        }


        praiseNum = mList.get(position).getData().getPraiseNum();
        holder.pin_lun_item_chect_dianzan.setText("" + praiseNum);
        holder.pin_lun_item_name.setText(mList.get(position).getData().getNickname());
        holder.pin_lun_item_neirong.setText(mList.get(position).getData().getContent());
        Glide.with(context).load(mList.get(position).getData().getPhoto()).transform(new GlideCircleTransform(context)).into(holder.pin_lun_item_image);
        holder.pin_lun_item_data.setText("" + DataUtils.getDateToStringMMDD(mList.get(position).getData().getCreateDate()));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class Hodler extends RecyclerView.ViewHolder {
        private ImageView pin_lun_item_image;
        private TextView pin_lun_item_name;
        private TextView pin_lun_item_neirong;
        private TextView pin_lun_item_data;
        private CheckBox pin_lun_item_chect_dianzan;
        private TextView pin_lun_item_chect_huifu;
        private TextView pin_lun_item_gongjitiao_huifu;

        public Hodler(View itemView) {
            super(itemView);
            pin_lun_item_image = itemView.findViewById(R.id.pin_lun_item_image);
            pin_lun_item_name = itemView.findViewById(R.id.pin_lun_item_name);
            pin_lun_item_neirong = itemView.findViewById(R.id.pin_lun_item_neirong);
            pin_lun_item_data = itemView.findViewById(R.id.pin_lun_item_data);
            pin_lun_item_chect_dianzan = itemView.findViewById(R.id.pin_lun_item_chect_dianzan);
            pin_lun_item_chect_huifu = itemView.findViewById(R.id.pin_lun_item_chect_huifu);
            pin_lun_item_gongjitiao_huifu = itemView.findViewById(R.id.pin_lun_item_gongjitiao_huifu);
        }
    }
}
