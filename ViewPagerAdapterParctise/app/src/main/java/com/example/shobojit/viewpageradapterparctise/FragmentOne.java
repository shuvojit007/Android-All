package com.example.shobojit.viewpageradapterparctise;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by SHOBOJIT on 11/6/2016.
 */

public class FragmentOne extends Fragment {
     View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
      v= inflater.inflate(R.layout.fragmentone,container,false);
        return v;
    }
}
