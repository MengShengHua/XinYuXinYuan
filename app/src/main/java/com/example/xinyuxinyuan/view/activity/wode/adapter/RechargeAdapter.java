package com.example.xinyuxinyuan.view.activity.wode.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.model.bean.JinDouPriceItemBean;

import java.util.List;

/**
 * Created by asd on 2018/5/10.
 */

public class RechargeAdapter extends BaseAdapter implements View.OnClickListener {
    private List<JinDouPriceItemBean.DataBean> mCountlist;
    private Context context;

    public RechargeAdapter(List<JinDouPriceItemBean.DataBean> mCountlist, Context context) {
        this.mCountlist = mCountlist;
        this.context = context;
    }


    @Override

    public int getCount() {
        return mCountlist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.recharge_adapter, null);
        inflate.setOnClickListener(this);
        TextView count = inflate.findViewById(R.id.rechareAdapter_Count);
        Button Price = inflate.findViewById(R.id.rechareAdapter_Price);
        count.setText(mCountlist.get(position).getAmountAndroid() + "");
        Price.setText(mCountlist.get(position).getPriceAndroid() + ".0");
        inflate.setTag(position);
        return inflate;
    }

    @Override
    public void onClick(View v) {
        if (mOnClickListener != null) {
            mOnClickListener.onClick(v, (int) v.getTag());
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
