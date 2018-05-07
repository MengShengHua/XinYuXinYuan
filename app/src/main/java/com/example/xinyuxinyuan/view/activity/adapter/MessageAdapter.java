package com.example.xinyuxinyuan.view.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.contract.Bean.MessageRemindBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by asd on 2018/5/7.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.Holder> implements View.OnClickListener {

    private List<MessageRemindBean.DataBean> dataBeanList;

    public MessageAdapter(List<MessageRemindBean.DataBean> dataBeanList) {
        this.dataBeanList = dataBeanList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_adapter, parent, false);
        inflate.setOnClickListener(this);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        String time = formatter.format(curDate);
        MessageRemindBean.DataBean dataBean = dataBeanList.get(position);
        String type = dataBean.getType();
        switch (type) {
            case "MSG_ORDER":
                holder.messageAdapter_title.setText("订单提醒");
                holder.messageAdapter_titleImg.setBackgroundResource(R.mipmap.message_order);
                holder.messageAdapter_state.setText(dataBean.getContent());
                holder.messageAdapter_Time.setText(time);
                break;
            case "MSG_PRAISE":
                holder.messageAdapter_title.setText("赞我的");
                holder.messageAdapter_titleImg.setBackgroundResource(R.mipmap.message_praise);
                holder.messageAdapter_state.setText(dataBean.getContent());
                holder.messageAdapter_Time.setText(time);
                break;
            case "MSG_COMMENTS":
                holder.messageAdapter_title.setText("评论我的");
                holder.messageAdapter_titleImg.setBackgroundResource(R.mipmap.message_comment);
                holder.messageAdapter_state.setText(dataBean.getContent());
                holder.messageAdapter_Time.setText(time);
                break;
            case "MSG_HOMEWOK":
                holder.messageAdapter_title.setText("评论我的");
                holder.messageAdapter_titleImg.setBackgroundResource(R.mipmap.message_job);
                holder.messageAdapter_state.setText(dataBean.getContent());
                holder.messageAdapter_Time.setText(time);
                break;
            case "MSG_UNIVSTAR":
                holder.messageAdapter_title.setText("评论我的");
                holder.messageAdapter_titleImg.setBackgroundResource(R.mipmap.message_official);
                holder.messageAdapter_state.setText(dataBean.getContent());
                holder.messageAdapter_Time.setText(time);
                break;
            case "MSG_ATTENTION":
                holder.messageAdapter_title.setText("关注提醒");
                holder.messageAdapter_titleImg.setBackgroundResource(R.mipmap.message_attention);
                holder.messageAdapter_state.setText(dataBean.getContent());
                holder.messageAdapter_Time.setText(time);
                break;
        }
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return dataBeanList.size();
    }

    @Override
    public void onClick(View v) {
        if (mOnClickListener != null) {
            mOnClickListener.onClick(v, (int) v.getTag());
        }
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView messageAdapter_titleImg;
        private TextView messageAdapter_title;
        private TextView messageAdapter_state;
        private TextView messageAdapter_Time;

        public Holder(View itemView) {
            super(itemView);
            messageAdapter_titleImg = itemView.findViewById(R.id.messageAdapter_titleImg);

            messageAdapter_title = itemView.findViewById(R.id.messageAdapter_title);
//            暂无消息提醒
            messageAdapter_state = itemView.findViewById(R.id.messageAdapter_state);
            messageAdapter_Time = itemView.findViewById(R.id.messageAdapter_Time);
        }
    }

    public interface OnClickListener {
        void onClick(View v, int location);
    }

    private OnClickListener mOnClickListener;

    public void setOnClickListener(OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }
}
