package com.example.xinyuxinyuan.view.fragment.yugao;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baoyz.widget.PullRefreshLayout;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseFragment;
import com.example.xinyuxinyuan.contract.bean.YuGaoBean;
import com.example.xinyuxinyuan.contract.home.YuGao;
import com.example.xinyuxinyuan.presenter.home.YuGaoPresenter;
import com.example.xinyuxinyuan.utils.ShareUtils;
import com.example.xinyuxinyuan.view.activity.home.HomeActivity;
import com.example.xinyuxinyuan.view.fragment.yugao.adpater.YuGaoAdpater;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class YuGaoFragment extends BaseFragment implements View.OnClickListener, YuGao.View {


    private ImageView title_logo_image;
    private ImageView title_qianbi_image;
    private ImageView title_message_image;
    private TextView home_yugao_fragment_shijianText;
    private TextView home_notice_fragment_timesort_btn_singline;
    private RelativeLayout home_yugao_fragment_timesort_btn_group;
    private RecyclerView home_yugao_fragment_recyclerView;
    private PullRefreshLayout home_yugao_fragment_pullRefreshLayout;
    private RelativeLayout home_yugao_fragment_recyclerView_wu_neirong;
    private Button home_yugao_fragment_recyclerView_chongshi_btn;
    private RelativeLayout home_yugao_fragment_recyclerView_wangluo;
    private TextView home_yugao_fragment_timesort_start_tv;
    private LinearLayout home_yugao_fragment_timesort_start_group;
    private TextView home_yugao_fragment_timesort_end_tv;
    private LinearLayout home_yugao_fragment_timesort_end_group;
    private TextView home_yugao_fragment_chongzhi_text;
    private TextView home_yugao_fragment_queding_text;
    private LinearLayout home_yugao_fragment_yincang_group;
    private boolean Tag = false;
    private YuGaoPresenter yuGaoPresenter;
    private YuGaoAdpater yuGaoAdpater;
    List<YuGaoBean.DataBean.ListBean> mList = new ArrayList<>();
//    private List<>

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_yu_gao;
    }

    @Override
    protected void init(View view) {

        //实例化P层对象
        yuGaoPresenter = new YuGaoPresenter(this);

        //复用布局的id
        title_logo_image = (ImageView) view.findViewById(R.id.title_logo_image);
        title_qianbi_image = (ImageView) view.findViewById(R.id.title_qianbi_image);
        title_message_image = (ImageView) view.findViewById(R.id.title_message_image);

        home_notice_fragment_timesort_btn_singline = (TextView) view.findViewById(R.id.home_notice_fragment_timesort_btn_singline);

        //这是时间筛选的RelativeLayout
        home_yugao_fragment_timesort_btn_group = (RelativeLayout) view.findViewById(R.id.home_yugao_fragment_timesort_btn_group);
        //时间筛选
        home_yugao_fragment_shijianText = (TextView) view.findViewById(R.id.home_yugao_fragment_shijianText);

        //RecyclerView 和 上拉刷新的Layout
        home_yugao_fragment_recyclerView = (RecyclerView) view.findViewById(R.id.home_yugao_fragment_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        home_yugao_fragment_recyclerView.setLayoutManager(linearLayoutManager);

        home_yugao_fragment_pullRefreshLayout = (PullRefreshLayout) view.findViewById(R.id.home_yugao_fragment_pullRefreshLayout);

        //没有内容时候显示的Layout
        home_yugao_fragment_recyclerView_wu_neirong = (RelativeLayout) view.findViewById(R.id.home_yugao_fragment_recyclerView_wu_neirong);

        //没有网络是显示的Layout和按钮
        home_yugao_fragment_recyclerView_chongshi_btn = (Button) view.findViewById(R.id.home_yugao_fragment_recyclerView_chongshi_btn);
        home_yugao_fragment_recyclerView_wangluo = (RelativeLayout) view.findViewById(R.id.home_yugao_fragment_recyclerView_wangluo);

        //设置时间筛选开始的textView和Layout
        home_yugao_fragment_timesort_start_tv = (TextView) view.findViewById(R.id.home_yugao_fragment_timesort_start_tv);
        home_yugao_fragment_timesort_start_group = (LinearLayout) view.findViewById(R.id.home_yugao_fragment_timesort_start_group);

        //设置时间筛选结束时的textView和Layout
        home_yugao_fragment_timesort_end_tv = (TextView) view.findViewById(R.id.home_yugao_fragment_timesort_end_tv);
        home_yugao_fragment_timesort_end_group = (LinearLayout) view.findViewById(R.id.home_yugao_fragment_timesort_end_group);

        //重置和确定以及它们的Layout
        home_yugao_fragment_chongzhi_text = (TextView) view.findViewById(R.id.home_yugao_fragment_chongzhi_text);
        home_yugao_fragment_queding_text = (TextView) view.findViewById(R.id.home_yugao_fragment_queding_text);
        //点击后显示的那个布局
        home_yugao_fragment_yincang_group = (LinearLayout) view.findViewById(R.id.home_yugao_fragment_yincang_group);
        if (isNetworkAvailable(getActivity())) {
            home_yugao_fragment_recyclerView_wangluo.setVisibility(View.GONE);
        } else {
            home_yugao_fragment_recyclerView_wangluo.setVisibility(View.GONE);
        }


        home_yugao_fragment_recyclerView_chongshi_btn.setOnClickListener(this);
        home_yugao_fragment_chongzhi_text.setOnClickListener(this);
        home_yugao_fragment_queding_text.setOnClickListener(this);
        home_yugao_fragment_timesort_btn_group.setOnClickListener(this);
        title_message_image.setOnClickListener(this);
        home_yugao_fragment_timesort_start_group.setOnClickListener(this);
        home_yugao_fragment_timesort_end_group.setOnClickListener(this);

        home_yugao_fragment_yincang_group.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (home_yugao_fragment_yincang_group.getVisibility() == View.VISIBLE) {
                    home_yugao_fragment_yincang_group.setVisibility(View.GONE);
                    home_yugao_fragment_shijianText.setText("时间筛选");

                    return true;
                }
                return false;
            }
        });


        yuGaoAdpater = new YuGaoAdpater(getContext(), mList);
        home_yugao_fragment_recyclerView.setAdapter(yuGaoAdpater);

        //设置上拉刷新
        home_yugao_fragment_pullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mList.clear();
                //加载数据
                yuGaoPresenter.loadYuGaoData(1, 5, ShareUtils.getLoginUserId(), "", "");
                home_yugao_fragment_pullRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        home_yugao_fragment_pullRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
    }

    @Override
    protected void loadData() {
        //加载数据
        yuGaoPresenter.loadYuGaoData(1, 5, ShareUtils.getLoginUserId(), "", "");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_yugao_fragment_recyclerView_chongshi_btn:
                if (isNetworkAvailable(getActivity())) {
                    home_yugao_fragment_recyclerView_wangluo.setVisibility(View.GONE);
                } else {
                    home_yugao_fragment_recyclerView_wangluo.setVisibility(View.GONE);
                }
                break;
            case R.id.home_yugao_fragment_chongzhi_text:
                //重置后执行的操作
                chongzhiClick();
                break;
            case R.id.home_yugao_fragment_queding_text:
                mList.clear();
                //再次发起网络请求
                yuGaoPresenter.loadYuGaoData(1, 5, ShareUtils.getLoginUserId(), home_yugao_fragment_timesort_start_tv.getText().toString(), home_yugao_fragment_timesort_end_tv.getText().toString());
                home_yugao_fragment_recyclerView_wu_neirong.setVisibility(View.GONE);
                home_yugao_fragment_recyclerView.setVisibility(View.VISIBLE);
                home_yugao_fragment_recyclerView_wangluo.setVisibility(View.GONE);
                chongzhiClick();
                break;
            case R.id.home_yugao_fragment_timesort_btn_group:
                //这是时间筛选被点击后执行操作的方法
                shijianClick();
                break;
            case R.id.title_message_image:

                break;
            case R.id.home_yugao_fragment_timesort_start_group:
                showStartData();
                break;
            case R.id.home_yugao_fragment_timesort_end_group:
                showEndData();
                break;
        }
    }

    private void chongzhiClick() {
        home_yugao_fragment_timesort_start_tv.setText("");
        home_yugao_fragment_timesort_end_tv.setText("");
        home_yugao_fragment_shijianText.setText("时间筛选");
        home_yugao_fragment_yincang_group.setVisibility(View.GONE);
    }

    private void shijianClick() {
        if (Tag == true) {
            Tag = false;
            home_yugao_fragment_shijianText.setText("时间筛选");
            home_yugao_fragment_yincang_group.setVisibility(View.GONE);
        } else {
            Tag = true;
            home_yugao_fragment_shijianText.setText("取消");
            home_yugao_fragment_yincang_group.setVisibility(View.VISIBLE);
        }
    }


    /**
     * 这是开始的日历
     */
    public void showStartData() {

        Calendar calendar = Calendar.getInstance();

        DatePickerDialog pickDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int iyear, int monthOfYear, int dayOfMonth) {

                home_yugao_fragment_timesort_start_tv.setText(iyear + "-" + ((monthOfYear + 1)) + "-" + dayOfMonth);

            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        pickDialog.show();
    }


    /**
     * 这是结束的日历
     */
    public void showEndData() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog pickDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int iyear, int monthOfYear, int dayOfMonth) {

                home_yugao_fragment_timesort_end_tv.setText(iyear + "-" + ((monthOfYear + 1)) + "-" + dayOfMonth);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        pickDialog.show();
    }


    //得到数据
    @Override
    public void showYuGaoData(YuGaoBean yuGaoBean) {

        if (yuGaoBean.getData().getList() == null || yuGaoBean.getData().getList().size() == 0) {

            home_yugao_fragment_recyclerView_wu_neirong.setVisibility(View.VISIBLE);
            home_yugao_fragment_recyclerView.setVisibility(View.GONE);
            home_yugao_fragment_recyclerView_wangluo.setVisibility(View.GONE);

        } else {
            home_yugao_fragment_recyclerView_wu_neirong.setVisibility(View.GONE);
            home_yugao_fragment_recyclerView.setVisibility(View.VISIBLE);
            home_yugao_fragment_recyclerView_wangluo.setVisibility(View.GONE);
            if (yuGaoAdpater.getItemCount() == 0) {
                mList.addAll(yuGaoBean.getData().getList());
            }
            yuGaoAdpater.notifyDataSetChanged();
        }
    }

    /**
     * 判断网络的方法
     */

    public boolean isNetworkAvailable(Activity activity) {
        Context context = activity.getApplicationContext();
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager == null) {
            return false;
        } else {
            // 获取NetworkInfo对象
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();

            if (networkInfo != null && networkInfo.length > 0) {
                for (int i = 0; i < networkInfo.length; i++) {
                    System.out.println(i + "===状态===" + networkInfo[i].getState());
                    System.out.println(i + "===类型===" + networkInfo[i].getTypeName());
                    // 判断当前网络状态是否为连接状态
                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}


