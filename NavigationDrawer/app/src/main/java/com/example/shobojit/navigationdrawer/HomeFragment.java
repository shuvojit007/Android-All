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

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.yoyo,container,false);
    }
}
