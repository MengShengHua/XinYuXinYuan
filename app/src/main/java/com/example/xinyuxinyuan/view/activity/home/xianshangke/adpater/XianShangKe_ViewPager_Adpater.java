package com.example.xinyuxinyuan.view.activity.home.xianshangke.adpater;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by 键盘上的手艺人 on 2018/5/9.
 */

public class XianShangKe_ViewPager_Adpater extends FragmentStatePagerAdapter{
    List<Fragment> mFragments;
    List<String> mTitle;
    public XianShangKe_ViewPager_Adpater(FragmentManager fm,List<Fragment> mFragments, List<String> mTitle) {
        super(fm);
        this.mFragments = mFragments;
        this.mTitle = mTitle;
    }


    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
