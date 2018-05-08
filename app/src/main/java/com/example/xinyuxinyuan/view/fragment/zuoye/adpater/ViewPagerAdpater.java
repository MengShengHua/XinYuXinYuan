package com.example.xinyuxinyuan.view.fragment.zuoye.adpater;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by 键盘上的手艺人 on 2018/5/6.
 */

public class ViewPagerAdpater extends FragmentStatePagerAdapter{
    List<String> mTitle;
    List<Fragment> mFragments;
    public ViewPagerAdpater(FragmentManager fm,List<String> mTitle,List<Fragment> mFragments) {
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
