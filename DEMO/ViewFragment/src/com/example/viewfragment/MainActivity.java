package com.example.viewfragment;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStrip;
import grandroid.action.Action;
import grandroid.view.Face;
import grandroid.view.LayoutMaker;

public class MainActivity extends Face {

    ViewPager viewPager;
    PagerSlidingTabStrip tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new myPagerAdapter(getSupportFragmentManager()));
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setIndicatorColor(Color.YELLOW);
        tabs.setIndicatorHeight(30);
        tabs.setViewPager(viewPager);
        //LayoutMaker maker = new LayoutMaker(this);
                
    }

    class myPagerAdapter extends FragmentPagerAdapter {

        String[] title = {"test1", "test1", "test1"};
        Fragment1 fragment1;
        Fragment2 fragment2;
        Fragment3 fragment3;

        public myPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    fragment1 = new Fragment1();
                    return fragment1;
                case 1:
                    fragment2 = new Fragment2();
                    return fragment2;
                case 2:
                    fragment3 = new Fragment3();
                    return fragment3;

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {

            return title.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

    }

}
