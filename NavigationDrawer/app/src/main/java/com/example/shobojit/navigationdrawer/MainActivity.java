package com.example.shobojit.navigationdrawer;

import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static int navItemIndex = 0;

    private static final String TAG_HOME = "home";
    private static final String TAG_PHOTOS = "second fragment";
    private static final String TAG_MOVIES = "third fragment";
    public static String CURRENT_TAG = TAG_HOME;
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.dl);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav);
        navigationView.setNavigationItemSelectedListener(this);
        mHandler = new Handler();
        loadHomeFragment();
//        if (savedInstanceState == null) {
//            navItemIndex = 0;
//            CURRENT_TAG = TAG_HOME;
//            loadHomeFragment();
//        }
    }
    public void loadHomeFragment(){
        navItemIndex = 0;
       /* if (getSupportFragmentManager().findFragmentByTag(TAG_HOME) != null) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.dl);
            drawer.closeDrawer(GravityCompat.START);
            return;
        }*/
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = new Shuvojit();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                /*fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);*/
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.dl);
        int count = getFragmentManager().getBackStackEntryCount();
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            if(navItemIndex==0){
               finish();
            }else {
                getFragmentManager().popBackStack();
            }
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        FragmentManager manager = getSupportFragmentManager();
        if (id == R.id.nav_gallery) {
            navItemIndex=id;
            //Shuvojit sh=new Shuvojit();
            FragmentTransaction transaction =manager.beginTransaction();
            transaction.replace(R.id.frame,new cameraFragment()).addToBackStack(TAG_PHOTOS).commit();

        }else if(id==R.id.nav_slideshow){
            navItemIndex=id;
            FragmentTransaction transaction =manager.beginTransaction();
            transaction.replace(R.id.frame,new HomeFragment()).addToBackStack(TAG_MOVIES).commit();
        }else if (id==R.id.nav_camera){
            loadHomeFragment();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.dl);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
