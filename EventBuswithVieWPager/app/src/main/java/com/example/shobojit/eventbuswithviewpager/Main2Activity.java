package com.example.shobojit.eventbuswithviewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    TabLayout tab;
    ViewPager vp;
    Toolbar tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tl = (Toolbar) findViewById(R.id.tol);
        vp = (ViewPager)findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);
        setSupportActionBar(tl);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupViewpager(vp);
        tab.setupWithViewPager(vp);

    }
    public void setupViewpager (ViewPager vp){
        ViewpagerAdapter vpa = new ViewpagerAdapter(getSupportFragmentManager());
        vpa.AddFrag(new FragmentOne(),"One");
        vpa.AddFrag(new FragmentTwo(),"Two");
        vpa.AddFrag(new FragmentThree(),"Three");
        vpa.AddFrag(new FragmentFour(),"F0ur");
        vpa.AddFrag(new FragmentFive(),"Five");
        vpa.AddFrag(new FragmentSix(),"Six");
        vp.setAdapter(vpa);

    }

    class ViewpagerAdapter extends FragmentPagerAdapter{
        List<Fragment> mfraglist = new ArrayList<>();
        List<String>mfragtitle = new ArrayList<>();
        public ViewpagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mfraglist.get(position);
        }

        @Override
        public int getCount() {
            return mfraglist.size();
        }

        public void AddFrag(Fragment fgr , String st){
            mfraglist.add(fgr);
            mfragtitle.add(st);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mfragtitle.get(position);
        }
    }
}
