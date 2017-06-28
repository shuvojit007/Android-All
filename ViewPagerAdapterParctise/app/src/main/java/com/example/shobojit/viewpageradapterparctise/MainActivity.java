package com.example.shobojit.viewpageradapterparctise;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager vp;
    TabLayout tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp= (ViewPager) findViewById(R.id.vp);
        tb= (TabLayout) findViewById(R.id.tab);
        setmyFragmentToViewpager( vp);
        tb.setupWithViewPager(vp);
    }
    void setmyFragmentToViewpager(ViewPager vp){
        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager());
        vpa.addfragment(new FragmentOne(),"One");
        vpa.addfragment(new FragmentTwo(), "Two");
        vpa.addfragment(new FragmentThree(),"Three");
        vp.setAdapter(vpa);
    }


}
class ViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fraglist = new ArrayList();
     List<String> fragname = new ArrayList();
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fraglist.get(position);
    }

    void addfragment (Fragment f , String fragName){
        fraglist.add(f);
        fragname.add(fragName);
    }

    @Override
    public int getCount() {
        return fraglist.size();
    }
        /*After compilation my apps runs good but there is some problem on
            tablaylout where my Fragment title didnot shown for this i add new method name CharSequence

            This method may be called by the ViewPager to obtain a title string to describe the specified page.
            This method may return null indicating no title for this page.
            The default implementation returns null.
            Overrides: getPageTitle in class PagerAdapter
            Parameters: position - The position of the title requested
            Returns: A title for the requested page

            */
        @Override
        public CharSequence getPageTitle(int position) {

            return fragname.get(position);
        }
}
