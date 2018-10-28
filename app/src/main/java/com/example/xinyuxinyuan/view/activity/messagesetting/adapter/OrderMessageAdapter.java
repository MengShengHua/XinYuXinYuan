package com.example.xinyuxinyuan.view.activity.messagesetting.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;

import java.util.List;

/**
 * Created by asd on 2018/5/13.
 */

public class OrderMessageAdapter extends BaseAdapter {
    private List<?> list;
    private Context context;

    public OrderMessageAdapter(List<?> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
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
        convertView = LayoutInflater.from(context).inflate(R.layout.ordermessage_adapter, null);
        TextView ordermessage_time = convertView.findViewById(R.id.ordermessage_time);
        TextView ordermessage_content = convertView.findViewById(R.id.ordermessage_content);
        TextView ordermessage_See = convertView.findViewById(R.id.ordermessage_See);
//        ordermessage_time.setText();
//        ordermessage_content.setText(list.get(position).getIntro() + "");
//        ordermessage_See
        return convertView;
    }
}
