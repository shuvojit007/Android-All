package com.example.shobojit.progressbar;

import android.content.Context;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.roger.catloadinglibrary.CatLoadingView;
import com.tt.whorlviewlibrary.WhorlView;

public class MainActivity extends AppCompatActivity {
    private Context cn;
    WhorlView whorlView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cn = this;
        whorlView = (WhorlView) this.findViewById(R.id.whorl);
        whorlView.animate();
        whorlView.isCircling();
        whorlView.start();
    }

    public void CatLoading(View v){
        CatLoadingView mView = new CatLoadingView();
        mView.show(getSupportFragmentManager(),"Loading.........");
    }

    public void InfinityLoading(View v){

      whorlView.stop();
      whorlView.setVisibility(View.GONE);

    }
}
