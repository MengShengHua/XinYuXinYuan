package com.example.xinyuxinyuan.view.fragment.baodian.adpater;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.contract.Bean.BaoDianBean;
import com.example.xinyuxinyuan.utils.DataUtils;
import com.example.xinyuxinyuan.utils.zidingyi.GlideCircleTransform;

import java.util.List;

/**
 * Created by 键盘上的手艺人 on 2018/5/7.
 */

public class FuYongAdpater extends RecyclerView.Adapter<FuYongAdpater.Hodler> {
    Context context;
    List<BaoDianBean.DataBean.ArtcircleListBean.ListBean> mList;

    public FuYongAdpater(Context context, List<BaoDianBean.DataBean.ArtcircleListBean.ListBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public Hodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.tuijian_zuoye_item_layout, parent, false);
        Hodler holder = new Hodler(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Hodler holder, int position) {
        holder.tuijian_zuoye_item_shang.setTextColor(Color.parseColor("#dfdddd"));
        holder.tuijian_zuoye_item_laizi.setVisibility(View.INVISIBLE);
        holder.tuijian_zuoye_item_shapeBut.setVisibility(View.VISIBLE);
        holder.tuijian_zuoye_item_teacher_layout.setVisibility(View.GONE);
        holder.tuijian_zuoye_item_content_yincang.setVisibility(View.VISIBLE);
        holder.tuijian_zuoye_item_pinlun.setButtonDrawable(R.mipmap.collect_normal);
        holder.tuijian_zuoye_item_dianzan.setButtonDrawable(R.mipmap.reply_normal);
        holder.tuijian_zuoye_item_shang.setButtonDrawable(R.mipmap.praise_normal);


        holder.tuijian_zuoye_item_shapeBut.setText(mList.get(position).getContentType());
        holder.tuijian_zuoye_item_userName.setText(mList.get(position).getNickname());
        holder.tuijian_zuoye_item_data.setText(DataUtils.getDateToStringMMDD(mList.get(position).getCreateDate()));
        holder.tuijian_zuoye_item_content.setText(mList.get(position).getTitle());
        holder.tuijian_zuoye_item_content_yincang.setText(mList.get(position).getContent());
        Glide.with(context).load(mList.get(position).getCoverImg()).into(holder.tuijian_zuoye_item_image);
        Glide.with(context).load(mList.get(position).getPhoto()).transform(new GlideCircleTransform(context)).into(holder.tuijian_zuoye_item_userPhoto);
        if(mList.get(position).getFavoriteNum() == 0){
            holder.tuijian_zuoye_item_pinlun.setText("");
        }else{
            holder.tuijian_zuoye_item_pinlun.setText("" + mList.get(position).getFavoriteNum());
        }

        if(mList.get(position).getCommentNum() == 0){
            holder.tuijian_zuoye_item_dianzan.setText("");
        }else{
            holder.tuijian_zuoye_item_dianzan.setText("" + mList.get(position).getCommentNum());
        }

        if(mList.get(position).getPraiseNum() == 0){
            holder.tuijian_zuoye_item_shang.setText("");
        }else{
            holder.tuijian_zuoye_item_shang.setText("" + mList.get(position).getPraiseNum());
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class Hodler extends RecyclerView.ViewHolder {
        private final TextView tuijian_zuoye_item_userName;
        private final ImageView tuijian_zuoye_item_userPhoto;
        private final ImageView tuijian_zuoye_item_image;
        private final TextView tuijian_zuoye_item_content;
        private final TextView tuijian_zuoye_item_content_yincang;
        private final TextView tuijian_zuoye_item_data;
        private final CheckBox tuijian_zuoye_item_dianzan;
        private final ImageView tuijian_zuoye_item_fenxiang;
        private final CheckBox tuijian_zuoye_item_pinlun;
        private final CheckBox tuijian_zuoye_item_shang;
        private final RelativeLayout tuijian_zuoye_item_teacher_layout;
        private final Button tuijian_zuoye_item_shapeBut;
        private final TextView tuijian_zuoye_item_laizi;

        public Hodler(View itemView) {
            super(itemView);
            tuijian_zuoye_item_userName = itemView.findViewById(R.id.tuijian_zuoye_item_userName);
            tuijian_zuoye_item_userPhoto = itemView.findViewById(R.id.tuijian_zuoye_item_userPhoto);
            tuijian_zuoye_item_image = itemView.findViewById(R.id.tuijian_zuoye_item_image);
            tuijian_zuoye_item_content = itemView.findViewById(R.id.tuijian_zuoye_item_Content);
            tuijian_zuoye_item_content_yincang = itemView.findViewById(R.id.tuijian_zuoye_item_Content_yincang);
            tuijian_zuoye_item_data = itemView.findViewById(R.id.tuijian_zuoye_item_Data);
            tuijian_zuoye_item_dianzan = itemView.findViewById(R.id.tuijian_zuoye_item_dianzan);
            tuijian_zuoye_item_fenxiang = itemView.findViewById(R.id.tuijian_zuoye_item_fenxiang);
            tuijian_zuoye_item_pinlun = itemView.findViewById(R.id.tuijian_zuoye_item_pinlun);
            tuijian_zuoye_item_shang = itemView.findViewById(R.id.tuijian_zuoye_item_shang);

            tuijian_zuoye_item_teacher_layout = itemView.findViewById(R.id.tuijian_zuoye_item_teacher_layout);
            tuijian_zuoye_item_shapeBut = itemView.findViewById(R.id.tuijian_zuoye_item_shapeBut);
            tuijian_zuoye_item_laizi = itemView.findViewById(R.id.tuijian_zuoye_item_laizis);
        }
    }
}
