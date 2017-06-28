package com.example.shobojit.viewpageradapterparctise;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHOBOJIT on 11/6/2016.
 */

public class FragmentThree extends Fragment {
    View v;
    ListView l3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragmentthree,container,false);
        List a = new ArrayList();
        a.add("Shuvojit Kar");
        a.add("Manna");
        a.add("Arup");
        a.add("Shuvo");
        a.add("Shuvojisst Kar");
        a.add("Massnna");
        a.add("Arussp");
        a.add("Shussvo");
        a.add("Shussvojit Kar");
        a.add("Massnna");
        a.add("Assrup");
        a.add("Shussvo");
        a.add("Shussvojit Kar");
        a.add("Mansvavna");
        a.add("Aruvvp");
        a.add("Shuababvo");
        a.add("Shuababvojisst Kar");
        a.add("Masababsnna");
        a.add("Arabababussp");
        a.add("Shababussvo");
        a.add("Shuababssvojit Kar");
        a.add("Masababsnna");
        a.add("Asababsrup");
        a.add("Shababussvo");
        l3 = (ListView) v.findViewById(R.id.l3);
        ArrayAdapter ar = new ArrayAdapter(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,a);
        l3.setAdapter(ar);
        return v;
    }
}
