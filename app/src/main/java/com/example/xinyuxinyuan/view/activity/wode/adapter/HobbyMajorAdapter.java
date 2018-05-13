package com.example.xinyuxinyuan.view.activity.wode.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
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

public class HobbyMajorAdapter extends BaseAdapter {
    private List<HobbyBean.DataBean.MajorsBean> majors;
    private Context context;
    private int i = 0;

    public HobbyMajorAdapter(List<HobbyBean.DataBean.MajorsBean> majors, Context context) {
        this.majors = majors;
        this.context = context;
    }

    @Override
    public int getCount() {
        return majors.size();
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.hobby_adapter, null);
        final TextView hobbyAdapter_content = inflate.findViewById(R.id.hobbyAdapter_content);
        hobbyAdapter_content.setText(majors.get(position).getName());
        hobbyAdapter_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                if (i % 2 == 1) {
                    hobbyAdapter_content.setBackgroundResource(R.drawable.shape_test);
                    hobbyAdapter_content.setTextColor(Color.parseColor("#ffffff"));
                } else {
                    hobbyAdapter_content.setBackgroundColor(R.drawable.shape_hobby);
                    hobbyAdapter_content.setTextColor(Color.parseColor("#A7A8AE"));
                }
            }
        });
        return inflate;
    }

    public class ViewHolder {
        public TextView hobbyAdapter_content;
    }
}
