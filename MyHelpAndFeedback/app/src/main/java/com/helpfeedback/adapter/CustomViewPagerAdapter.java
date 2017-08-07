package com.helpfeedback.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by wucaiyan on 17-7-26.
 */

public class CustomViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList;
    private Context mContent;
    private FragmentManager mFragmentmanager;
    public CustomViewPagerAdapter (Context context , List<Fragment> fragmentList, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mContent = context;
        this.mFragmentList = fragmentList;
        this.mFragmentmanager = fragmentManager;
    }

    @Override
    public int getCount() {
        int count = 0;
        if (mFragmentList != null) {
            count = mFragmentList.size();
        }

        return count;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

}
