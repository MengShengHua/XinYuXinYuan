package com.example.xinyuxinyuan.view.fragment.zuoye;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import com.baoyz.widget.PullRefreshLayout;
import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.base.BaseFragment;
import com.example.xinyuxinyuan.presenter.home.ZuoYePresenter;
import com.example.xinyuxinyuan.utils.zidingyi.MyViewPager;
import com.example.xinyuxinyuan.view.fragment.zuoye.adpater.ViewPagerAdpater;
import com.example.xinyuxinyuan.view.fragment.zuoye.fragment.TouTingFragment;
import com.example.xinyuxinyuan.view.fragment.zuoye.fragment.ZhiNengFragment;
import com.example.xinyuxinyuan.view.fragment.zuoye.fragment.ZuiXinFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZuoYeFragment extends BaseFragment implements View.OnClickListener, ViewPager.OnPageChangeListener {


    private PullRefreshLayout home_zuoye_fragment_pullRefreshLayout;
    private LinearLayout home_zuoye_fragment_qiujiao_linearLayout;
    private TabLayout home_zuoye_fragment_tablayout;
    private LinearLayout home_zuoye_fragment_tijiao_linearLayout;
    private MyViewPager home_zuoye_fragment_viewPager;

    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mTitle = new ArrayList<>();
    private ViewPagerAdpater adpater;
    private int page = 1;
    private ZuoYePresenter zuoYePresenter;
    private ZhiNengFragment zhiNengFragment;
    private TouTingFragment touTingFragment;
    private ZuiXinFragment zuiXinFragment;

    public ZuoYeFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zuo_ye;
    }

    @Override
    protected void init(View view) {

        home_zuoye_fragment_pullRefreshLayout = view.findViewById(R.id.home_zuoye_fragment_pullRefreshLayout);
        home_zuoye_fragment_qiujiao_linearLayout = view.findViewById(R.id.home_zuoye_fragment_qiujiao_linearLayout);
        home_zuoye_fragment_tablayout = view.findViewById(R.id.home_zuoye_fragment_tablayout);
        home_zuoye_fragment_tijiao_linearLayout = view.findViewById(R.id.home_zuoye_fragment_tijiao_linearLayout);
        home_zuoye_fragment_viewPager = view.findViewById(R.id.home_zuoye_fragment_viewPager);

        //设置viewPager的适配器
        adpater = new ViewPagerAdpater(getChildFragmentManager(), mTitle, mFragments);
        home_zuoye_fragment_viewPager.setAdapter(adpater);
        //将tablayout和viewPager联动
        home_zuoye_fragment_tablayout.setupWithViewPager(home_zuoye_fragment_viewPager);
        home_zuoye_fragment_viewPager.setCurrentItem(0);
        //点击事件
        home_zuoye_fragment_qiujiao_linearLayout.setOnClickListener(this);
        home_zuoye_fragment_tijiao_linearLayout.setOnClickListener(this);
        //这个是设置viewPager的监听
        home_zuoye_fragment_viewPager.setOnPageChangeListener(this);

        home_zuoye_fragment_pullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                home_zuoye_fragment_pullRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        home_zuoye_fragment_pullRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
    }

    @Override
    protected void loadData() {

        if (adpater.getCount() == 0) {
            zhiNengFragment = new ZhiNengFragment();
            touTingFragment = new TouTingFragment();
            zuiXinFragment = new ZuiXinFragment();
            mFragments.add(zhiNengFragment);
            mFragments.add(touTingFragment);
            mFragments.add(zuiXinFragment);
            mTitle.add("智能筛选");
            mTitle.add("偷听最多");
            mTitle.add("最新点评");
        }
        adpater.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_zuoye_fragment_qiujiao_linearLayout:

                break;
            case R.id.home_zuoye_fragment_tijiao_linearLayout:

                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    //被选中的时候调用
    @Override
    public void onPageSelected(int position) {
//        switch (position) {
//            case 0:
//                zhiNengFragment.zuoYePresenter.loadZuoYeData(0,ShareUtils.getLoginUserId(),ShareUtils.getPage(),20);
//                break;
//            case 1:
//                zhiNengFragment.zuoYePresenter.loadZuoYeData(1,ShareUtils.getLoginUserId(),ShareUtils.getPage(),20);
//                break;
//            case 2:
//                zhiNengFragment.zuoYePresenter.loadZuoYeData(2,ShareUtils.getLoginUserId(),ShareUtils.getPage(),20);
//                break;
//        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
