package com.example.xinyuxinyuan.view.activity.wode.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.contract.bean.HobbyBean;

import java.util.List;

/**
 * Created by asd on 2018/5/12.
 */

public class HobbySchoolAdapter extends BaseAdapter {
    private List<HobbyBean.DataBean.CollegesBean> colleges;
    private Context context;

    public HobbySchoolAdapter(List<HobbyBean.DataBean.CollegesBean> colleges, Context context) {
        this.colleges = colleges;
        this.context = context;
    }

    @Override
    public int getCount() {
            return colleges.size();
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
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.hobby_adapter, null);
            holder.hobbyAdapter_content = convertView.findViewById(R.id.hobbyAdapter_content);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Log.e("专业", colleges.get(position).getName());
            holder.hobbyAdapter_content.setText(colleges.get(position).getName());
        return convertView;
    }

    public class ViewHolder {
        public TextView hobbyAdapter_content;
    }
}
