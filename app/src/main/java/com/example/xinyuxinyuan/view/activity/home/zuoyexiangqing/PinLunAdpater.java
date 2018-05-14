package com.example.xinyuxinyuan.view.activity.home.zuoyexiangqing;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.contract.bean.DianZanBean;
import com.example.xinyuxinyuan.contract.bean.QuXiaoDianZanBean;
import com.example.xinyuxinyuan.contract.bean.ZuoYeXiangQingBean;
import com.example.xinyuxinyuan.contract.home.DianZan;
import com.example.xinyuxinyuan.contract.home.QuXiaoDianZan;
import com.example.xinyuxinyuan.presenter.dianzan.DianZanPresenter;
import com.example.xinyuxinyuan.presenter.dianzan.QuXiaoDianZanPresenter;
import com.example.xinyuxinyuan.utils.DataUtils;
import com.example.xinyuxinyuan.utils.ShareUtils;
import com.example.xinyuxinyuan.utils.zidingyi.GlideCircleTransform;
import com.example.xinyuxinyuan.view.activity.home.huifu.HuiFuActivity;
import com.example.xinyuxinyuan.view.activity.home.zhaolaoshi.activity.XiangQingActivity;
import com.example.xinyuxinyuan.view.activity.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 键盘上的手艺人 on 2018/5/11.
 */

public class PinLunAdpater extends RecyclerView.Adapter<PinLunAdpater.Hodler> implements DianZan.View, QuXiaoDianZan.View {
    Context context;
    List<ZuoYeXiangQingBean.DataBean.CommentsBean.ListBean> list;
    private final DianZanPresenter dianZanPresenter;
    private final QuXiaoDianZanPresenter quXiaoDianZanPresenter;
    private boolean DianTag = false;
    private List<Object> myList = new ArrayList<>();
    private ZuoYeXiangQingBean.DataBean.CommentsBean.ListBean listBean;
    private int praiseNum;
    private int id;
    private int userId;

    public PinLunAdpater(Context context, List<ZuoYeXiangQingBean.DataBean.CommentsBean.ListBean> list) {
        this.context = context;
        this.list = list;
        dianZanPresenter = new DianZanPresenter(this);
        quXiaoDianZanPresenter = new QuXiaoDianZanPresenter(this);
    }

    @NonNull
    @Override
    public Hodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.pin_lun_layout, parent, false);
        Hodler hodler = new Hodler(inflate);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull final Hodler holder, final int position) {

        if(myList.size() == 0){
            myList.addAll(list);
        }
        int isPraise = list.get(position).getIsPraise();

        if (isPraise == 1) {
            holder.pin_lun_item_chect_dianzan.setChecked(true);
            DianTag = true;
        } else {
            holder.pin_lun_item_chect_dianzan.setChecked(false);
            DianTag = false;
        }


        praiseNum = list.get(position).getPraiseNum();
        holder.pin_lun_item_chect_dianzan.setText("" + praiseNum);
        holder.pin_lun_item_name.setText(list.get(position).getNickname());
        holder.pin_lun_item_neirong.setText(list.get(position).getContent());
        Glide.with(context).load(list.get(position).getPhoto()).transform(new GlideCircleTransform(context)).into(holder.pin_lun_item_image);
        holder.pin_lun_item_data.setText("" + DataUtils.getDateToStringMMDD(list.get(position).getCreateDate()));
        holder.pin_lun_item_chect_dianzan.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                isLogin();

                listBean = list.get(position);
                if (holder.pin_lun_item_chect_dianzan.isChecked()) {
                    dianZanPresenter.loadDianZanData(list.get(position).getUserId(), list.get(position).getId(), ShareUtils.getLoginUserId(), "作业评论");
                    holder.pin_lun_item_chect_dianzan.setText("" + (Integer.parseInt(holder.pin_lun_item_chect_dianzan.getText().toString()) + 1));
                } else {
                    holder.pin_lun_item_chect_dianzan.setText("" + (Integer.parseInt(holder.pin_lun_item_chect_dianzan.getText().toString()) - 1));
                    quXiaoDianZanPresenter.loadQuXiaoDianZan(list.get(position).getUserId(), list.get(position).getId(), ShareUtils.getLoginUserId(), "作业评论");
                }
            }
        });


        holder.pin_lun_item_chect_huifu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,HuiFuActivity.class);
                int id = list.get(position).getId();
                int userId = list.get(position).getUserId();
                intent.putExtra("pid",list.get(position).getId());
                intent.putExtra("userId",ShareUtils.getLoginUserId());
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void showDianZanData(DianZanBean dianZanBean) {

    }

    @Override
    public void showQuXiaoDianZanData(QuXiaoDianZanBean quXiaoDianZan) {


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


    private void isLogin() {
        if (ShareUtils.getLoginUserId() == 0) {
            Toast.makeText(context, "请您先去登录", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, LoginActivity.class);
            context.startActivity(intent);
            return;
        }
    }
}
