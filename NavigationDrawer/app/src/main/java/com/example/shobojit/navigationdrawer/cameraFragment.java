package com.example.shobojit.navigationdrawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by SHOBOJIT on 11/8/2016.
 */

public class cameraFragment extends Fragment {

    View v;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        v =inflater.inflate(R.layout.shu,container,false);


        return v;
    }
}
