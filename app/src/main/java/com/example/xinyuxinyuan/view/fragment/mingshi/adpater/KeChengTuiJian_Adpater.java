package com.example.xinyuxinyuan.view.fragment.mingshi.adpater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.contract.Bean.MingShiBean;
import com.example.xinyuxinyuan.utils.DataUtils;

import java.util.List;

/**
 * Created by 键盘上的手艺人 on 2018/5/4.
 */

public class KeChengTuiJian_Adpater extends RecyclerView.Adapter<KeChengTuiJian_Adpater.Hodler>{
    Context context;
    List<MingShiBean.DataBean.LiveCoursesBean> kechengList;
    public KeChengTuiJian_Adpater(Context context, List<MingShiBean.DataBean.LiveCoursesBean> kechengList) {
        this.context = context;
        this.kechengList = kechengList;
    }

    @NonNull
    @Override
    public Hodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.kecheng_tuijian_item_layout, parent, false);
        Hodler hodler = new Hodler(inflate);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull Hodler holder, int position) {
        holder.kecheng_tuijian_item_kaibo.setText("讲堂开播:"+ DataUtils.getDateToString(kechengList.get(position).getStartDate()));
        holder.kecheng_tuijian_item_ketang.setText(kechengList.get(position).getType());
        holder.kecheng_tuijian_item_name.setText(kechengList.get(position).getNickname());
        Glide.with(context).load(kechengList.get(position).getCoverImg()).into(holder.kecheng_tuijian_item_image);
        if(position<=1){
            holder.kecheng_tuijian_item_tubiao.setImageResource(R.mipmap.home_level_vip_red);
        }else{
            holder.kecheng_tuijian_item_tubiao.setImageResource(R.mipmap.home_level_vip_yellow);
        }
    }

    @Override
    public int getItemCount() {
        return kechengList.size();
    }

    public class Hodler extends RecyclerView.ViewHolder {

        private final ImageView kecheng_tuijian_item_image;
        private final TextView kecheng_tuijian_item_kaibo;
        private final TextView kecheng_tuijian_item_ketang;
        private final TextView kecheng_tuijian_item_name;
        private final ImageView kecheng_tuijian_item_tubiao;

        public Hodler(View itemView) {
            super(itemView);
            kecheng_tuijian_item_image = itemView.findViewById(R.id.kecheng_tuijian_item_image);
            kecheng_tuijian_item_kaibo = itemView.findViewById(R.id.kecheng_tuijian_item_kaibo);
            kecheng_tuijian_item_ketang = itemView.findViewById(R.id.kecheng_tuijian_item_ketang);
            kecheng_tuijian_item_name = itemView.findViewById(R.id.kecheng_tuijian_item_name);
            kecheng_tuijian_item_tubiao = itemView.findViewById(R.id.kecheng_tuijian_item_tubiao);
        }
    }
}
