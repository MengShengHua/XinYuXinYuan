package com.example.xinyuxinyuan.view.activity.home.zhaolaoshi.adpater;

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
import com.example.xinyuxinyuan.contract.bean.ZhaoLaoShiBean;

import java.util.List;

/**
 * Created by 键盘上的手艺人 on 2018/5/8.
 */

public class ZhaoLaoShiAdpater extends RecyclerView.Adapter<ZhaoLaoShiAdpater.Hodler> implements View.OnClickListener {
    Context context;
    List<ZhaoLaoShiBean.DataBean.ListBean> mList;
    int userType;

    public ZhaoLaoShiAdpater(Context context, List<ZhaoLaoShiBean.DataBean.ListBean> mList, int userType) {
        this.context = context;
        this.mList = mList;
        this.userType = userType;
    }


    @NonNull
    @Override
    public ZhaoLaoShiAdpater.Hodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.zhao_laoshi_item_layout, parent, false);
        Hodler hodler = new Hodler(inflate);
        inflate.setOnClickListener(this);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ZhaoLaoShiAdpater.Hodler holder, int position) {
        holder.zhao_laoshi_item_name.setText(mList.get(position).getNickname());
        holder.zhao_laoshi_item_typeText.setText(mList.get(position).getIntro());
        Glide.with(context).load(mList.get(position).getImages()).into(holder.zhao_laoshi_item_image);
        if (userType == 4) {
            holder.zhao_laoshi_item_vipImage.setImageResource(R.mipmap.home_level_vip_red);
        } else if (userType == 3) {
            holder.zhao_laoshi_item_vipImage.setImageResource(R.mipmap.home_level_vip_yellow);
        } else {
            holder.zhao_laoshi_item_vipImage.setImageResource(R.mipmap.home_level_vip_blue);
        }
        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class Hodler extends RecyclerView.ViewHolder {

        private final ImageView zhao_laoshi_item_image;
        private final TextView zhao_laoshi_item_name;
        private final TextView zhao_laoshi_item_typeText;
        private final ImageView zhao_laoshi_item_vipImage;

        public Hodler(View itemView) {
            super(itemView);
            zhao_laoshi_item_image = itemView.findViewById(R.id.zhao_laoshi_item_image);
            zhao_laoshi_item_name = itemView.findViewById(R.id.zhao_laoshi_item_name);
            zhao_laoshi_item_typeText = itemView.findViewById(R.id.zhao_laoshi_item_typeText);
            zhao_laoshi_item_vipImage = itemView.findViewById(R.id.zhao_laoshi_item_vipImage);
        }
    }



        public interface MyFace{
            void setItemClick(View view,int position);
        }
        private MyFace myFace;

        public void getItemClick(MyFace myFace){
            this.myFace = myFace;
        }

        @Override
        public void onClick(View view) {
            if(myFace != null){
                myFace.setItemClick(view, (Integer) view.getTag());
            }
        }


}
