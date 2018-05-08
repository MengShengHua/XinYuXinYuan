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
import com.example.xinyuxinyuan.contract.bean.MingShiBean;

import java.util.List;

/**
 * Created by 键盘上的手艺人 on 2018/5/4.
 */

public class MingShiTuiJian_Adpater extends RecyclerView.Adapter<MingShiTuiJian_Adpater.Holder>{
    Context context;
    List<MingShiBean.DataBean.UsersBean> userList;
    public MingShiTuiJian_Adpater(Context context, List<MingShiBean.DataBean.UsersBean> userList) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.mingshi_tuijian_item_layout, parent, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.mingshi_tuijian_item_content.setText(userList.get(position).getIntro());
        holder.mingshi_tuijian_item_name.setText(userList.get(position).getRealname());
        Glide.with(context).load(userList.get(position).getImages()).into(holder.mingshi_tuijian_item_photo);
        if(position == 0){
            holder.mingshi_tuijian_item_tubiao.setImageResource(R.mipmap.home_level_vip_red);
        }else{
            holder.mingshi_tuijian_item_tubiao.setImageResource(R.mipmap.home_level_vip_yellow);
        }
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private final TextView mingshi_tuijian_item_content;
        private final ImageView mingshi_tuijian_item_photo;
        private final TextView mingshi_tuijian_item_name;
        private final ImageView mingshi_tuijian_item_tubiao;

        public Holder(View itemView) {
            super(itemView);
            mingshi_tuijian_item_content = itemView.findViewById(R.id.mingshi_tuijian_item_content);
            mingshi_tuijian_item_photo = itemView.findViewById(R.id.mingshi_tuijian_item_photo);
            mingshi_tuijian_item_name = itemView.findViewById(R.id.mingshi_tuijian_item_name);
            mingshi_tuijian_item_tubiao = itemView.findViewById(R.id.mingshi_tuijian_item_tubiao);
        }
    }
}
