package com.example.xinyuxinyuan.view.fragment.yugao.adpater;

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
import com.example.xinyuxinyuan.model.bean.YuGaoBean;
import com.example.xinyuxinyuan.utils.DataUtils;

import java.util.List;

/**
 * Created by 键盘上的手艺人 on 2018/5/7.
 */

public class YuGaoAdpater extends RecyclerView.Adapter<YuGaoAdpater.Hodler> implements View.OnClickListener {
    Context context;
    List<YuGaoBean.DataBean.ListBean> mList;
    public YuGaoAdpater(Context context, List<YuGaoBean.DataBean.ListBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public YuGaoAdpater.Hodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.yugao_item_layout, parent, false);
        Hodler hodler = new Hodler(inflate);

        inflate.setOnClickListener(this);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull YuGaoAdpater.Hodler holder, int position) {
        holder.home_yugao_item_address.setText("地址:"+mList.get(position).getAddress());
        holder.home_yugao_item_price.setText(""+mList.get(position).getPrice());
        if(position%2 == 0){
            holder.home_yugao_item_type.setText("表演");
        }else{
            holder.home_yugao_item_type.setText("声乐");
        }

        holder.home_yugao_item_yuyue.setText(""+mList.get(position).getReservationNum()+"/"+mList.get(position).getSubscribeNum());
        holder.homeyugao_item_time.setText(DataUtils.getDateToString(mList.get(position).getStartDate()));
        Glide.with(context).load(mList.get(position).getCoverImg()).into(holder.home_yugao_item_img);

        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class Hodler extends RecyclerView.ViewHolder {

        private final TextView home_yugao_item_address;
        private final ImageView home_yugao_item_img;
        private final TextView home_yugao_item_price;
        private final TextView home_yugao_item_type;
        private final TextView home_yugao_item_yuyue;
        private final TextView homeyugao_item_time;

        public Hodler(View itemView) {
            super(itemView);
            home_yugao_item_address = itemView.findViewById(R.id.home_yugao_item_address);
            home_yugao_item_img = itemView.findViewById(R.id.home_yugao_item_img);
            home_yugao_item_price = itemView.findViewById(R.id.home_yugao_item_price);
            home_yugao_item_type = itemView.findViewById(R.id.home_yugao_item_type);
            home_yugao_item_yuyue = itemView.findViewById(R.id.home_yugao_item_yuyue);
            homeyugao_item_time = itemView.findViewById(R.id.homeyugao_item_time);
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
