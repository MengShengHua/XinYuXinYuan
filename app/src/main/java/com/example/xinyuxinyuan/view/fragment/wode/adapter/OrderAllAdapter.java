package com.example.xinyuxinyuan.view.fragment.wode.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.model.bean.OrderAllBean;
import com.example.xinyuxinyuan.view.activity.wode.order.DetailsActivity;

import java.util.List;

/**
 * Created by asd on 2018/4/11.
 */

public class OrderAllAdapter extends BaseAdapter implements View.OnClickListener {
    private List<OrderAllBean.DataBean.ListBean> mlist;
    private Context context;
    private Resources getResources;
    private  Intent intent;

    public OrderAllAdapter(List<OrderAllBean.DataBean.ListBean> mlist, Context context, Resources getResources) {
        this.mlist = mlist;
        this.context = context;
        this.getResources = getResources;
        intent = new Intent(context, DetailsActivity.class);

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
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_recyadapter, parent, false);
        TextView orderAdapter_title = convertView.findViewById(R.id.orderAdapter_title);
        TextView orderAdapter_orderStatus = convertView.findViewById(R.id.orderAdapter_orderStatus);
        final ImageView orderAdapter_orderImg = convertView.findViewById(R.id.orderAdapter_orderImg);
        TextView orderAdapter_startDate = convertView.findViewById(R.id.orderAdapter_startDate);
        TextView orderAdapter_price = convertView.findViewById(R.id.orderAdapter_price);
        Button orderAdapter_btPayment = convertView.findViewById(R.id.orderAdapter_btPayment);
        LinearLayout orderAdapter_Payment = convertView.findViewById(R.id.orderAdapter_Payment);

        orderAdapter_title.setText(mlist.get(position).getTitle());
        orderAdapter_startDate.setText(mlist.get(position).getStartDate() + "");
        if (mlist.get(position).getOrderStatus() == 2) {
            orderAdapter_orderStatus.setText("已取消");
        } else {
            orderAdapter_orderStatus.setText("已购买");
        }
        orderAdapter_price.setText("$" + mlist.get(position).getPrice() + .0);
        Glide.with(context).load(mlist.get(position).getCoverImg()).into(orderAdapter_orderImg);
        orderAdapter_btPayment.setOnClickListener(this);
        orderAdapter_Payment.setOnClickListener(this);
        orderAdapter_orderImg.setOnClickListener(this);
        intent.putExtra("oid", mlist.get(position).getOid() + "");
        intent.putExtra("courseType", mlist.get(position).getType());
        return convertView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            付款
            case R.id.orderAdapter_btPayment:

                break;
//                待付款
            case R.id.orderAdapter_Payment:

                break;
//                图片
            case R.id.orderAdapter_orderImg:
//                跳转详情
                context.startActivity(intent);
                break;
        }
    }
}
