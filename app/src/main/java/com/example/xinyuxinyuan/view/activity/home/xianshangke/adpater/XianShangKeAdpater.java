package com.example.xinyuxinyuan.view.activity.home.xianshangke.adpater;

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
import com.example.xinyuxinyuan.model.bean.XianShangKeBean;
import com.example.xinyuxinyuan.utils.DataUtils;

import java.util.List;

/**
 * Created by 键盘上的手艺人 on 2018/5/9.
 */

public class XianShangKeAdpater extends RecyclerView.Adapter<XianShangKeAdpater.Hodler> implements View.OnClickListener {
    Context context;
    List<XianShangKeBean.DataBean.ListBean> mList;

    public XianShangKeAdpater(Context context, List<XianShangKeBean.DataBean.ListBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public Hodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.xianshangke_item_layout, parent, false);
        Hodler hodler = new Hodler(inflate);
        inflate.setOnClickListener(this);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull Hodler holder, int position) {
        holder.xianshangke_item_biaoyan.setText("表演");
        holder.xianshangke_item_jiantang.setText(mList.get(position).getType());
        holder.xianshangke_item_chongbo.setText("重播");
        holder.xianshangke_item_time.setText(DataUtils.getDateToString(mList.get(position).getStartDate()));
        holder.xianshangke_item_name.setText(mList.get(position).getNickname());
        holder.xianshangke_item_yuyue.setText(mList.get(position).getIsSubscribe()+"/"+mList.get(position).getSubscribeNum());
        if(mList.get(position).getUserType() == 3){
            holder.xianshangke_item_vipImage.setImageResource(R.mipmap.home_level_vip_yellow);
        }else{
            holder.xianshangke_item_vipImage.setImageResource(R.mipmap.home_level_vip_red);
        }
        holder.xianshangke_item_price.setText(""+mList.get(position).getPrice());
        Glide.with(context).load(mList.get(position).getCoverImg()).into(holder.xianshangke_item_img);
        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class Hodler extends RecyclerView.ViewHolder {
        private ImageView xianshangke_item_img;
        private TextView xianshangke_item_chongbo;
        private TextView xianshangke_item_time;
        private TextView xianshangke_item_name;
        private ImageView xianshangke_item_vipImage;
        private TextView xianshangke_item_biaoyan;
        private TextView xianshangke_item_jiantang;
        private TextView xianshangke_item_yuyue;
        private TextView xianshangke_item_price;
        public Hodler(View itemView) {
            super(itemView);
            xianshangke_item_img = itemView.findViewById(R.id.xianshangke_item_img);
            xianshangke_item_chongbo = itemView.findViewById(R.id.xianshangke_item_chongbo);
            xianshangke_item_time = itemView.findViewById(R.id.xianshangke_item_time);
            xianshangke_item_name = itemView.findViewById(R.id.xianshangke_item_name);
            xianshangke_item_vipImage = itemView.findViewById(R.id.xianshangke_item_vipImage);
            xianshangke_item_biaoyan = itemView.findViewById(R.id.xianshangke_item_biaoyan);
            xianshangke_item_jiantang = itemView.findViewById(R.id.xianshangke_item_jiantang);
            xianshangke_item_yuyue = itemView.findViewById(R.id.xianshangke_item_yuyue);
            xianshangke_item_price = itemView.findViewById(R.id.xianshangke_item_price);
        }
    }


        public interface MyFace{
            void setItemClick(View view, int position);
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
