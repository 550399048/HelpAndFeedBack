package com.helpfeedback.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.helpfeedback.adapter.CustomViewPagerAdapter;
import com.helpfeedback.fragment.CustomFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {

    private TextView mTextViewHelp;
    private TextView mTextViewFeedback;
    private LinearLayout mTabLinearnLayout;

    private List<Fragment> mFragmentList;
    private ViewPager mViewPager;
    private CustomViewPagerAdapter mCustomViewPagerAdapter;
    private TextView[] txteViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (mFragmentList == null) {
            mFragmentList = new ArrayList<>();
        }
        initView();
        initFragmentList();

        mCustomViewPagerAdapter = new CustomViewPagerAdapter(this,mFragmentList,getSupportFragmentManager());



    }

    private void initFragmentList() {
        if (mFragmentList == null) {
            return;
        }

        Fragment helpFragment = CustomFragment.newInstance(R.string.fragment_help);
        Fragment feedbackFragment = CustomFragment.newInstance(R.string.fragment_feedback);
        Fragment drawColor = CustomFragment.newInstance(R.string.title_draw_color);
        Fragment drawcircle = CustomFragment.newInstance(R.string.title_draw_circle);
        Fragment drawRect = CustomFragment.newInstance(R.string.title_draw_rect);
        Fragment drawPoint = CustomFragment.newInstance(R.string.title_draw_point);
        Fragment drawOval = CustomFragment.newInstance(R.string.title_draw_oval);
        Fragment drawLine = CustomFragment.newInstance(R.string.title_draw_line);
        Fragment drawRoundRect = CustomFragment.newInstance(R.string.title_draw_round_rect);
        Fragment drawarc = CustomFragment.newInstance(R.string.title_draw_arc);
        Fragment drawPath = CustomFragment.newInstance(R.string.title_draw_path);
        Fragment drawhistogram =CustomFragment.newInstance(R.string.title_draw_histogram);
        Fragment drawPieChart = CustomFragment.newInstance(R.string.title_draw_pie_chart);

        mFragmentList.add(helpFragment);
        mFragmentList.add(feedbackFragment);
        mFragmentList.add(drawColor);
        mFragmentList.add(drawcircle);
        mFragmentList.add(drawRect);
        mFragmentList.add(drawPoint);
        mFragmentList.add(drawOval);
        mFragmentList.add(drawLine);
        mFragmentList.add(drawRoundRect);
        mFragmentList.add(drawarc);
        mFragmentList.add(drawPath);
        mFragmentList.add(drawhistogram);
        mFragmentList.add(drawPieChart);







        mViewPager.setAdapter(mCustomViewPagerAdapter);
        mViewPager.setOnPageChangeListener(this);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLinearnLayout = (LinearLayout) findViewById(R.id.linear_layout_tab_id);

        int count = mTabLinearnLayout.getChildCount();
        txteViews = new TextView[count];
        for (int i = 0;i<count;i++) {
            final TextView tabItem = (TextView) mTabLinearnLayout.getChildAt(i);
            txteViews[i] = tabItem;
            txteViews[i].setEnabled(true);
            txteViews[i].setTextColor(Color.BLUE);
            txteViews[i].setTag(i);
            txteViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.setCurrentItem((Integer) v.getTag());
                }
            });

            txteViews[0].setEnabled(false);

        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < txteViews.length; i++) {
            txteViews[i].setEnabled(true);
            txteViews[i].setBackgroundColor(Color.TRANSPARENT);
        }
        txteViews[position].setEnabled(false);
        txteViews[position].setBackgroundColor(Color.WHITE);

        mViewPager.setCurrentItem(0);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
