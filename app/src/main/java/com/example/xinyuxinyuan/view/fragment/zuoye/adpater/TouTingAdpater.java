package com.example.xinyuxinyuan.view.fragment.zuoye.adpater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.contract.bean.ZuoYeBean;
import com.example.xinyuxinyuan.utils.DataUtils;
import com.example.xinyuxinyuan.utils.zidingyi.GlideCircleTransform;

import java.util.List;

/**
 * Created by 键盘上的手艺人 on 2018/5/6.
 */

public class TouTingAdpater extends RecyclerView.Adapter<TouTingAdpater.Hodler>{
    Context context;
    List<ZuoYeBean.DataBean.ListBean> mList;


    public TouTingAdpater(Context context, List<ZuoYeBean.DataBean.ListBean> mList) {
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

        if(mList.get(position).getTUserType()==0){
            holder.tuijian_zuoye_item_teacher_layout.setVisibility(View.GONE);
        }else{
            holder.tuijian_zuoye_item_teacher_layout.setVisibility(View.VISIBLE);
        }

        holder.tuijian_zuoye_item_userName.setText( mList.get(position).getNickname());
        holder.tuijian_zuoye_item_data.setText(DataUtils.getDateToString( mList.get(position).getCreateDate()));
        holder.tuijian_zuoye_item_from.setText( mList.get(position).getSource());
        holder.tuijian_zuoye_item_content.setText( mList.get(position).getContent());
        holder.tuijian_zuoye_item_teacher_price.setText("1.0元偷看");
        holder.tuijian_zuoye_item_teachername.setText((String) mList.get(position).getTRealname());
        holder.home_masterwork_listitem_teacherDaren.setText((String) mList.get(position).getTIntro());
        Glide.with(context).load(mList.get(position).getCoverImg()).into(holder.tuijian_zuoye_item_image);
        Glide.with(context).load(mList.get(position).getPhoto()).transform(new GlideCircleTransform(context)).into(holder.tuijian_zuoye_item_userPhoto);
        Glide.with(context).load(mList.get(position).getTPhoto()).transform(new GlideCircleTransform(context)).into(holder.tuijian_zuoye_item_teacherimg);
        holder.tuijian_zuoye_item_pinlun.setText(""+ mList.get(position).getIsAnswer());
        holder.tuijian_zuoye_item_dianzan.setText(""+ mList.get(position).getPraiseNum());
        holder.tuijian_zuoye_item_shang.setText(""+ mList.get(position).getGiftNum());
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
        private final TextView tuijian_zuoye_item_from;
        private final CheckBox tuijian_zuoye_item_pinlun;
        private final CheckBox tuijian_zuoye_item_shang;
        private final TextView tuijian_zuoye_item_teacher_price;
        private final ImageView tuijian_zuoye_item_teacherimg;
        private final TextView tuijian_zuoye_item_teachername;
        private final TextView home_masterwork_listitem_teacherDaren;
        private final RelativeLayout tuijian_zuoye_item_teacher_layout;

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
            tuijian_zuoye_item_from = itemView.findViewById(R.id.tuijian_zuoye_item_From);
            tuijian_zuoye_item_pinlun = itemView.findViewById(R.id.tuijian_zuoye_item_pinlun);
            tuijian_zuoye_item_shang = itemView.findViewById(R.id.tuijian_zuoye_item_shang);
            tuijian_zuoye_item_teacher_price = itemView.findViewById(R.id.tuijian_zuoye_item_teacher_price);
            tuijian_zuoye_item_teacherimg = itemView.findViewById(R.id.tuijian_zuoye_item_teacherimg);
            tuijian_zuoye_item_teachername = itemView.findViewById(R.id.tuijian_zuoye_item_teachername);
            home_masterwork_listitem_teacherDaren = itemView.findViewById(R.id.home_masterwork_listitem_teacherDaren);
            tuijian_zuoye_item_teacher_layout = itemView.findViewById(R.id.tuijian_zuoye_item_teacher_layout);
        }
    }
}
