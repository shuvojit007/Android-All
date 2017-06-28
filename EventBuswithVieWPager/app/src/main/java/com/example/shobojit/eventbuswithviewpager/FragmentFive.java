package com.example.shobojit.eventbuswithviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by SHOBOJIT on 1/9/2017.
 */

public class FragmentFive extends Fragment {
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_five,container,false);
        return v;
    }
}
