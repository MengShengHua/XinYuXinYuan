package com.example.xinyuxinyuan.view.fragment.wode.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.model.bean.OrderAllBean;

import java.util.List;

/**
 * Created by asd on 2018/5/12.
 */

public class GiftConterAdapter extends BaseAdapter {
    List<OrderAllBean.DataBean.ListBean> mlist;
    Context context;


    public GiftConterAdapter(List<OrderAllBean.DataBean.ListBean> list, Context context) {
        this.mlist = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.giftconter_adapter, null);
        TextView giftConterAdpater_GifType = convertView.findViewById(R.id.giftConterAdpater_GifType);
        TextView giftConterAdpater_jindouCount = convertView.findViewById(R.id.giftConterAdpater_GifTime);
        TextView giftConterAdpater_GifTime = convertView.findViewById(R.id.giftConterAdpater_GifType);
        TextView giftConterAdpater_SenGiftName = convertView.findViewById(R.id.giftConterAdpater_SenGiftName);
        return convertView;
    }
}
